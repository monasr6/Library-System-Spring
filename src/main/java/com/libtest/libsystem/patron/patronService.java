package com.libtest.libsystem.patron;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.libtest.libsystem.user.User;
import com.libtest.libsystem.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class patronService {
    private final UserRepository userRepository;

    public List<User> getAllPatrons() {
        return userRepository.findAll();
    }

    public User getPatron(Integer id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public User addPatron(User user) {
        return userRepository.save(user);
    }

    public User updatePatron(Integer id, User user) throws NotFoundException {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // update other fields as necessary...
        return userRepository.save(existingUser);
    }

    public void deletePatron(Integer id) throws NotFoundException {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException();
        }
        userRepository.deleteById(id);
    }
}