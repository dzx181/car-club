package com.zxq.controller;


import com.zxq.entity.Member;
import com.zxq.service.MemberService;
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
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 跳转到memberAdd
     *
     * @param request
     * @return
     */
    @RequestMapping("/memberAdd")
    public String jumpMemberAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "member/memberAdd";
    }

    /**
     * 查询会员
     *
     * @param member
     * @param request
     * @param page
     * @return
     */
    @RequestMapping("/selectMember")
    public String selectMember(Member member, HttpServletRequest request, Integer page) {
        return memberService.selectMember(page,member, request);
    }

    /**
     * 添加会员
     *
     * @param member
     * @param request
     * @return
     */
    @RequestMapping("/insertMember")
    public String insertMember(Member member, HttpServletRequest request) {
        if (memberService.insertMember(member) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "member/memberAdd";
    }

    /**
     * 删除会员
     *
     * @param caption
     * @return
     */
    @RequestMapping("/deleteMembers")
    public String deleteMembers(Integer[] caption) {
        memberService.deleteMember(Arrays.asList(caption));
        return "redirect:/selectMember";

    }

    /**
     * 根据id查找会员
     *
     * @param memberId
     * @param request
     * @return
     */
    @RequestMapping("/editMember")
    public String editMember(@RequestParam("memberId") Integer memberId, HttpServletRequest request) {
        Member member = memberService.selectMemberByID(memberId);
        request.setAttribute("memberByID", member);
        return "forward:/editMemberFrom";

    }

    /**
     * 根据给编辑页赋值
     *
     * @param request
     * @return
     */
    @RequestMapping("/editMemberFrom")
    public String editMemberFrom(HttpServletRequest request) {
        Member member =(Member) request.getAttribute("memberByID");
        request.setAttribute("memberEdit", member);
        return "member/memberEdit";

    }

    /**
     * 保存编辑值
     *
     * @param member
     * @return
     */
    @RequestMapping("/saveMember")
    public String saveMember(Member member) {
        memberService.updateMember(member);
        return "redirect:/selectMember";

    }
}

