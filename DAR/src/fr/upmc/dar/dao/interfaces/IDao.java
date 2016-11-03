package fr.upmc.dar.dao.interfaces;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * 
 * @author Daniel RADEAU
 *
 * @param <T> Any Entity
 */

public interface IDao<T> {

	/* Beaucoup moins classe ... */
	String persistenceUnitName = "DAR";
	
	/**
	 * Returns the list from the associated entity table in database 
	 * of each entity where the field value is prefixed by a specific prefix.
	 * 
	 * @param entity
	 * @param field
	 * @param prefix
	 * @return
	 */
	
	default List<T> selectTuplesWhereFieldIsPrefixedLike(Class<T> entity, String field, String prefix) {
		String hql = "SELECT entities FROM " + entity.getCanonicalName() + " entities WHERE entities." + field + " LIKE '" + prefix + "%'";
		System.out.println(hql);
		EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) query.getResultList();
		
		return list;
	}
	
	/**
	 * Returns the list from the associated entity table in database 
	 * of each entity where the field value is suffixed by a specific suffix .
	 * 
	 * @param entity
	 * @param field
	 * @param prefix
	 * @return
	 */
	
	default List<T> selectTuplesWhereFieldIsSuffixedLike(Class<T> entity, String field, String suffix) {
		String hql = "SELECT entities FROM " + entity.getCanonicalName() + " entities WHERE entities." + field + " LIKE '%" + suffix + "'";
		System.out.println(hql);
		EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) query.getResultList();
		
		return list;
	}
	
	/**
	 * Returns the list from the associated entity table in database 
	 * of each entity where the field value contains a specific sequence.
	 * 
	 * @param entity
	 * @param field
	 * @param prefix
	 * @return
	 */
	
	default List<T> selectTuplesWhereFieldContainsLike(Class<T> entity, String field, String sequence) {
		String hql = "SELECT entities FROM " + entity.getCanonicalName() + " entities WHERE entities." + field + " LIKE '%" + sequence + "%'";
		System.out.println(hql);
		EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) query.getResultList();
		
		return list;
	}
	
}
