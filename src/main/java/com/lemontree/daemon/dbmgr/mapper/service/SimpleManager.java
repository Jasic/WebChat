package com.lemontree.daemon.dbmgr.mapper.service;

import cn.tisson.framework.annotation.Transaction;
import cn.tisson.framework.dao.jdbc.GenericDAO;
import cn.tisson.framework.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 单表业务逻辑操作基类
 * 
 * @author BrainstorM
 * 
 * @param <D>
 */
public class SimpleManager<E, D extends GenericDAO<E>> extends BaseManager {

	// 日志处理
	private static final Logger logger = LoggerFactory.getLogger(SimpleManager.class);

	// 泛型的class
	protected Class<D> daoClass;

	// dao处理类
	protected D dao;
	
	/**
	 * 构造函数，初始化
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected SimpleManager() {
		daoClass = ReflectionUtils.getSuperClassGenricType(getClass(), 1);

		try {
			dao = daoClass.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("SimpleManager初始化失败: ", e);
		} 
	}

	/**
	 * 根据ID查询一条记录
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public E findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(getAutoTransactionConnection(), id);
	}

	/**
	 * 根据ID查询一条记录
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public Map<?, ?> findByIdForMap(Object id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null) {
			return null;
		}

		return dao.findByIdForMap(getAutoTransactionConnection(), id);
	}

	/**
	 * 根据ID集合查询记录列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<E> findByIds(List<Object> idList) throws Exception {
		// TODO Auto-generated method stub
		if (idList == null || idList.size() <= 0) {
			return null;
		}

		return dao.findByIds(getAutoTransactionConnection(), idList);
	}

	/**
	 * 根据ID集合查询记录列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<Map<?, ?>> findByIdsForMap(List<Object> idList) throws Exception {
		// TODO Auto-generated method stub
		if (idList == null || idList.size() <= 0) {
			return null;
		}

		return dao.findByIdsForMap(getAutoTransactionConnection(), idList);
	}

	/**
	 * 查询全部记录
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<E> findAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll(getAutoTransactionConnection());
	}

	/**
	 * 查询全部记录
	 * 
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<Map<?, ?>> findAllForMap() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAllForMap(getAutoTransactionConnection());
	}

	/**
	 * 查询一条记录
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public E findUnique(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		return dao.findUnique(getAutoTransactionConnection(), condition);
	}

	/**
	 * 查询一条记录
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public Map<?, ?> findUniqueForMap(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		return dao.findUniqueForMap(getAutoTransactionConnection(), condition);
	}

	/**
	 * 根据属性一条记录
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public E findUniqueByProperty(String propertyName, Object propertyValue) throws Exception {
		// TODO Auto-generated method stub
		if (propertyName == null || propertyName.trim().length() <= 0) {
			return null;
		}

		return dao.findUniqueByProperty(getAutoTransactionConnection(), propertyName, propertyValue);
	}

	/**
	 * 根据属性一条记录
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public Map<?, ?> findUniqueByPropertyForMap(String propertyName, Object propertyValue) throws Exception {
		// TODO Auto-generated method stub
		if (propertyName == null || propertyName.trim().length() <= 0) {
			return null;
		}

		return dao.findUniqueByPropertyForMap(getAutoTransactionConnection(), propertyName, propertyValue);
	}

	/**
	 * 查询记录列表
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<E> findList(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		return dao.findList(getAutoTransactionConnection(), condition);
	}

	/**
	 * 查询记录列表
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<Map<?, ?>> findListForMap(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		return dao.findListForMap(getAutoTransactionConnection(), condition);
	}

	/**
	 * 查询记录列表
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<E> findList(Map<String, Object> condition, int begin, int end) throws Exception {
		// TODO Auto-generated method stub
		return dao.findList(getAutoTransactionConnection(), condition, begin, end);
	}

	/**
	 * 查询记录列表
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<Map<?, ?>> findListForMap(Map<String, Object> condition, int begin, int end) throws Exception {
		// TODO Auto-generated method stub
		return dao.findListForMap(getAutoTransactionConnection(), condition, begin, end);
	}

	/**
	 * 根据属性查询记录列表
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<E> findListByProperty(String propertyName, Object propertyValue) throws Exception {
		// TODO Auto-generated method stub
		if (propertyName == null || propertyName.trim().length() <= 0) {
			return null;
		}

		return dao.findListByProperty(getAutoTransactionConnection(), propertyName, propertyValue);
	}

	/**
	 * 根据属性查询记录列表
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<Map<?, ?>> findListByPropertyForMap(String propertyName, Object propertyValue) throws Exception {
		// TODO Auto-generated method stub
		if (propertyName == null || propertyName.trim().length() <= 0) {
			return null;
		}

		return dao.findListByPropertyForMap(getAutoTransactionConnection(), propertyName, propertyValue);
	}

	/**
	 * 根据属性查询记录列表
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<E> findListByProperty(String propertyName, Object propertyValue, int begin, int end) throws Exception {
		// TODO Auto-generated method stub
		if (propertyName == null || propertyName.trim().length() <= 0) {
			return null;
		}

		return dao.findListByProperty(getAutoTransactionConnection(), propertyName, propertyValue, begin, end);
	}

	/**
	 * 根据属性查询记录列表
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws Exception
	 */
	@Transaction("readOnly")
	public List<Map<?, ?>> findListByPropertyForMap(String propertyName, Object propertyValue, int begin, int end) throws Exception {
		// TODO Auto-generated method stub
		if (propertyName == null || propertyName.trim().length() <= 0) {
			return null;
		}
		
		return dao.findListByPropertyForMap(getAutoTransactionConnection(), propertyName, propertyValue, begin, end);
	}


