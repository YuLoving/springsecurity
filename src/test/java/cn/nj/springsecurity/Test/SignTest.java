package cn.nj.springsecurity.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

/**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.oppo.demo.api.controller.member
 *
 * @Author: 17875162050
 * @Date: 2019/4/4
 */
public class SignTest {

    public static void main(String[] args) {
        String str =
                " {\n" +
                        "  \"actionId\": \"242424\",\n" +
                        "  \"actionTime\": \"2019-02-16 10:56:55\",\n" +
                        "  \"agentCode\": \"23231212\",\n" +
                        "  \"appid\": \"experience_store\",\n" +
                        "  \"empPhone\": \"\",\n" +
                        "  \"imei\": \"370hxsviupj6bj9aPkD8t4wXBjfipx/mgl0Xxw==\",\n" +
                        "  \"orderId\": \"q11222112217991\",\n" +
                        "  \"sign\": \"DE049600BC6854EB5AE03CC905828984\",\n" +
                        "  \"ssoId\": \"6x2elfadyj1x6wx0QOhW7DWbDC1PHekfr/Di8w==\",\n" +
                        "  \"storeCode\": \"12123232\",\n" +
                        "  \"time\": 1539658829,\n" +
                        "  \"userPhone\": \"n7p9t10xplym1zf7jJTgcleF0X8walv7mC8JmA==\",\n" +
                        "  \"wxKey\": \"yuedongwechat\"\n" +
                        "}";
        JSONObject jsonObject = JSON.parseObject(str);
        Map<String, String> map1 = new HashMap<>();
        if (jsonObject != null) {
            Set<String> strings = jsonObject.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = jsonObject.getString(key);
                System.out.println(key + "___" + value);
                map1.put(key, value);
            }
        }
        String sign = getSign(map1);
        System.err.println(sign);
    }

    /**
     * 生成签名
     *
     * @param map
     * @return
     */
    public static String getSign(Map<String, String> map) {
        String result = "";
        try {
            TreeMap<String, Object> treeMap = new TreeMap<>(map);
            treeMap.remove("sign");
            Set<Map.Entry<String, Object>> entries = treeMap.entrySet();
            // 构造签名键值对的格式
            Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
            StringBuilder sb = new StringBuilder();
            String secret = "";
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                if (key == null || value == null) {
                    continue;
                }
                if ("customer_service".equals(value.toString())) {
                    secret = "f6dbad1104143069ed9339b9b46e645c";
                } else if ("experience_store".equals(value.toString())) {
                    secret = "48dbc668e8d3c57106674352fa5c63ce";
                } else if("trad_channel".equals(value.toString())){
                    secret = "b721b1ea28536bd40455c6a0d7577339";
                }
                sb.append(key + "=" + value.toString() + "&");
            }
            //体验店的密码
            String experience_store = "48dbc668e8d3c57106674352fa5c63ce";
            //trad_channel
            String trad_channel = "b721b1ea28536bd40455c6a0d7577339";
            //customer
            String customer_service = "f6dbad1104143069ed9339b9b46e645c";

            sb.append("secret=" + secret);
            result = sb.toString();
            //进行MD5加密
            result = DigestUtils.md5Hex(result).toUpperCase();
        } catch (Exception e) {
            return null;
        }
        return result;
    }
}
