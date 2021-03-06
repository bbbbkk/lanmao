package com.lanmao.core.share.dto;

import com.lanmao.common.bean.BaseBean;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO extends BaseBean {

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

    private List<OrderGuestDTO> guestList; //客次

    private List<ProductDTO> productList; //项目

    private List<MechDTO> mechList; //技师
}
