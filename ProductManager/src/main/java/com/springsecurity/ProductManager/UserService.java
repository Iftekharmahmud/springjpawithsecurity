package com.springsecurity.ProductManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){

        return (List<User>) userRepository.findAll();

    }

    public void addNewUser(User user) {
        Optional<User> studentOptional = userRepository.findById(user.getId());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("user already exists");
        }
        userRepository.save(user);
        System.out.println(user);
    }
    public void deleteUser(Long userId) {
        //studentRepository.findAllById(studentId);
        boolean exists=userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("user with id "+userId+" does not exists");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateStudent(Long userId,String name) {
        User user= userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException("user with id "+ userId+" does not exist"));
        if(name !=null && name.length()>0 && !Objects.equals(user.getUsername(),name)){
            user.setUsername(name);
        }

       /* if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = userRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }*/

    }



}
