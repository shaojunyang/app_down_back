package com.example.demo2.dao;
import com.example.demo2.en.AppWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMapper {
    int insert(AppWithBLOBs record);

    List<AppWithBLOBs> find();




    int insertSelective(AppWithBLOBs record);
}