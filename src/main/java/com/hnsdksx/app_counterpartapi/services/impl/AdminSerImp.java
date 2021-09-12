package com.hnsdksx.app_counterpartapi.services.impl;

import com.hnsdksx.app_counterpartapi.mapper.ScoreLineMapper;
import com.hnsdksx.app_counterpartapi.pojo.ScoreLine;
import com.hnsdksx.app_counterpartapi.services.AdminService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AdminSerImp implements AdminService {
    @Resource
    ScoreLineMapper scoreLineMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void writeData(Row row) {
        ScoreLine scoreLine = new ScoreLine();
        for (Cell cell : row) {
            switch (cell.getColumnIndex()) {
                case 0: {
                    scoreLine.setYear((int) cell.getNumericCellValue());
                    break;
                }
                case 1: {
                    scoreLine.setType(cell.getStringCellValue());
                    break;
                }
                case 2: {
                    scoreLine.setCode(String.valueOf((int) cell.getNumericCellValue()));
                    break;
                }
                case 3: {
                    scoreLine.setName(cell.getStringCellValue());
                    break;
                }
                case 4: {
                    scoreLine.setNature(cell.getStringCellValue());
                    break;
                }
                case 5: {
                    scoreLine.setPlans_number((int) cell.getNumericCellValue());
                    break;
                }
                case 6: {
                    scoreLine.setShift_line((int) cell.getNumericCellValue());
                    break;
                }
                case 7: {
                    scoreLine.setSub_one((int) cell.getNumericCellValue());
                    break;
                }
                case 8: {
                    scoreLine.setSub_two((int) cell.getNumericCellValue());
                    break;
                }
                case 9: {
                    scoreLine.setSub_three((int) cell.getNumericCellValue());
                    break;
                }
            }
        }
        scoreLineMapper.insert(scoreLine);
    }
}
