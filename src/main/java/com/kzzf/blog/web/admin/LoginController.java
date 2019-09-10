package com.kzzf.blog.web.admin;

import com.kzzf.blog.po.User;
import com.kzzf.blog.service.UserService;
import com.kzzf.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping  // 这里不写url，则使用上面的
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user = userService.checkUser(username, MD5Util.code(password));
        if (user != null){
            user.setPassword(null);  // 不会将密码传到前端
            session.setAttribute("user", user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");  // 登出后清楚session中的user信息
        return "redirect:/admin";
    }
}
