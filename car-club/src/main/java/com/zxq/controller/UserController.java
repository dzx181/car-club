package com.zxq.controller;


import com.zxq.entity.Member;
import com.zxq.entity.User;
import com.zxq.service.ConsumeService;
import com.zxq.service.MemberService;
import com.zxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public String view() {
        return "login";
    }

    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(User user, HttpServletRequest request) {
        User user1 = userService.selectUserByNameAndPass(user);
        if (user1 == null || user1.getUsername().equals("")) {
            request.setAttribute("msg", "登录名或者密码错误！");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user1);
            //初始化
            List<Member> allMemberName = memberService.selectAllMember();
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("allMemberName", allMemberName);
            return "main";
        }

    }

    /**
     * 注销退出
     *
     * @param request
     * @return
     */
    @RequestMapping("/logOff")
    public String logOff(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

    /**
     * 跳转各个页面
     *
     * @param view
     * @return
     */
    @RequestMapping("/{view}")
    public String jump(@PathVariable String view) {
        return view;
    }


    /**
     * 跳转到userAdd
     *
     * @param request
     * @return
     */
    @RequestMapping("/userAdd")
    public String jumpUserAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "user/userAdd";
    }

    /**
     * 查询用户
     *
     * @param user
     * @param request
     * @param page
     * @return
     */
    @RequestMapping("/selectUser")
    public String selectUser(User user, HttpServletRequest request, Integer page) {
        return userService.selectUser(page, user, request);
    }

    /**
     * 添加用户
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser(User user, HttpServletRequest request) {
        if (userService.insertUser(user) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "user/userAdd";
    }

    /**
     * 判断登录名是否重复
     *
     * @param user
     * @return
     */
    @RequestMapping("/isReLoginname")
    @ResponseBody
    public String isReLoginname(@RequestBody User user) {
        List<User> hasUser = userService.findUsername(user);
        if (hasUser.size() > 0) {
            // 设置为false代表登录名重复
            return "false";
        } else {
            return "true";
        }

    }

    /**
     * 删除用户
     *
     * @param caption
     * @param request
     * @return
     */
    @RequestMapping("/deleteUsers")
    public String deleteUsers(Integer[] caption, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Integer userID = user.getId();
        boolean flag = userService.isDeleteItself(caption, userID);

        if (flag) {
            request.setAttribute("isDeleteItself", flag);
            return "forward:/selectUser";
        } else {
            userService.deleteUser(Arrays.asList(caption));
            return "redirect:/selectUser";
        }

    }

    /**
     * 根据id查找用户
     *
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/editUser")
    public String editUser(@RequestParam("userId") Integer userId, HttpServletRequest request) {
        User user = userService.selectUserByID(userId);
        request.setAttribute("userByID", user);
        return "forward:/editUserFrom";

    }

    /**
     * 根据给编辑页赋值
     *
     * @param request
     * @return
     */
    @RequestMapping("/editUserFrom")
    public String editUserFrom(HttpServletRequest request) {
        User user = (User) request.getAttribute("userByID");
        request.setAttribute("userEdit", user);
        return "user/userEdit";

    }

    /**
     * 保存编辑值
     *
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        userService.updateUser(user);
        return "redirect:/selectUser";

    }

}

