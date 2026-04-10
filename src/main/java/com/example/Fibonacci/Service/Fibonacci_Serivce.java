package com.example.Fibonacci.Service;
import com.example.Fibonacci.Model.Data;
import com.example.Fibonacci.Repository.Fibonacci_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Fibonacci_Serivce {

    @Autowired
    private Fibonacci_Repository repository;

    public String getNameFromDB(int x) {
        Optional<Data> user = repository.findById(x);
        return user.map(Data::getName).orElse("NotFound");
    }

    public long getFibo(int x) {
        if (x <= 1) return x;

        long a = 0, b = 1;
        for (int i = 2; i <= x; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public void putInDB(int x, String y) {
        Optional<Data> user = repository.findById(x);
        if(user.isPresent()) {
            Data existing = user.get();
            existing.setName(y);
            repository.save(existing);
        }
        else {
            Data newUser = new Data();
            newUser.setX(x);
            newUser.setName(y);
            repository.save(newUser);
        }
    }
}
