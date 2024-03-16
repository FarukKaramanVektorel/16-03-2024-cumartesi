package com.example.demo.data.dto.request;

import com.example.demo.data.dto.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddRequestDto {
	private String name;
	private CategoryDto category;
}
