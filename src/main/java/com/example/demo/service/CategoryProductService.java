package com.example.demo.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.response.CategoryWitdhProductResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryProductService {
	private final JdbcTemplate jdbcTemplate;
	
	public List<CategoryWitdhProductResponseDto> getCatwidthProd(Long id){
		String sql="select p.id as urun_id,c.name as kategori,"
				+ " p.name as urun, c.id as cat_id"
				+ " from product p, category c"
				+ " where p.category_id=c.id "
				+"and p.category_id="+id;
		
		return jdbcTemplate.query(sql, 
				(rs, rowNum)-> new CategoryWitdhProductResponseDto(
						rs.getLong("cat_id"), 
						rs.getString("kategori"), 
						rs.getLong("urun_id"),
						rs.getString("urun")
						));
	}

}
