package com.leonsh.java.code.framework.springservicedemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leonsh.java.code.framework.springservicedemo.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * HelloMapper
 *
 * @author leonsh
 * @date 2022-05-24 15:32
 **/
@Mapper
@Repository
public interface HelloMapper extends BaseMapper<User> {
    List<User> getAllUser();

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);
}
