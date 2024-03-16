package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.CategoryDto;
import com.example.demo.data.dto.request.CategoryAddRequestDto;
import com.example.demo.data.enity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.util.ResponseUtil;
import com.example.demo.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository repository;
	private final ModelMapper mapper;
	
	public SuccessBuilder add(CategoryAddRequestDto dto) {
		Category cat=repository.save(mapper.map(dto, Category.class));
		
		if(cat!=null) {
			return ResponseUtil.buildSuccess("Kategori Kaydı Başarılı");
		}else {
			return ResponseUtil.buildError("Kategori Kaydı Başarısız");
		}
	}
	public List<CategoryDto> getByAll(){
		List<Category> cats=repository.findAll();
		return cats.stream()
				.map(cat -> mapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
	}
	
	public CategoryDto getById(Long id) {
		return mapper.map(repository.findById(id).orElse(null), CategoryDto.class);
	}
	public SuccessBuilder update(Long id,CategoryDto dto) {
		Category cat=repository.findById(id).orElse(null);
		if(cat!=null) {
			cat.setName(dto.getName());
		repository.save(cat);
		return ResponseUtil.buildSuccess("Kategori Güncelleme Başarılı");
		}else {
			return ResponseUtil.buildError("Kategori Id Bulunamadı: "+id);
		}
			
		
		
	}
	public SuccessBuilder delete(Long id) {
		Category cat=repository.findById(id).orElse(null);
		if(cat!=null) {
			repository.delete(cat);
		return ResponseUtil.buildSuccess("Kategori Silme Başarılı");
		}else {
			return ResponseUtil.buildError("Kategori Id Bulunamadı: "+id);
		}
		
	}
	

}
