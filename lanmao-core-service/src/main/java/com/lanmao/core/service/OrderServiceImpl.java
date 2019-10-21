package com.lanmao.core.service;

import com.lanmao.common.base.BaseService;
import com.lanmao.common.bean.BaseResult;
import com.lanmao.common.constants.ErrorCodeEnum;
import com.lanmao.core.repository.OrderRepository;
import com.lanmao.core.share.dto.OrderDTO;
import com.lanmao.core.share.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderServiceImpl extends BaseService<OrderDTO> implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Override
    public BaseResult<Long> save(@RequestBody OrderDTO orderDTO) {
        BaseResult<Long> baseResult = new BaseResult<>();
        baseResult.setCode(ErrorCodeEnum.CODE_SUCCESS.getCode());
        try {
            Long newId = orderRepository.save(orderDTO);
            baseResult.setData(newId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return baseResult;
    }

    @Override
    public BaseResult<List<OrderDTO>> queryList(@RequestBody OrderDTO queryObj) {
        return null;
    }

    @Override
    public BaseResult<OrderDTO> queryOne(@RequestBody OrderDTO queryObj) {
        return null;
    }

    @Override
    public BaseResult<Integer> updateById(@RequestBody OrderDTO updateObj) {
        return null;
    }

    @Override
    public BaseResult<Integer> deleteById(@RequestBody OrderDTO deleteObj) {
        return null;
    }
}
