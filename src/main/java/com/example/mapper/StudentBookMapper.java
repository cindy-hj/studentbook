package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.StudentBook;

@Mapper
public interface StudentBookMapper {
	public List<StudentBook> StudentBookList();
	public StudentBook StudentBookOne(int idx);
	public boolean addStudentBook(StudentBook sb);
	public List<StudentBook> searchBookTitle(String bookTitle);
	public List<StudentBook> searchBookContent(String bookContent);
}
