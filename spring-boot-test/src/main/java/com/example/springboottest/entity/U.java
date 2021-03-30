package com.example.springboottest.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 16:50
 * @Version: 1.0
 * @Description:
 */
public class U implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer id;

    private String uName;

    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JSONField(name="uName")
    public String getuName() {
        return uName;
    }

    @JSONField(name="uName")
    public void setuName(String uName) {
        this.uName = uName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
