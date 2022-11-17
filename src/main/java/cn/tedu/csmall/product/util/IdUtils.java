package cn.tedu.csmall.product.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class IdUtils {
    /**
     * 获取Id
     * @return ID值
     */
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    private static Random random = new Random();


    public static long getId(){
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        int i = random.nextInt(89) + 10;
        String result = format + i;
        long id = Long.parseLong(result);
        return id;
    }
}
