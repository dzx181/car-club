package com.zxq.controller;


import com.zxq.entity.Member;
import com.zxq.entity.Consume;
import com.zxq.entity.vo.ConsumeVO;
import com.zxq.service.MemberService;
import com.zxq.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    /**
     * 跳转到consumeAdd
     *
     * @param request
     * @return
     */
    @RequestMapping("/consumeAdd")
    public String jumpConsumeAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "consume/consumeAdd";
    }

    /**
     * 查询消费
     *
     * @param consume
     * @param request
     * @param page
     * @return
     */
    @RequestMapping("/selectConsume")
    public String selectConsume(Consume consume, HttpServletRequest request, Integer page) {
        return consumeService.selectConsume( consume,page, request);
    }

    /**
     * 添加消费
     *
     * @param consume
     * @param request
     * @return
     */
    @RequestMapping("/insertConsume")
    public String insertConsume(Consume consume, HttpServletRequest request) {
        if (consumeService.insertConsume(consume) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "consume/consumeAdd";
    }

    /**
     * 删除消费
     *
     * @param caption
     * @return
     */
    @RequestMapping("/deleteConsumes")
    public String deleteConsumes(Integer[] caption) {
        consumeService.deleteConsume(Arrays.asList(caption));
            return "redirect:/selectConsume";

    }

    /**
     * 根据id查找消费
     *
     * @param consumeId
     * @param request
     * @return
     */
    @RequestMapping("/editConsume")
    public String editConsume(@RequestParam("consumeId") Integer consumeId, HttpServletRequest request) {
        ConsumeVO consumeVO = consumeService.selectConsumeByID(consumeId);
        request.setAttribute("consumeByID", consumeVO);
        return "forward:/editConsumeFrom";

    }

    /**
     * 根据给编辑页赋值
     *
     * @param request
     * @return
     */
    @RequestMapping("/editConsumeFrom")
    public String editConsumeFrom(HttpServletRequest request) {
        ConsumeVO consumeVO =(ConsumeVO) request.getAttribute("consumeByID");
        request.setAttribute("consumeEdit", consumeVO);
        return "consume/consumeEdit";

    }

    /**
     * 保存编辑值
     *
     * @param consume
     * @return
     */
    @RequestMapping("/saveConsume")
    public String saveConsume(Consume consume) {
        consumeService.updateConsume(consume);
        return "redirect:/selectConsume";

    }
}

