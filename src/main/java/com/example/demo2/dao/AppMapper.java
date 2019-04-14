package com.example.demo2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo2.en.App;
import com.example.demo2.en.AppWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppMapper {
    int deleteByPrimaryKey(Integer id);


    AppWithBLOBs findByShortId(@Param("shortId") String shortId);


    int insert(AppWithBLOBs record);

    List<AppWithBLOBs> find();

    Integer countByIdAndPassword(@Param("id") Integer id, @Param("password") String password);

    int insertSelective(AppWithBLOBs record);

    AppWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AppWithBLOBs record);

    int updateByPrimaryKey(App record);

}