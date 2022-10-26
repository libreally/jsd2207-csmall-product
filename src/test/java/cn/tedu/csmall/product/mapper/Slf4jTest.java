package cn.tedu.csmall.product.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
public class Slf4jTest {

    @Test
    void test(){
        log.info("info 日志");
        log.error("error 日志");
        log.debug("debug 日志");
        log.warn("warn 警告日志");
        log.trace("trace 追踪日志");
    }
}
