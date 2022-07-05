package com.non7.members.test;

import com.non7.members.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class serviceTest {
    @Autowired
    private ReportService reportService;

    /**
     * OrderClient#findOrderCountByDate(String) timed-out and no fallback available.需要设置熔断器Hystrix
     * @throws Exception
     */
    @Test
    public void getBusinessReportData() throws Exception {
        Map<String, Object> report = reportService.getBusinessReportData();
        System.out.println(report);
    }
}
