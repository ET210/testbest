package com.cyy;

import static org.junit.Assert.assertTrue;

import com.cyy.utils.IpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.IOException;

/**
 * Unit test for simple App.
 */

@SpringBootApplication
@RunWith(SpringRunner.class)
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(
            HttpServletRequest request) throws IOException {
        //获取IP地址
        String ipAddress = IpUtils.getIpAddr(request);
        String detail = null;
        try {
            detail = IpUtils.parseIP(ipAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(detail);
    }
}
