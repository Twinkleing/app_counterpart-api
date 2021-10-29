package com.hnsdksx.app_counterpartapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnsdksx.app_counterpartapi.pojo.ScoreLine;
import com.hnsdksx.app_counterpartapi.result.CommonResult;
import com.hnsdksx.app_counterpartapi.services.ClientService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Api(tags = "ClientController", description = "数据查询")
@RequestMapping("query")
public class ClientController {

    @Resource
    ClientService clientService;

    @ResponseBody
    @GetMapping("schoolByScore")
    public CommonResult<JSONObject> schoolByScore(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "year", required = false) String year) {
        List<ScoreLine> scoreLines = clientService.schoolByScore(name, year);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", scoreLines.size());
        jsonObject.put("scoreLines", scoreLines);
        return CommonResult.success(jsonObject);
    }
}
