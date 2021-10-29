package com.hnsdksx.app_counterpartapi.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hnsdksx.app_counterpartapi.mapper.ScoreLineMapper;
import com.hnsdksx.app_counterpartapi.pojo.ScoreLine;
import com.hnsdksx.app_counterpartapi.services.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientSerImp implements ClientService {

    @Resource
    ScoreLineMapper scoreLineMapper;

    @Override
    public List<ScoreLine> schoolByScore(String... params) {
        QueryWrapper<ScoreLine> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(params[0]), "name", params[0])
                .like(StringUtils.isNotBlank(params[1]), "type", params[1])
                .eq(StringUtils.isNotBlank(params[2]), "year", params[2])
                .eq(StringUtils.isNotBlank(params[3]), "nature", params[3])
                .apply(StringUtils.isNotBlank(params[4]), "plans_number" + params[4])
                .apply(StringUtils.isNotBlank(params[5]), "shift_line" + params[5]);
        return scoreLineMapper.selectList(queryWrapper);
    }
}
