package org.hdcd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/notice")
@Controller
public class NoticeController {

	@GetMapping("/list")
	public void list() {
		log.info("list : access to all");
	}
	
	@GetMapping("/register")
	public void register() {
		System.out.println("무야호");
		log.info("register : access to admin ");
	}
}
