package com.mysite.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.domain.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	
	public List<Member> getSelectAll(){
		return sqlSession.selectList("com.mysite.memberMapper.selectAll");
	}
	
	@Autowired
	public boolean insertData(Member member) {
		try {
		int result = sqlSession.insert("com.mysite.memberMapper.insertData", member);
		
		if(result > 0) {
			return true;
		}
		else {
			return false;
		}
	}
		catch(Exception err) {
			return false;
		}
	}
	public void deleteData(int num) {
		sqlSession.delete("com.mysite.memberMapper.deleteData", num);
	}
}
