package com.cyy.utils;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author:CYY
 * @create: 2023-06-13 14:29:21
 * @Description:
 */
public class IpUtils {

    /**
     * 解析Ip地址工具类，传入IP地址，返回省、市、城市、运行商，以\t分割
     */

    public static String parseIP(String ip) throws IOException {

        String result = "";
        // 关联下载的id2region.db 离线库
        File file = ResourceUtils.getFile("classpath:city/ip2region.db");
        //String dbFile = "C:\\Users\\HUAWEI\\OneDrive\\桌面\\java资料\\ip2region.db";
        try {
            DbSearcher search = new DbSearcher(new DbConfig(), String.valueOf(file));
            // 传入ip进行解析
            DataBlock dataBlock = search.btreeSearch(ip);
            // 获取解析后的数据  格式：国家|大区|省|市|运营商
            String region = dataBlock.getRegion();
            String replace = region.replace("|", ",");
            String[] splits = replace.split(",");
            for (int i = 0; i < splits.length; i++) {
                System.out.println(splits[i].toString());
            }
            if (splits.length == 5) {
                String country = splits[0];
                String province = splits[2];
                String city = splits[3];
                String operator = splits[4];
                // 拼接数据
                result = country + "\t" + province + "\t" + city + "\t" + operator;
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
