package com.hnsdksx.app_counterpartapi.services;


import com.hnsdksx.app_counterpartapi.pojo.UserInfo;
import org.apache.poi.ss.usermodel.Row;


public interface AdminService {

    void writeData(Row row);

    UserInfo getAdminByUsername(String userName);

    String login(UserInfo userInfo);

    String register(UserInfo userInfo);
}
