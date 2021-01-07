package com.demo.bean;

import com.demo.properties.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * @author syp
 * 2021-01-08
 */
@Service
public class Demo {
    @Autowired
    private DemoProperties demoProperties;

    private String sayMorning() {
        return demoProperties.getMorningMsg();
    }

    private String sayAfternoon() {
        return demoProperties.getAfternoonMsg();
    }

    private String sayEvening() {
        return demoProperties.getEveningMsg();
    }


    /**
     * 外部调用方法
     * @return
     */
    public String sayHello() {
        String msg;
        int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (h < 8) {
            msg = sayMorning();
        } else if (h >= 12 && h <= 16) {
            msg = sayAfternoon();
        } else {
            msg = sayEvening();
        }

        return "[" + demoProperties.getUserName() + "] " + msg;
    }
}
