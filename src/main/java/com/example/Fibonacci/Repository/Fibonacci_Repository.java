package com.example.Fibonacci.Repository;

import com.example.Fibonacci.Model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Fibonacci_Repository extends JpaRepository<Data, Integer> {

}
