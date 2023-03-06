package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.StudentBookService;
import com.example.vo.StudentBook;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentBookController {

	@Autowired
	private StudentBookService s;
	
	@RequestMapping(value="/studentBookList", method=RequestMethod.GET)
	@ResponseBody
	public List<StudentBook> StudentBookList() {
		return s.getStudentBookList();
	}
	
	@RequestMapping(value="/studentBookOne", method=RequestMethod.GET)
	@ResponseBody
	public StudentBook StudentBookOne(@RequestParam("idx")int idx) {
		return s.getStudentBookOne(idx);
	}
	
	@RequestMapping(value="/addStudentBook", method=RequestMethod.POST)
	@ResponseBody
	public String addStudentBook(HttpServletRequest request, 
			@RequestParam("bookTitle")String bookTitle,
			@RequestParam("bookContent")String bookContent) {
		StudentBook sb = new StudentBook();
		sb.setBookTitle(bookTitle);
		sb.setBookContent(bookContent);
		
		s.addStudentBook(sb);
		
		return "write book";
	}
	
	@RequestMapping(value="/searchBookTitle", method=RequestMethod.GET)
	@ResponseBody
	public List<StudentBook> searchBookTitle(@RequestParam("bookTitle")String bookTitle) {
		return s.searchBookTitle("%"+bookTitle+"%");
	}
	
	@RequestMapping(value="/searchBookContent", method=RequestMethod.GET)
	@ResponseBody
	public List<StudentBook> searchBookContent(@RequestParam("bookContent")String bookContent) {
		return s.searchBookContent("%"+bookContent+"%");
	}
}