	/**
	 * 根据ID更新记录, 实体的变量只要不为null就会更新数据库
	 * 
	 * @param entity
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateById(E entity, Object id) throws Exception {
		// TODO Auto-generated method stub
		if (entity == null)
			return 0;

		return dao.updateById(getAutoTransactionConnection(), entity, id);
	}

	/**
	 * 根据ID集更新记录, 实体的变量只要不为null就会更新数据库
	 * 
	 * @param entity
	 * @param idList
	 * @return
	 * @throws Exception
	 */
	public int updateByIds(E entity, List<Object> idList) throws Exception {
		// TODO Auto-generated method stub
		if (entity == null)
			return 0;

		return dao.updateByIds(getAutoTransactionConnection(), entity, idList);
	}

	/**
	 * 更新记录, 实体的变量只要不为null就会更新数据库
	 * 
	 * @param entity
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public int update(E entity, Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		if (entity == null || condition == null || condition.size() <= 0) {
			return 0;
		}

		return dao.update(getAutoTransactionConnection(), entity, condition);
	}

	/**
	 * 更新全部记录, 实体的变量只要不为null就会更新数据库
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int updateAll(E entity) throws Exception {
		// TODO Auto-generated method stub
		if (entity == null)
			return 0;

		return dao.updateAll(getAutoTransactionConnection(), entity);
	}

	/**
	 * 根据ID删除一条记录
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteById(getAutoTransactionConnection(), id);
	}

	/**
	 * 根据ID集删除记录
	 * 
	 * @param idList
	 * @return
	 * @throws Exception
	 */
	public int deleteByIds(List<Object> idList) throws Exception {
		// TODO Auto-generated method stub
		if (idList == null || idList.size() <= 0) {
			return 0;
		}

		return dao.deleteByIds(getAutoTransactionConnection(), idList);
	}

	/**
	 * 删除记录
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public int delete(Map<String, Object> condition) throws Exception {
		// TODO Auto-generated method stub
		if (condition == null || condition.size() <= 0) {
			return 0;
		}

		return dao.delete(getAutoTransactionConnection(), condition);
	}

	/**
	 * 删除全部记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public int deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteAll(getAutoTransactionConnection());
	}


    /**
     * 增加一条记录
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public int add(E entity) throws Exception {
        // TODO Auto-generated method stub
        if (entity == null)
            return 0;

        return dao.add(getAutoTransactionConnection(), entity);
    }

    /**
     * 增加一条记录(自增ID）
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public int addWithoutId(E entity) throws Exception {
        // TODO Auto-generated method stub
        if (entity == null)
            return 0;

        return dao.addWithoutId(getAutoTransactionConnection(), entity);
    }

	/**
	 * 批量增加多条记录
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int[] batchAdd(List<E> list) throws Exception {
		// TODO Auto-generated method stub
		if (list == null || list.size() <= 0)
			return null;

		return dao.batchAdd(getAutoTransactionConnection(), list);
	}

    /**
     * 批量增加多条记录
     *
     * @param list
     * @return
     * @throws Exception
     */
    public int[] batchAddWithoutId(List<E> list) throws Exception {
        // TODO Auto-generated method stub
        if (list == null || list.size() <= 0)
            return null;

        return dao.batchAddWithoutId(getAutoTransactionConnection(), list);
    }
	/**
	 * 批量增加多条记录
	 * 
	 * @param list
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int[] batchAdd(List<E> list, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		if (list == null || list.size() <= 0)
			return null;

		return dao.batchAdd(getAutoTransactionConnection(), list, map);
	}

    /**
     * 批量增加多条记录
     *
     * @param list
     * @param map
     * @return
     * @throws Exception
     */
    public int[] batchAddWithoutId(List<E> list, Map<String, Object> map) throws Exception {
        // TODO Auto-generated method stub
        if (list == null || list.size() <= 0)
            return null;

        return dao.batchAddWithoutId(getAutoTransactionConnection(), list, map);
    }
}
