package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BorrowerRequest;
import com.example.demo.dto.BorrowerResponse;
import com.example.demo.model.Borrower;
import com.example.demo.repository.BorrowerRepository;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    // Mapping BorrowerRequestDTO to Borrower entity
    public Borrower mapToBorrower(BorrowerRequest borrowerRequest) {
        return Borrower.builder()
                .name(borrowerRequest.getName())
                .email(borrowerRequest.getEmail())
                .phoneNumber(borrowerRequest.getPhoneNumber())
                .address(borrowerRequest.getAddress())
                .status(borrowerRequest.getStatus())
                .build();
    }

    // Mapping Borrower entity to BorrowerResponseDTO
    public BorrowerResponse mapToBorrowerResponse(Borrower borrower) {
        return BorrowerResponse.builder()
                .id(borrower.getId())
                .name(borrower.getName())
                .email(borrower.getEmail())
                .phoneNumber(borrower.getPhoneNumber())
                .address(borrower.getAddress())
                .status(borrower.getStatus())
                .build();
    }

    // Create Borrower
    public BorrowerResponse createBorrower(BorrowerRequest borrowerRequest) {
        Borrower borrower = mapToBorrower(borrowerRequest);
        borrower = borrowerRepository.save(borrower);
        return mapToBorrowerResponse(borrower);
    }

    // Get Borrower by Id
    public BorrowerResponse getBorrowerById(Long id) {
        Borrower borrower = borrowerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrower not found"));
        return mapToBorrowerResponse(borrower);
    }

    // Update Borrower by Id
    public BorrowerResponse updateBorrowerById(Long id, BorrowerRequest borrowerRequest) {
        Borrower existingBorrower = borrowerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        existingBorrower.setName(borrowerRequest.getName());
        existingBorrower.setEmail(borrowerRequest.getEmail());
        existingBorrower.setPhoneNumber(borrowerRequest.getPhoneNumber());
        existingBorrower.setAddress(borrowerRequest.getAddress());
        existingBorrower.setStatus(borrowerRequest.getStatus());

        Borrower updatedBorrower = borrowerRepository.save(existingBorrower);
        return mapToBorrowerResponse(updatedBorrower);
    }

    // Delete Borrower by Id
    public boolean deleteBorrowerById(Long id) {
        try {
            borrowerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all borrowers
    public List<BorrowerResponse> getAllBorrowers() {
        List<Borrower> borrowers = borrowerRepository.findAll();
        return borrowers.stream()
                .map(this::mapToBorrowerResponse)
                .collect(Collectors.toList());
    }
}
