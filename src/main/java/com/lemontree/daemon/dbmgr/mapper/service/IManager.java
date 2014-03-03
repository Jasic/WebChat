package com.lemontree.daemon.dbmgr.mapper.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * 业务处理接口类
 */
public interface IManager<E> {

    /**
     * 根据ID查询一条记录
     *
     * @param con
     * @return
     * @throws Exception
     */
    public E findById(Connection con, Object id) throws Exception;

    /**
     * 根据ID查询一条记录
     *
     * @param con
     * @return
     * @throws Exception
     */
    public Map<?, ?> findByIdForMap(Connection con, Object id) throws Exception;

    /**
     * 根据ID集合查询记录列表
     *
     * @param con
     * @return
     * @throws Exception
     */
    public List<E> findByIds(Connection con, List<Object> idList) throws Exception;

    /**
     * 根据ID集合查询记录列表
     *
     * @param con
     * @return
     * @throws Exception
     */
    public List<Map<?, ?>> findByIdsForMap(Connection con, List<Object> idList) throws Exception;

    /**
     * 查询全部记录
     *
     * @param con
     * @return
     * @throws Exception
     */
    public List<E> findAll(Connection con) throws Exception;

    /**
     * 查询全部记录
     *
     * @param con
     * @return
     * @throws Exception
     */
    public List<Map<?, ?>> findAllForMap(Connection con) throws Exception;

    /**
     * 查询一条记录
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public E findUnique(Connection con, Map<String, Object> condition) throws Exception;

    /**
     * 查询一条记录
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public Map<?, ?> findUniqueForMap(Connection con, Map<String, Object> condition) throws Exception;

    /**
     * 根据属性一条记录
     *
     * @param con
     * @param propertyName
     * @param propertyValue
     * @return
     * @throws Exception
     */
    public E findUniqueByProperty(Connection con, String propertyName, Object propertyValue) throws Exception;

    /**
     * 根据属性一条记录
     *
     * @param con
     * @param propertyName
     * @param propertyValue
     * @return
     * @throws Exception
     */
    public Map<?, ?> findUniqueByPropertyForMap(Connection con, String propertyName, Object propertyValue) throws Exception;

    /**
     * 查询记录列表
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public List<E> findList(Connection con, Map<String, Object> condition) throws Exception;

    /**
     * 查询记录列表
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public List<Map<?, ?>> findListForMap(Connection con, Map<String, Object> condition) throws Exception;

    /**
     * 查询记录列表
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public List<E> findList(Connection con, Map<String, Object> condition, int begin, int end) throws Exception;

    /**
     * 查询记录列表
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public List<Map<?, ?>> findListForMap(Connection con, Map<String, Object> condition, int begin, int end) throws Exception;

    /**
     * 根据属性查询记录列表
     *
     * @param con
     * @param propertyName
     * @param propertyValue
     * @return
     * @throws Exception
     */
    public List<E> findListByProperty(Connection con, String propertyName, Object propertyValue) throws Exception;

    /**
     * 根据属性查询记录列表
     *
     * @param con
     * @param propertyName
     * @param propertyValue
     * @return
     * @throws Exception
     */
    public List<Map<?, ?>> findListByPropertyForMap(Connection con, String propertyName, Object propertyValue) throws Exception;

    /**
     * 根据属性查询记录列表
     *
     * @param con
     * @param propertyName
     * @param propertyValue
     * @return
     * @throws Exception
     */
    public List<E> findListByProperty(Connection con, String propertyName, Object propertyValue, int begin, int end) throws Exception;

    /**
     * 根据属性查询记录列表
     *
     * @param con
     * @param propertyName
     * @param propertyValue
     * @return
     * @throws Exception
     */
    public List<Map<?, ?>> findListByPropertyForMap(Connection con, String propertyName, Object propertyValue, int begin, int end) throws Exception;

    /**
     * 增加一条记录
     *
     * @param con
     * @param entity
     * @return
     * @throws Exception
     */
    public int add(Connection con, E entity) throws Exception;

    /**
     * 根据ID更新记录, 实体的变量只要不为null就会更新数据库
     *
     * @param con
     * @param entity
     * @param id
     * @return
     * @throws Exception
     */
    public int updateById(Connection con, E entity, Object id) throws Exception;

    /**
     * 根据ID集更新记录, 实体的变量只要不为null就会更新数据库
     *
     * @param con
     * @param entity
     * @param idList
     * @return
     * @throws Exception
     */
    public int updateByIds(Connection con, E entity, List<Object> idList) throws Exception;

    /**
     * 更新记录, 实体的变量只要不为null就会更新数据库
     *
     * @param con
     * @param entity
     * @param condition
     * @return
     * @throws Exception
     */
    public int update(Connection con, E entity, Map<String, Object> condition) throws Exception;

    /**
     * 更新全部记录, 实体的变量只要不为null就会更新数据库
     *
     * @param con
     * @param entity
     * @return
     * @throws Exception
     */
    public int updateAll(Connection con, E entity) throws Exception;

    /**
     * 根据ID删除一条记录
     *
     * @param con
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteById(Connection con, Object id) throws Exception;

    /**
     * 根据ID集删除记录
     *
     * @param con
     * @param idList
     * @return
     * @throws Exception
     */
    public int deleteByIds(Connection con, List<Object> idList) throws Exception;

    /**
     * 删除记录
     *
     * @param con
     * @param condition
     * @return
     * @throws Exception
     */
    public int delete(Connection con, Map<String, Object> condition) throws Exception;

    /**
     * 删除全部记录
     *
     * @param con
     * @return
     * @throws Exception
     */
    public int deleteAll(Connection con) throws Exception;

    /**
     * 批量增加多条记录
     *
     * @param con
     * @param list
     * @return
     * @throws Exception
     */
    public int[] batchAdd(Connection con, List<E> list) throws Exception;

    /**
     * 批量增加多条记录
     *
     * @param getAutoTransactionConnection()
     * @param list
     * @return
     * @throws Exception
     */
    public int[] batchAdd(List<E> list, Map<String, Object> map) throws Exception;

}
