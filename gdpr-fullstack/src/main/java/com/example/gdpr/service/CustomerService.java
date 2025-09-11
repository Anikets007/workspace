package com.example.gdpr.service;

import com.example.gdpr.entity.Customer;
import com.example.gdpr.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

@Service
public class CustomerService {

    private final CustomerRepository repo;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CustomerService(CustomerRepository repo) { this.repo = repo; }

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public Optional<Customer> get(Integer id) {
        return repo.findById(id);
    }

    @Transactional
    public Customer create(Customer c) {
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());
        return repo.save(c);
    }

    @Transactional
    public Customer update(Integer id, Customer update) {
        return repo.findById(id).map(c -> {
            c.setFirstName(update.getFirstName());
            c.setLastName(update.getLastName());
            c.setEmail(update.getEmail());
            c.setPhone(update.getPhone());
            c.setAddress(update.getAddress());
            c.setUpdatedAt(LocalDateTime.now());
            return repo.save(c);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Transactional
    public void requestDeletion(Integer id) {
        // enqueue anonymization asynchronously
        CompletableFuture.runAsync(() -> processDeletion(id), executor);
    }

    @Transactional
    protected void processDeletion(Integer id) {
        repo.findById(id).ifPresent(c -> {
            c.setFirstName("ANON");
            c.setLastName("ANON");
            c.setEmail("anon-" + c.getUuid() + "@example.invalid");
            c.setPhone(null);
            c.setAddress(null);
            c.setAnonymized(true);
            c.setUpdatedAt(LocalDateTime.now());
            repo.save(c);
        });
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
