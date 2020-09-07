package com.zxw.supermall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private String iid;

    @TableField("orgPrice")
    private String orgPrice;

    private String price;

    private String title;

    private Integer sale;


}
