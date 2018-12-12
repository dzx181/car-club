package com.zxq.controller;


import com.zxq.entity.Profess;
import com.zxq.entity.vo.ProfessVO;
import com.zxq.service.ProfessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
public class ProfessController {
    @Autowired
    private ProfessService professService;

    /**
     * 跳转到professAdd
     *
     * @param request
     * @return
     */
    @RequestMapping("/professAdd")
    public String jumpProfessAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "profess/professAdd";
    }

    /**
     * 查询消费
     *
     * @param profess
     * @param request
     * @param page
     * @return
     */
    @RequestMapping("/selectProfess")
    public String selectProfess(Profess profess, HttpServletRequest request, Integer page) {
        return professService.selectProfess( profess,page, request);
    }

    /**
     * 添加消费
     *
     * @param profess
     * @param request
     * @return
     */
    @RequestMapping("/insertProfess")
    public String insertProfess(Profess profess, HttpServletRequest request) {
        if (professService.insertProfess(profess) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "profess/professAdd";
    }

    /**
     * 删除消费
     *
     * @param caption
     * @return
     */
    @RequestMapping("/deleteProfesss")
    public String deleteProfesss(Integer[] caption) {
        professService.deleteProfess(Arrays.asList(caption));
        return "redirect:/selectProfess";

    }

    /**
     * 根据id查找消费
     *
     * @param professId
     * @param request
     * @return
     */
    @RequestMapping("/editProfess")
    public String editProfess(@RequestParam("professId") Integer professId, HttpServletRequest request) {
        ProfessVO professVO = professService.selectProfessByID(professId);
        request.setAttribute("professByID", professVO);
        return "forward:/editProfessFrom";

    }

    /**
     * 根据给编辑页赋值
     *
     * @param request
     * @return
     */
    @RequestMapping("/editProfessFrom")
    public String editProfessFrom(HttpServletRequest request) {
        ProfessVO professVO =(ProfessVO) request.getAttribute("professByID");
        request.setAttribute("professEdit", professVO);
        return "profess/professEdit";

    }

    /**
     * 保存编辑值
     *
     * @param profess
     * @return
     */
    @RequestMapping("/saveProfess")
    public String saveProfess(Profess profess) {
        professService.updateProfess(profess);
        return "redirect:/selectProfess";
    }
}

