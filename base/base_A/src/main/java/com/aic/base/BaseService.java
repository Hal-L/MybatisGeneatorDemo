package com.aic.base;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface BaseService<T, ID> extends IService<T> {

    /**
     * 添加记录返回行数
     *
     * @param entity
     * @return
     */
    public Integer insertSelective(T entity) throws DataAccessException;

    /**
     * 添加记录返回主键
     *
     * @param entity
     * @return
     */
    public ID insertHasKey(T entity) throws DataAccessException;

    /**
     * 批量添加
     *
     * @param entities
     * @return
     */
    public Integer insertBatch(List<T> entities) throws DataAccessException;

    /**
     * 多条件查询
     *
     * @param baseQuery
     * @return
     */
    public List<T> selectByParams(BaseQuery baseQuery) throws DataAccessException;


    /**
     * 更新单条记录
     *
     * @param entity
     * @return
     */
    public Integer updateByPrimaryKeySelective(T entity) throws DataAccessException;


    /**
     * 批量更新
     *
     * @param entities
     * @return
     */
    public Integer updateBatch(List<T> entities) throws DataAccessException;

    /**
     * 删除单条记录
     *
     * @param id
     * @return
     */
    public Integer deleteByPrimaryKey(ID id) throws DataAccessException;

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    public Integer deleteBatch(ID[] ids) throws DataAccessException;

    /**
     * 为layui封装数据
     *
     * @param baseQuery
     * @return
     */
    public Map<String, Object> queryByParamsForTable(BaseQuery baseQuery);

}
