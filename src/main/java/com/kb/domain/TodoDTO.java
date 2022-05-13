package com.kb.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TodoDTO {
//http://localhost/sample/ex04?title=%EC%A0%9C%EB%AA%A9&dueDate2022-05-13
	private String title;
	private Date dueDate;
}
