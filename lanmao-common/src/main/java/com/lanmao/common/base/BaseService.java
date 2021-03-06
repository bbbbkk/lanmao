package com.lanmao.common.base;

import com.lanmao.common.bean.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class BaseService<T> {

    /**
     *
     * 保存核心对象
     * @param saveObject
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public abstract BaseResult<Long> save(@RequestBody T saveObject);


    /**
     * 查询List
     * @param queryObj
     * @return
     */
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public abstract BaseResult<List<T>> queryList(@RequestBody T queryObj);


    /**
     * 查询对象
     * @param queryObj
     * @return
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public abstract BaseResult<T> queryOne(@RequestBody T queryObj);


    /**
     *
     * 根据主键Id更新
     * @param updateObj
     * @return
     */
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public abstract BaseResult<Integer> updateById(@RequestBody T updateObj);


    /**
     *
     * 根据主键删除
     * @param deleteObj
     * @return
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public abstract BaseResult<Integer> deleteById(@RequestBody T deleteObj);
}
