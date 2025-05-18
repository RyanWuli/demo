package com.example.springboottest.mapper;

import com.example.springboottest.entity.pojo.Actor;
import com.example.springboottest.generator.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActorMapper extends BaseMapper<Actor> {
}