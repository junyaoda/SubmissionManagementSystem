package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	 /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private LoginService loginService;
	
	
    @GetMapping(value = "/Login")
    public String Login(Model model) {
        model.addAttribute("message", "ログイン画面");
        return "login";
    }
    
    @PostMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("message", "ログイン画面");
        return "index";
    }
    
    //ログイン成功時のメニュー画面への遷移
    @PostMapping(value = "/search")
    //String postLogin(Model model) {
    String postLogin(@RequestParam("name") String name,@RequestParam("password") String password,Model model) {   	
    	UserSearchRequest userSearchRequest = new UserSearchRequest();
    	//String name = "テスト太郎";
    	//int password = 12345;
    	userSearchRequest.name = name;
    	userSearchRequest.password = password;
    	
    	User user = loginService.search(userSearchRequest);
    	if(Objects.nonNull(user)) {
    		model.addAttribute("message", "こんにちは!!");
    		model.addAttribute("name", name);
    		return "menu";
    	}
    	model.addAttribute("message", "対象のユーザが存在しません");
		return "index";
    }
}