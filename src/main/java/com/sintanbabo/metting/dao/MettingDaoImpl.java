package com.sintanbabo.metting.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sintanbabo.metting.model.Metting;
import com.sintanbabo.metting.model.MettingId;

/*
 * 회의실 예약을 위한 Dao 구현
 */
@Repository
public class MettingDaoImpl implements MettingDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MettingId save(Metting metting) {
		sessionFactory.getCurrentSession().save(metting);
		return metting.getId();
	}

	@Override
	public Metting get(MettingId id) {
		return sessionFactory.getCurrentSession().get(Metting.class, id);
	}

	@Override
	public List<Metting> list(Date date) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Metting> cq = cb.createQuery(Metting.class);
		Root<Metting> root = cq.from(Metting.class);
		cq.select(root);
		Query<Metting> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public List<Metting> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Metting> cq = cb.createQuery(Metting.class);
		Root<Metting> root = cq.from(Metting.class);
		cq.select(root);
		Query<Metting> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(MettingId id, Metting metting) {
		Session session = sessionFactory.getCurrentSession();
		Metting metting2 = session.byId(Metting.class).load(id);
		metting2.setCycleCount(metting.getCycleCount());
		metting2.setUser(metting.getUser());
		session.flush();
	}

	@Override
	public void delete(MettingId id) {
		Session session = sessionFactory.getCurrentSession();
		Metting metting = session.byId(Metting.class).load(id);
		session.delete(metting);
	}	
}
