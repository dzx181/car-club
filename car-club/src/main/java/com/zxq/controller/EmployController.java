package com.zxq.controller;


import com.zxq.entity.Employ;

import com.zxq.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

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
public class EmployController {
    @Autowired
    private EmployService employService;

    /**
     * 跳转到employAdd
     *
     * @param request
     * @return
     */
    @RequestMapping("/employAdd")
    public String jumpEmployAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "employ/employAdd";
    }

    /**
     * 查询消费
     *
     * @param employ
     * @param request
     * @param page
     * @return
     */
    @RequestMapping("/selectEmploy")
    public String selectEmploy(Employ employ, HttpServletRequest request, Integer page) {
        return employService.selectEmploy(page,employ, request);
    }

    /**
     * 添加消费
     *
     * @param employ
     * @param request
     * @return
     */
    @RequestMapping("/insertEmploy")
    public String insertEmploy(Employ employ, HttpServletRequest request) {
        if (employService.insertEmploy(employ) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "employ/employAdd";
    }

    /**
     * 删除消费
     *
     * @param caption
     * @return
     */
    @RequestMapping("/deleteEmploys")
    public String deleteEmploys(Integer[] caption) {
        employService.deleteEmploy(Arrays.asList(caption));
        return "redirect:/selectEmploy";

    }

    /**
     * 根据id查找消费
     *
     * @param employId
     * @param request
     * @return
     */
    @RequestMapping("/editEmploy")
    public String editEmploy(@RequestParam("employId") Integer employId, HttpServletRequest request) {
        Employ employ = employService.selectEmployByID(employId);
        request.setAttribute("employByID", employ);
        return "forward:/editEmployFrom";
    }

    /**
     * 根据给编辑页赋值
     *
     * @param request
     * @return
     */
    @RequestMapping("/editEmployFrom")
    public String editEmployFrom(HttpServletRequest request) {
        Employ employ =(Employ) request.getAttribute("employByID");
        request.setAttribute("employEdit", employ);
        return "employ/employEdit";

    }

    /**
     * 保存编辑值
     *
     * @param employ
     * @return
     */
    @RequestMapping("/saveEmploy")
    public String saveEmploy(Employ employ) {
        employService.updateEmploy(employ);
        return "redirect:/selectEmploy";

    }
}

