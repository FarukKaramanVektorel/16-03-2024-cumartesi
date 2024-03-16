package com.example.demo.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddRequestDto {
	private String first_name;
	private String last_name;
	private String adress;
}
