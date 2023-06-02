package com.cyy.utils;

/**
 * @author:CYY
 * @create: 2023-05-30 19:56:36
 * @Description:
 */
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * JWT的工具类
 */
@Component
public class JWTUtil {

    // 生成签名的秘钥(来自配置文件项的jwt.secret)
    private static String key;

    // jwt过期时间
    private static long ttlMillis;

    // 静态属性的注入必须显示set方法
    // import org.springframework.beans.factory.annotation.Value;
    // (来自配置文件项的jwt.secret)
    @Value("${jwt.secret}")
    public void setKey(String secret) {
        key = secret;
    }

    // (来自配置文件项的jwt.expire)
    @Value("${jwt.expire}")
    public void setTtlMillis(Long expire) {
        ttlMillis = expire;
    }

    /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法
     *
     * @param username 用户名
     * @param password 用户密码
     * @return token串
     */
    public static String createJWT(String username, String password) {
        // 使用的签名算法（header部分，jjwt包已封装，此处直接调用）
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 计算时间 （在后续使用）
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 创建payload的私有声明（在后续使用）
        //（此处是存放的用户名和密码）
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("username", username);
        claims.put("password", password);

        // 通过JwtBuilder，设置jwt的body部分
        JwtBuilder builder = Jwts.builder()
                // 给builder的claim赋值（放入 payload 的私有声明，必须先写）
                .setClaims(claims)
                // 设置JWT ID（JWT的唯一标识）
                // 根据业务需要设置为一个不重复的值，用来作为一次性token, 从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                // 设置jwt的签发时间
                .setIssuedAt(now)
                // 所有人，作为用户的唯一标志
                .setSubject(username)
                // 设置秘钥
                .signWith(signatureAlgorithm, key);

        //设置过期时间
        if (ttlMillis >= 0) {
            // 相对于当前时刻，在 ttlMillis 属性设置的时间后过期
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }


    /**
     * Token的解密
     *
     * @param token 加密后的token
     * @return 解密后的token
     */
    public static Claims parseJWT(String token) {
        // 使默认的JWT解析器
        Claims claims = Jwts.parser()
                // 秘钥
                .setSigningKey(key)
                // 获取 token 的内容
                .parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 校验token
     * （校验逻辑是：token 携带的password 是否与传入的密码一致
     *
     * @param token    原始token（加密的）
     * @param password 传入的密码
     * @return 是否校验成功
     */
    public static Boolean isVerify(String token, String password) {
        try {
            // 调用上面写的parseJWT方法
            Claims claims = parseJWT(token);
            // 校验
            if (claims.get("password").equals(password)) {
                return true;
            }
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        }
        return false;
    }
}
