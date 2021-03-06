package com.cos.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({ "", "/" })
	public String index(Model model) {
		String name = "cos";
		int num = 10;
		String password = "1234";
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("password", password);
		// viewresolver/src/main/resources/templates/index.mustache
		// 파일 확장자 없이 이름만 리턴하면됨
		return "index";
	}

	@GetMapping("/model/data")
	public String modelData(Model model) { // DI하기
		Member member = Member.builder().id(1).username("ssar").phone("01012345678").build();

		model.addAttribute("member", member);
		return "modelData";
	}

	@GetMapping("/model/array")
	public String modelArray(Model model) {
		Member member1 = Member.builder().id(1).username("cos").phone("010-2345-6789").build();

		Member member2 = Member.builder().id(2).username("ssar").phone("010-1234-5678").build();
		
		Member member3 = Member.builder().id(3).username("영주햇님").phone("042-8282-8282").build();


		List<Member> members = new ArrayList<>();

		members.add(member1);
		members.add(member2);
		members.add(member3);


		model.addAttribute("members", members);
		model.addAttribute("user",true);
		return "modelArray";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}

}
