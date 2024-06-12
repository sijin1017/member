package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mysite.domain.Member;

public interface DataMappingInterface {
	@Select("select * from boot_mem")
	List<Member> getSelectAll();
}
