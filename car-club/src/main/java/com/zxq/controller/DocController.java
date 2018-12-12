package com.zxq.controller;

import com.zxq.entity.Doc;
import com.zxq.entity.User;
import com.zxq.entity.vo.DocVO;
import com.zxq.service.DocService;
import com.zxq.util.CarDownloadUtil;
import com.zxq.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Controller
public class DocController {
    @Autowired
    private DocService docService;

    /**
     * 文件下载
     *
     * @param docVO
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(DocVO docVO, HttpServletRequest request) throws IOException {
        // 下载文件路径,文件对象
        String servletPath = new File(ConstUtil.GEN_PATH).getAbsolutePath() + File.separator + docVO.getUser().getUsername();
        String path = servletPath + File.separator + docVO.getFilename();

        // 文件下载
        return CarDownloadUtil.download(path, docVO.getFilename());
    }

    /**
     * @param docVO
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(DocVO docVO, HttpServletRequest request) throws IllegalStateException, IOException {
        if (docVO.getSrcfile() != null) {
            // session中获取user
            User user = (User) request.getSession().getAttribute("user");
            docVO.setUser(user);
            // 上传文件名
            String filename = docVO.getSrcfile().getOriginalFilename();
            // 站点路径
            String servletPath = new File(ConstUtil.GEN_PATH).getAbsolutePath();
            // 为上传文件用户创建一个单独的文件夹
            File userDir = new File(servletPath + File.separator + user.getUsername());
            if (!userDir.exists()) {
                userDir.mkdir();
            }
            // 上传文件到该用户文件夹
            File file = new File(userDir + File.separator + filename);
            if (!file.getParentFile().exists()) {
                file.mkdir();
            }
            // 上传文件到路径
            docVO.getSrcfile().transferTo(file);
            // 设置doc的值
            docVO.setFilename(filename);
            docService.addDoc(docVO);
            request.setAttribute("message", "上传成功");
            return "doc/docUpload";
        }
        request.setAttribute("message", "上传文件不能为空");
        return "doc/docUpload";
    }

    /**
     * 跳转到docAdd
     *
     * @param request
     * @return
     */
    @RequestMapping("/docAdd")
    public String jumpDocAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "doc/docUpload";
    }

    /**
     * 查询文件
     *
     * @param doc
     * @param request
     * @param page
     * @return
     */
    @RequestMapping("/selectDoc")
    public String selectDoc(Doc doc, HttpServletRequest request, Integer page) {
        return docService.selectDoc(page, doc, request);
    }


    /**
     * 删除文件
     *
     * @param caption
     * @return
     */
    @RequestMapping("/deleteDocs")
    public String deleteDocs(Integer[] caption) {
        docService.deleteDoc(Arrays.asList(caption));
        return "redirect:/selectDoc";

    }

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("/toUploadFile")
    public String toUploadFile() {
        return "doc/docUpload";
    }

}
