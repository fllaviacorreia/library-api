package com.projects.library.api.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

	private String title;
	private Integer status;
	private LocalDateTime dateTime;
	private List<Field> listFields;

}

