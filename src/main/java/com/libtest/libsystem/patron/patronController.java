package com.libtest.libsystem.patron;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libtest.libsystem.user.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patrons")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')") // just for test change to ADMIN to see get blocked and access for only admin
public class patronController {
    private final patronService _patronService;
    
    @GetMapping
    public List<User> getAllPatrons() {
        return _patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public User getPatron(@PathVariable Integer id) throws NotFoundException {
        return _patronService.getPatron(id);
    }

    @PostMapping
    public User addPatron(@RequestBody User patron) {
        return _patronService.addPatron(patron);
    }

    @PutMapping("/{id}")
    public User updatePatron(@PathVariable Integer id, @RequestBody User patron) throws NotFoundException {
        return _patronService.updatePatron(id, patron);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Integer id) throws NotFoundException {
      _patronService.deletePatron(id);
    }
}