package org.avijitbarua.DAO;

import java.util.List;

import org.avijitbarua.Domain.Member;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("memberDao")
public class MemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void createMember(Member member) {

		session().saveOrUpdate(member);
	}

	public boolean isAuthenticate(String userName, String password) {

		Query query = session().createQuery("from Member where userName=:userName and password=:password");

		query.setString("userName", userName);
		query.setString("password", password);
		Member member = (Member) query.uniqueResult();
		if (member != null)
			return true;
		else
			return false;
	}

	public Member isExist(String userName) {
		Query query = session().createQuery("from Member where userName=:userName");
		query.setString("userName", userName);
		Member member = (Member) query.uniqueResult();
		return member;
	}

	@SuppressWarnings("unchecked")
	public List<Member> getAlMember() {
		Criteria criteria = session().createCriteria(Member.class);
		List<Member> list = criteria.list();
		return list;
	}

	public void deleteMember(String userName) {
		Query query = session().createQuery("delete from Member where userName=:userName");
		query.setString("userName", userName);
		query.executeUpdate();
	}

}
