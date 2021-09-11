package com.hnsdksx.app_counterpartapi.services.impl;

import com.hnsdksx.app_counterpartapi.mapper.AttachMapper;
import com.hnsdksx.app_counterpartapi.mapper.SchoolMapper;
import com.hnsdksx.app_counterpartapi.pojo.Attach;
import com.hnsdksx.app_counterpartapi.pojo.School;
import com.hnsdksx.app_counterpartapi.services.AdminService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminSerImp implements AdminService {
    @Resource
    SchoolMapper schoolMapper;

    @Resource
    AttachMapper attachMapper;


    @Override
    public void writeData(Row row) {
        School school = new School();
        Attach attach = new Attach();
        for (Cell cell : row) {
            switch (cell.getColumnIndex()) {
                case 0: {
                    attach.setYear((int) cell.getNumericCellValue());
                    break;
                }
                case 1: {
                    attach.setType(cell.getStringCellValue());
                    break;
                }
                case 2: {
                    school.setCode(String.valueOf((int) cell.getNumericCellValue()));
                    break;
                }
                case 3:{
//                    school
                }

            }
        }
    }
}
