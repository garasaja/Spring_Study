package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@Autowired
	Test t;

	@GetMapping("/index")
	public String home() {
		return "index";
	}
		
	// http://localhost:8080/
	@GetMapping({ "", "/" })
	public @ResponseBody String index() {

		System.out.println(t.num);
		return "헬로"; // viewResolver

	}

	// x-www-form-urlencoded => key=value
	// http://localhost:8080/form
	@PostMapping({ "/form" })
	public @ResponseBody String form(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		return "User"; // viewResolver
	}

	// x-www-form-urlencoded => key=value
	// http://localhost:8080/form/model
	@PostMapping({ "/form/model" })
	public @ResponseBody String formModel(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return "User"; // viewResolver
	}

	// x-www-form-urlencoded => key=value
	// http://localhost:8080/form/model?username=ssar&password=1234&email=ssar@nate.com
	@GetMapping({ "/form/model" })
	public @ResponseBody String formModelGet(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return "User"; // viewResolver
	}

	// json=> {"key":값}
	// http://localhost:8080/json/model
	//{"username":"cos",
	//"password":"1234",
	//"email":"cos@nate.com"}
	//json형태의 데이터가 있을시 jackson라이브러리 발동
	@PostMapping({ "/json/model" })
	public @ResponseBody String jsonModel(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return "User"; // viewResolver
	}
	
	// http://localhost:8080/json/model1
	// ResponseBody가 없을시 파일로 인지함
	@PostMapping({ "/json/model1" })
	public @ResponseBody User jsonModel1(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return user; // viewResolver 작동금지 => Jackson발동
	}
}
