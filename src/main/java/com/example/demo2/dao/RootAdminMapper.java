package com.example.demo2.dao;
import com.example.demo2.en.RootAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RootAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RootAdmin record);

    List<Integer> findId();



    int insertSelective(RootAdmin record);

    RootAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RootAdmin record);

    Integer countByMobileAndPassword(@Param("mobile") String mobile, @Param("password") String password);


    int updateByPrimaryKey(RootAdmin record);



}