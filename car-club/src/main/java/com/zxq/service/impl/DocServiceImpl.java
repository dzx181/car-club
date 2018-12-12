package com.zxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.dao.DocDao;
import com.zxq.entity.Doc;
import com.zxq.entity.Doc;
import com.zxq.entity.vo.DocVO;
import com.zxq.service.DocService;
import com.zxq.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private DocDao docDao;

    @Override
    public int addDoc(DocVO doc) {
        return docDao.fileUpload(doc);
    }

    @Override
    public int deleteDoc(List<Integer> caption) {
        return docDao.deleteFile(caption);
    }

    @Override
    public String selectDoc(Integer page, Doc doc, HttpServletRequest request){
        //模糊查询保留值
        if (doc != null) {

            request.setAttribute("blurDoc", doc);
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<Doc> list = docDao.selectFile(doc);
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("docVOList", list);
        return "doc/docList";

    }



}
