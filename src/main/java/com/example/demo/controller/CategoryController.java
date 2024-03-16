package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.CategoryDto;
import com.example.demo.data.dto.request.CategoryAddRequestDto;
import com.example.demo.data.dto.response.CategoryWitdhProductResponseDto;
import com.example.demo.service.CategoryProductService;
import com.example.demo.service.CategoryService;
import com.example.demo.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService service;
	private final CategoryProductService catProdService;
	
	@PostMapping("/add")
	public SuccessBuilder add(@RequestBody CategoryAddRequestDto dto) {
		return service.add(dto);
	}
	
	@GetMapping("/")
	public List<CategoryDto> getByAll(){
		return service.getByAll();
	}
	
	@GetMapping("/{id}")
	public CategoryDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public SuccessBuilder delete(@PathVariable Long id) {
		return service.delete(id);
	}
	@PutMapping("/update")
	public SuccessBuilder update(@RequestBody CategoryDto dto) {
		return service.update(dto.getId(), dto);
	}
	
	@GetMapping("/cat/{id}")
	public List<CategoryWitdhProductResponseDto> getByCatWidthProd(@PathVariable Long id){
		return catProdService.getCatwidthProd(id);
	}

}
