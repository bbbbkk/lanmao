package com.lanmao.core.repository;

import com.lanmao.common.base.BaseRepository;
import com.lanmao.common.constants.YesOrNoEnum;
import com.lanmao.common.utils.CommonUtils;
import com.lanmao.core.dataobject.UserDO;
import com.lanmao.core.mapper.UserDAO;
import com.lanmao.core.share.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class UserRepository extends BaseRepository<UserDTO> {

    @Resource
    private UserDAO userDAO;

    @Override
    public Long save(UserDTO saveObject) {
        UserDO record = new UserDO();
        CommonUtils.copyProperties(saveObject, record);
        userDAO.insert(record);
        saveObject.setId(record.getId());
        return record.getId();
    }

    @Override
    public UserDTO queryById(Long id) {
        UserDO record = userDAO.selectById(id);
        UserDTO resultDTO = new UserDTO();
        CommonUtils.copyProperties(record, resultDTO);
        return resultDTO;
    }

    @Override
    public List<UserDTO> queryList(UserDTO query) {
        query.setIsDeleted(YesOrNoEnum.NO.getCode());
        Map<String, Object> objMap = CommonUtils.toQueryMap(query);
        List<UserDO> list = userDAO.selectByMap(objMap);
        return CommonUtils.convertList(list, UserDTO.class);
    }

    @Override
    public UserDTO queryOne(UserDTO query) {
        List<UserDTO> list = queryList(query);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateById(UserDTO updateObject) {
        UserDO updateRecord = new UserDO();
        CommonUtils.copyProperties(updateObject, updateRecord);
        return userDAO.updateById(updateRecord);
    }
}
