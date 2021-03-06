package com.lanmao.core.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lanmao.common.bean.BaseBean;
import lombok.Data;

import java.util.Date;

@Data
@TableName("lanmao_order")
public class OrderDO extends BaseBean {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String orderNo;

    private String address;

    private String linkMobile;

    private String linkName;

    private Date bookTime;

    private String status;

    private String remark;

    private String userRemark;

    private Date finishTime;

    @TableField(exist = false)
    private Integer offset;

    @TableField(exist = false)
    private Integer limit;
}
