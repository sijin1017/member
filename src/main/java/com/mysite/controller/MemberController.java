package com.mysite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.domain.Member;
import com.mysite.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao dao;

	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<Member> list = (ArrayList<Member>)dao.getSelectAll();
		model.addAttribute("list",list);
		return "member/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "member/insert";
	}
	
	@PostMapping("/insert")
	public String insert(Member member, Model model) {
		boolean result = dao.insertData(member);
		
		if(result) {
			return "redirect:/member/list";
		}
		else {
			model.addAttribute("message", "입력 오류 입니다.");
			return "member/insert";
		}
	}
	@PostMapping("/delete")
	public String delete(int num) {
		dao.deleteData(num);
		return "member/delete";
	}
}
