package com.hnsdksx.app_counterpartapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.hnsdksx.app_counterpartapi.pojo.ScoreLine;
import com.hnsdksx.app_counterpartapi.response.GlobalConstant;
import com.hnsdksx.app_counterpartapi.response.Response;
import com.hnsdksx.app_counterpartapi.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("query")
public class ClientController {

    @Resource
    ClientService clientService;

    @ResponseBody
    @GetMapping("schoolByScore")
    public Response<JSONObject> schoolByScore(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam(value = "year", required = false) String year) {
        GlobalConstant.NECESSARY_PARAMS_IS_EMPTY.isNull(name);
        List<ScoreLine> scoreLines = clientService.schoolByScore(name, year);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", scoreLines.size());
        jsonObject.put("scoreLines", scoreLines);
        return Response.success(jsonObject);
    }
}
