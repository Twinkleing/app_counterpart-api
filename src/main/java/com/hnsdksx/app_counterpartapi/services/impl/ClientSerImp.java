package com.hnsdksx.app_counterpartapi.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        queryWrapper.like("name", params[0])
                .eq("year", params[1]);
        return scoreLineMapper.selectList(queryWrapper);
    }
}
