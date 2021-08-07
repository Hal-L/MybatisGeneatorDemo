package com.aic.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aic.base.BaseQuery;
import com.aic.base.BaseService;
import com.aic.base.MyBaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T, ID> extends ServiceImpl<MyBaseMapper<T, ID>, T> implements BaseService<T, ID> {

    @Autowired
    private MyBaseMapper<T, ID> baseMapper;

    /**
     * 添加记录返回行数
     *
     * @param entity
     * @return
     */
    public Integer insertSelective(T entity) throws DataAccessException {
        return baseMapper.insertSelective(entity);
    }

    /**
     * 添加记录返回主键
     *
     * @param entity
     * @return
     */
    public ID insertHasKey(T entity) throws DataAccessException {
        baseMapper.insertHashKey(entity);
        try {
            return (ID) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 批量添加
     *
     * @param entities
     * @return
     */
    public Integer insertBatch(List<T> entities) throws DataAccessException {
        return baseMapper.insertBatch(entities);
    }


    /**
     * 多条件查询
     *
     * @param baseQuery
     * @return
     */
    public List<T> selectByParams(BaseQuery baseQuery) throws DataAccessException {
        return baseMapper.selectByParams(baseQuery);
    }

    /**
     * 批量更新
     *
     * @param entities
     * @return
     */
    public Integer updateBatch(List<T> entities) throws DataAccessException {
        return baseMapper.updateBatch(entities);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    public Integer deleteBatch(ID[] ids) throws DataAccessException {
        return baseMapper.deleteBatch(ids);
    }

    /**
     * 为layui封装数据
     *
     * @param baseQuery
     * @return
     */
    public Map<String, Object> queryByParamsForTable(BaseQuery baseQuery) {
        Map<String, Object> result = new HashMap<String, Object>(16);
        PageHelper.startPage(baseQuery.getPage(), baseQuery.getLimit());
        PageInfo<T> pageInfo = new PageInfo<T>(selectByParams(baseQuery));
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        result.put("code", 0);
        result.put("msg", "没有查询到任何符合条件的数据");
        return result;
    }

}
