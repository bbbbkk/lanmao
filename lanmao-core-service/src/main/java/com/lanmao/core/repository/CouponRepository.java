package com.lanmao.core.repository;

import com.lanmao.common.base.BaseRepository;
import com.lanmao.common.bean.PageDTO;
import com.lanmao.common.utils.CommonUtils;
import com.lanmao.core.dataobject.CouponDO;
import com.lanmao.core.mapper.CouponDAO;
import com.lanmao.core.share.dto.CouponDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Slf4j
public class CouponRepository extends BaseRepository<CouponDTO> {

    @Resource
    private CouponDAO couponDAO;

    @Override
    public Long save(CouponDTO saveObject) {
        CouponDO record = new CouponDO();
        CommonUtils.copyProperties(saveObject, record);
        CommonUtils.setInsertDefaultValue(record);
        couponDAO.insert(record);
        return record.getId();
    }

    @Override
    public CouponDTO queryById(Long id) {
        CouponDO record = couponDAO.selectById(id);
        if (record == null) {
            return null;
        }
        CouponDTO resultDTO = new CouponDTO();
        CommonUtils.copyProperties(record, resultDTO);
        return resultDTO;
    }

    @Override
    public List<CouponDTO> queryList(CouponDTO query) {
        CouponDO record = new CouponDO();
        CommonUtils.copyProperties(query, record);
        List<CouponDO> list = couponDAO.selectList(record);
        return CommonUtils.convertList(list, CouponDTO.class);
    }

    @Override
    public int countQueryList(CouponDTO query) {
        CouponDO record = new CouponDO();
        CommonUtils.copyProperties(query, record);
        return couponDAO.countSelectList(record);
    }

    @Override
    public CouponDTO queryOne(CouponDTO query) {
        List<CouponDTO> list = queryList(query);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateById(CouponDTO updateObject) {
        CommonUtils.setUpdateDefaultValue(updateObject);
        CouponDO record = new CouponDO();
        CommonUtils.copyProperties(updateObject, record);
        return couponDAO.updateById(record);
    }

    @Override
    public int deleteById(CouponDTO deleteObject) {
        CommonUtils.setUpdateDefaultValue(deleteObject);
        CouponDO record = new CouponDO();
        CommonUtils.copyProperties(deleteObject, record);
        return couponDAO.updateById(record);
    }

    public PageDTO<CouponDTO> queryPage(PageDTO<CouponDTO> pageDTO) {
        pageDTO.setDefaultValue();
        final Integer page = pageDTO.getPage();
        final Integer pageSize = pageDTO.getPageSize();
        final Integer offset = (page - 1) * pageSize;
        CouponDTO params = pageDTO.getParams();
        if (params == null) {
            params = new CouponDTO();
            pageDTO.setParams(params);
        }
        params.setOffset(offset);
        params.setLimit(pageSize);
        List<CouponDTO> list = queryList(params);
        int totalCount = countQueryList(params);
        pageDTO.setTotalCount(totalCount);
        pageDTO.setList(list);
        return pageDTO;
    }
}
