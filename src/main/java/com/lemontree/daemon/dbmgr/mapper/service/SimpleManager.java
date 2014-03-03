package com.lemontree.daemon.dbmgr.mapper.service;

import cn.tisson.framework.annotation.Transaction;
import cn.tisson.framework.dao.jdbc.GenericDAO;
import cn.tisson.framework.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * ����ҵ���߼���������
 * 
 * @author BrainstorM
 * 
 * @param <D>
 */
public class SimpleManager<E, D extends GenericDAO<E>> extends BaseManager {

	// ��־����
	private static final Logger logger = LoggerFactory.getLogger(SimpleManager.class);

	// ���͵�class
	protected Class<D> daoClass;

	// dao������
	protected D dao;
	
	/**
	 * ���캯������ʼ��
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected SimpleManager() {
		daoClass = ReflectionUtils.getSuperClassGenricType(getClass(), 1);

		try {
			dao = daoClass.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("SimpleManager��ʼ��ʧ��: ", e);
		} 
	}

	/**
	 * ����ID��ѯһ����¼
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
	 * ����ID��ѯһ����¼
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
	 * ����ID���ϲ�ѯ��¼�б�
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
	 * ����ID���ϲ�ѯ��¼�б�
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
	 * ��ѯȫ����¼
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
	 * ��ѯȫ����¼
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
	 * ��ѯһ����¼
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
	 * ��ѯһ����¼
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
	 * ��������һ����¼
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
	 * ��������һ����¼
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
	 * ��ѯ��¼�б�
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
	 * ��ѯ��¼�б�
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
	 * ��ѯ��¼�б�
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
	 * ��ѯ��¼�б�
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
	 * �������Բ�ѯ��¼�б�
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
	 * �������Բ�ѯ��¼�б�
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
	 * �������Բ�ѯ��¼�б�
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
	 * �������Բ�ѯ��¼�б�
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
	 * ����ID���¼�¼, ʵ��ı���ֻҪ��Ϊnull�ͻ�������ݿ�
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
	 * ����ID�����¼�¼, ʵ��ı���ֻҪ��Ϊnull�ͻ�������ݿ�
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
	 * ���¼�¼, ʵ��ı���ֻҪ��Ϊnull�ͻ�������ݿ�
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
	 * ����ȫ����¼, ʵ��ı���ֻҪ��Ϊnull�ͻ�������ݿ�
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
	 * ����IDɾ��һ����¼
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
	 * ����ID��ɾ����¼
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
	 * ɾ����¼
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
	 * ɾ��ȫ����¼
	 * 
	 * @return
	 * @throws Exception
	 */
	public int deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteAll(getAutoTransactionConnection());
	}


    /**
     * ����һ����¼
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
     * ����һ����¼(����ID��
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
	 * �������Ӷ�����¼
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
     * �������Ӷ�����¼
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
	 * �������Ӷ�����¼
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
     * �������Ӷ�����¼
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
