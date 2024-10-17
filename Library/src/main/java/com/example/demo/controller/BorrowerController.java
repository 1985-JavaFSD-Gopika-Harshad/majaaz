package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BorrowerRequest;
import com.example.demo.dto.BorrowerResponse;
import com.example.demo.service.BorrowerService;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;

    @Autowired
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    // Create a new borrower
    @PostMapping
    public ResponseEntity<BorrowerResponse> createBorrower(@RequestBody BorrowerRequest borrowerRequest) {
        BorrowerResponse createdBorrower = borrowerService.createBorrower(borrowerRequest);
        return new ResponseEntity<>(createdBorrower, HttpStatus.CREATED);
    }

    // Get a borrower by ID
    @GetMapping("/{id}")
    public ResponseEntity<BorrowerResponse> getBorrowerById(@PathVariable Long id) {
        BorrowerResponse borrowerResponse = borrowerService.getBorrowerById(id);
        return ResponseEntity.ok(borrowerResponse);
    }

    // Update a borrower by ID
    @PutMapping("/{id}")
    public ResponseEntity<BorrowerResponse> updateBorrowerById(@PathVariable Long id, @RequestBody BorrowerRequest borrowerRequest) {
        BorrowerResponse updatedBorrower = borrowerService.updateBorrowerById(id, borrowerRequest);
        return ResponseEntity.ok(updatedBorrower);
    }

    // Delete a borrower by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowerById(@PathVariable Long id) {
        boolean isDeleted = borrowerService.deleteBorrowerById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Get all borrowers
    @GetMapping
    public ResponseEntity<List<BorrowerResponse>> getAllBorrowers() {
        List<BorrowerResponse> allBorrowers = borrowerService.getAllBorrowers();
        return ResponseEntity.ok(allBorrowers);
    }
}
