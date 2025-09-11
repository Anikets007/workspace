package com.example.gdpr.controller;

import com.example.gdpr.entity.Customer;
import com.example.gdpr.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService svc;

    public CustomerController(CustomerService svc) { this.svc = svc; }

    @GetMapping
    public ResponseEntity<List<Customer>> list() {
        return ResponseEntity.ok(svc.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        return svc.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer c) {
        Customer saved = svc.create(c);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer c) {
        Customer updated = svc.update(id, c);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{id}/request-deletion")
    public ResponseEntity<String> requestDeletion(@PathVariable Integer id) {
        svc.requestDeletion(id);
        return ResponseEntity.accepted().body("Deletion requested and will be processed asynchronously.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
