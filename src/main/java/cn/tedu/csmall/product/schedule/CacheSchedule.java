package cn.tedu.csmall.product.schedule;

import cn.tedu.csmall.product.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CacheSchedule {
    @Autowired
    private IBrandService brandService;

    public CacheSchedule() {
        log.debug("创建计划任务对象：CacheSchedule");
    }


    // fixedRate：执行频率，以毫秒值为单位
    //fixedDelay:执行间隔时间,即上次执行结束后载过多久执行下一次,以毫秒为单位
    @Scheduled(fixedRate = 60 * 1000)
    public void rebuildBrandCache() {
        log.debug("执行了计划任务…………");
        brandService.rebuildCache();
        log.debug("执行计划完成!!!");
    }

}
