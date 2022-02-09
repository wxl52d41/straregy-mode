package com.boommanpro.springenumstrategypattern.module.report.controller;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.service.GeneratorContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/5/4 18:47
 */
@RestController
@RequestMapping("api/report")
public class ReportController {

    @Autowired
    private GeneratorContextService generatorContextService;

    //http://localhost:8089/api/report/generatorReport?dataId=demoData&type=QUERY_PROCESS
    @GetMapping("generatorReport")
    public String generatorReport(@RequestParam String dataId, @RequestParam ProcessType type) {

        generatorContextService.generatorContext(dataId,type);

        return "SUCCESS";
    }
}
