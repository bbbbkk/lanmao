package com.lanmao.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanmao.core.dataobject.SmsDO;

public interface SmsDAO extends BaseMapper<SmsDO> {

    SmsDO selectLastOne(String mobile);
}
