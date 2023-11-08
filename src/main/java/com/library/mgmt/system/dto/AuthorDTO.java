package com.library.mgmt.system.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.library.mgmt.system.entity.Book;

import lombok.Data;

@Data
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter

public class AuthorDTO //extends DemoDTO
{
	@NotNull(message="Author cannot be null")
	private String authorName;
	@NotBlank
    private String nationality;
	@NotBlank(message="Enter Right Gender")
    private String authorGender;

    private List<Book> books;
    

}
