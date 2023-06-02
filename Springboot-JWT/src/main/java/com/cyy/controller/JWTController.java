package com.cyy.controller;

import com.cyy.utils.JWTUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:CYY
 * @create: 2023-05-30 19:58:41
 * @Description:
 */
@RestController
@RequestMapping("/token")
public class JWTController {
    // 创建token
    @GetMapping("/get")
    public String creatToken2(){
        return JWTUtil.createJWT("zhangsan","123");
    }

    // 解析和校验token
    @PostMapping("/test")
    public String testToken2(HttpServletRequest request, HttpServletResponse response){
        String token= request.getHeader("Authorization");
        if (JWTUtil.isVerify(token,"123")){
            return "通过";
        }
        return "失败";
    }
}
