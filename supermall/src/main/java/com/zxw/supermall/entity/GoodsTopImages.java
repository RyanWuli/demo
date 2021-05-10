package com.zxw.supermall.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Ryan
 * @since 2020-08-20
 */
@Data
@TableName("goods_top_images")
@EqualsAndHashCode(callSuper = false)
public class GoodsTopImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;


    private String iid;

    private String url;


}
