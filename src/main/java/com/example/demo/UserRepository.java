package com.example.demo;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    public User findByName(String name);
    public User findByNameAndPassword(String name, String password);
    public boolean existsByNameAndPassword(String name, String password);
    public void deleteByNameAndPassword(String name, String password);
}