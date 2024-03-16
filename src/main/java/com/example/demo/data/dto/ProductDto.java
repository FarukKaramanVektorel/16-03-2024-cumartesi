package com.example.demo.data.dto;

import com.example.demo.data.dto.response.ProductBaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends ProductBaseDto{
 private CategoryDto category;
}
