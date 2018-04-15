package org.avijitbarua.Service;

import java.util.List;

import org.avijitbarua.DAO.MemberDao;
import org.avijitbarua.Domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {

	MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;

	}

	public void createMember(Member member) {
		memberDao.createMember(member);
	}

	public boolean isAuthenticate(String userName, String password) {
		return memberDao.isAuthenticate(userName, password);
	}

	public Member isExist(String userName) {
		return memberDao.isExist(userName);
	}

	public List<Member> getAlMember() {
		return memberDao.getAlMember();
	}

	public void deleteMember(String userName) {
		memberDao.deleteMember(userName);
	}
}
