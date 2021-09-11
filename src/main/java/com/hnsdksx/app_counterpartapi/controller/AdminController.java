package com.hnsdksx.app_counterpartapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.hnsdksx.app_counterpartapi.pojo.School;
import com.hnsdksx.app_counterpartapi.response.GlobalConstant;
import com.hnsdksx.app_counterpartapi.response.Response;
import com.hnsdksx.app_counterpartapi.services.AdminService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @ResponseBody
    @PostMapping("submitFile")
    public Response<JSONObject> submitFile(@RequestParam("file") MultipartFile file) throws IOException {
        GlobalConstant.FILE_IS_EMPTY.isTrue(file == null);
        InputStream s = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(s);
        Sheet sheet = workbook.getSheetAt(0);
//        Row tabHead = sheet.getRow(0);
        for (Row cells : sheet) {
            if (cells.getRowNum() == 0) continue;
            adminService.writeData(cells);
        }
        String result = String.format("%.1f", file.getSize() / 1000.0);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("file_size", result + "KB");
        return Response.success(jsonObject);
    }


}
