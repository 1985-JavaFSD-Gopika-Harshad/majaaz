package com.example.demo.dto;

import com.example.demo.model.AvailabilityStatus;

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
public class BookResponse {

	private Long id;
    private String title;
    private String genre;
    private AvailabilityStatus availabilityStatus; // To provide availability status
    private Long authorId;
}
