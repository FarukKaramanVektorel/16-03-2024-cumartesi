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

import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.dto.request.ProductAddRequestDto;
import com.example.demo.service.ProductService;
import com.example.demo.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
	private final ProductService service;
	
	@GetMapping("/")
	public List<ProductDto> getByAll(){
		return service.getByAll();
	}
	
	@GetMapping("/{id}")
	public ProductDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/add")
	public SuccessBuilder add(@RequestBody ProductAddRequestDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/update")
	public SuccessBuilder update(@RequestBody ProductDto dto) {
		return service.update(dto.getId(), dto);
	}
	
	@DeleteMapping("/{id}")
	public SuccessBuilder delete(@PathVariable Long id) {
		return service.delete(id);
	}

}
