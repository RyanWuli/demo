package com.example.springboottest.entity.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`actor`")
@Getter
@Setter
@ToString
public class Actor {
    /**
     * 演员编号
     */
    @Id
    @Column(name = "`actor_id`")
    private Short actorId;

    /**
     * 演员姓氏
     */
    @Column(name = "`first_name`")
    private String firstName;

    /**
     * 演员名字
     */
    @Column(name = "`last_name`")
    private String lastName;

    /**
     * 最后修改时间
     */
    @Column(name = "`last_update`")
    private Date lastUpdate;
}