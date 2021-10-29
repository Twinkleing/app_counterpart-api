package com.hnsdksx.app_counterpartapi.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hnsdksx.app_counterpartapi.mapper.ScoreLineMapper;
import com.hnsdksx.app_counterpartapi.mapper.UserMapper;
import com.hnsdksx.app_counterpartapi.pojo.ScoreLine;
import com.hnsdksx.app_counterpartapi.pojo.UserInfo;
import com.hnsdksx.app_counterpartapi.services.AdminService;

import com.hnsdksx.app_counterpartapi.util.JwtTokenUtil;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Service
public class AdminSerImp implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminSerImp.class);

    @Resource
    ScoreLineMapper scoreLineMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    UserDetailsService userDetailsService;

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void writeData(Row row) {
        ScoreLine scoreLine = new ScoreLine(
                (int) row.getCell(0).getNumericCellValue(),
                row.getCell(1).getStringCellValue(),
                String.valueOf((int) row.getCell(2).getNumericCellValue()),
                row.getCell(3).getStringCellValue(),
                row.getCell(4).getStringCellValue(),
                (int) row.getCell(5).getNumericCellValue(),
                (int) row.getCell(6).getNumericCellValue(),
                (int) row.getCell(7).getNumericCellValue(),
                (int) row.getCell(8).getNumericCellValue(),
                (int) row.getCell(9).getNumericCellValue()
        );
        scoreLineMapper.insert(scoreLine);
    }

    @Override
    public UserInfo getAdminByUsername(String userName) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public String login(UserInfo userInfo) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userInfo.getUser_name());
            if (!passwordEncoder.matches(userInfo.getPassword(), userDetails.getPassword())) {
                throw new BadCredentialsException("密码错误!");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_name", userInfo.getUser_name())
                    .set("last_login_time", simpleDateFormat.format(date));
            userMapper.update(null, updateWrapper);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String register(UserInfo userInfo) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userInfo.getUser_name())
                .select("user_name");
        List<UserInfo> userInfos = userMapper.selectList(queryWrapper);
        if (userInfos.size() > 0) {
            return "用户名已存在";
        }
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userMapper.insert(userInfo);
        return "注册成功";
    }
}
