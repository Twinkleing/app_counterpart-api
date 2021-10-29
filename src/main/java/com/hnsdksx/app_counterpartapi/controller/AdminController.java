package com.hnsdksx.app_counterpartapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnsdksx.app_counterpartapi.pojo.UserInfo;
import com.hnsdksx.app_counterpartapi.result.CommonResult;
import com.hnsdksx.app_counterpartapi.result.ResultCode;
import com.hnsdksx.app_counterpartapi.services.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "AdminController", description = "Admin操作接口")
@RequestMapping("admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ResponseBody
    @ApiOperation("数据上传")
    @PostMapping("submitFile")
    public CommonResult<JSONObject> submitFile(@RequestParam("file") MultipartFile file) throws IOException {
        ResultCode.FILE_FORMAT_ERROR.isTrue();
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
        return CommonResult.success(jsonObject);
    }

    @ResponseBody
    @ApiOperation("登录")
    @PostMapping("login")
    public CommonResult<Object> login(@RequestBody @Validated UserInfo userInfo) {
        String token = adminService.login(userInfo);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ResponseBody
    @ApiOperation("注册")
    @PostMapping("register")
    public CommonResult<String> register(@RequestBody UserInfo userInfo,
                                         HttpServletRequest request) {
        userInfo.setLast_login_ip(request.getRemoteHost());
        String msg = adminService.register(userInfo);
        return CommonResult.success(msg);
    }


}
