package com.example.springboottest.generator.base;


import com.example.springboottest.generator.provider.MySelectProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @Author: Ryan
 * @Date: 2024/12/27 9:56
 * @Version: 1.0
 * @Description: add the description
 */
public interface SelectMapper<T> extends Mapper<T> {

    @SelectProvider(type = MySelectProvider.class, method = MySelectProvider.M_SELECT_BY_ID)
    T selectById(T t);

}
