package com.example.loja.repositories;
import com.example.loja.models.*;
import com.example.loja.repositories.*;
import com.example.loja.security.*;
import com.example.loja.config.*;
import com.example.loja.controllers.*;import org.springframework.data.repository.CrudRepository;import org.springframework.stereotype.Repository;import java.util.Optional;@Repositorypublic interface UserRepository extends CrudRepository <User, Long>{    Optional<User> findByEmail(String email);}