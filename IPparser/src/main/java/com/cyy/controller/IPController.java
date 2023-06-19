package com.cyy.controller;

import com.cyy.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author:CYY
 * @create: 2023-06-13 17:00:22
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/a")
public class IPController {
    @GetMapping("/b")
    public String ipB(HttpServletRequest request) throws IOException {
        String ipAddress = IpUtils.getIpAddr(request);
        String s = IpUtils.parseIP(ipAddress);
        log.info("ipB: {}", s);
        return s;
    }
}
