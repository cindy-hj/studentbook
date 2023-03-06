package com.example.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.StudentBookMapper;
import com.example.vo.StudentBook;

@Service
public class StudentBookService {

	@Autowired
	private StudentBookMapper m;
	
	public List<StudentBook> getStudentBookList() {
		return m.StudentBookList();
	}
	
	public StudentBook getStudentBookOne(int idx) {
		return m.StudentBookOne(idx);
	}
	
	public boolean addStudentBook(StudentBook sb) {
		return m.addStudentBook(sb);
	}
	
	public List<StudentBook> searchBookTitle(String bookTitle) {
		return m.searchBookTitle(bookTitle);
	}
	
	public List<StudentBook> searchBookContent(String bookContent) {
		return m.searchBookContent(bookContent);
	}
	
}