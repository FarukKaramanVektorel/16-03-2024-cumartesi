package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.CustomerDto;
import com.example.demo.data.dto.request.CustomerAddRequestDto;
import com.example.demo.data.enity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.util.ResponseUtil;
import com.example.demo.util.SuccessBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository repository;
	private final ModelMapper mapper;
	
	public List<CustomerDto> getByAll(){
		List<Customer> custs=repository.findAll();
		return custs.stream().map(c -> mapper.map(c, CustomerDto.class))
				.collect(Collectors.toList());
	}
	
	
	public SuccessBuilder add(CustomerAddRequestDto dto) {
		Customer c=mapper.map(dto, Customer.class);
		c=repository.save(c);
		if(c!=null) {
			return ResponseUtil.buildSuccess(c.getFirst_name()+" "+c.getLast_name()+" eklendi");
		}else {
			return ResponseUtil.buildError("hata");
		}
	}
	
	public SuccessBuilder update(Long id, CustomerDto dto) {
		Customer c=repository.findById(id).orElse(null);
		
		if(c!=null) {
			c.setFirst_name(dto.getFirst_name());
			c.setLast_name(dto.getLast_name());
			c.setAdress(dto.getAdress());
			repository.save(c);
			return ResponseUtil.buildSuccess(c.getFirst_name()+" "+c.getLast_name()+" güncellendi");
		}else {
			return ResponseUtil.buildError("hata");
		}
	}
	
	public SuccessBuilder delete(Long id) {
		Customer c=repository.findById(id).orElse(null);
		
		if(c!=null) {
			repository.delete(c);
			return ResponseUtil.buildSuccess(c.getFirst_name()+" "+c.getLast_name()+" silindi");
		}else {
			return ResponseUtil.buildError("hata");
		}
	}
	
	public CustomerDto getById(Long id) {
		return mapper.map(repository.findById(id),CustomerDto.class);
	}
}
