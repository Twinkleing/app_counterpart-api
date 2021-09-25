package com.hnsdksx.app_counterpartapi.services;

import com.hnsdksx.app_counterpartapi.pojo.ScoreLine;

import java.util.List;

public interface ClientService {
    List<ScoreLine> schoolByScore(String ...params);
}
