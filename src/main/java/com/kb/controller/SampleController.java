package com.kb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.domain.SampleDTO;
import com.kb.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	@RequestMapping("/")
	public void basic() {
		log.info("-------------");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("-------------Get");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, 
			@RequestParam("age") int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("name") ArrayList<String> names) {
		log.info(names);
		return "ex03";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, 
					new CustomDateEditor(dateFormat, true));
	}
	
	
	@GetMapping("/ex04")
	public String ex04(TodoDTO todo) {
		log.info(todo);
		return "ex04";
	}
	
	
	@GetMapping("/ex05")
	public String ex05(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info(dto);
		log.info(page);
		return "sample/ex05";
	}
	
	@GetMapping("/ex06")
	public String ex06(String name, int age, RedirectAttributes rttr) {
		rttr.addFlashAttribute("name", name);
		rttr.addFlashAttribute("age", age);
		
		return "redirect:/";
	}
	
	@GetMapping("/ex07")
	public String ex07(RedirectAttributes rttr) {
		rttr.addFlashAttribute("name", "최상진");
		rttr.addFlashAttribute("age", 19);
		
		return "redirect:/";
	}
	
}






