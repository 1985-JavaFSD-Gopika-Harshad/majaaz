package com.example.demo.dto;

import com.example.demo.model.BorrowerStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowerResponse {
	
	private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private BorrowerStatus status;

}
