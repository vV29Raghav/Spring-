package com.example.Fibonacci.Controller;

import com.example.Fibonacci.Service.Fibonacci_Serivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Fibonacci_Controller {

    @Autowired
    private Fibonacci_Serivce serivce;

    @GetMapping("/data/{x}")
    public ResponseEntity<Map<String, Object>> getData(@PathVariable int x) {
        String name = serivce.getNameFromDB(x);
        long fibo = serivce.getFibo(x);
        Map<String, Object> res = new HashMap<>();
        res.put("x", x);
        res.put("name", name);;
        res.put("fibonacci", fibo);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/data/{x}/{y}")
    public ResponseEntity<String> putData(@PathVariable int x, @PathVariable String y) {
        serivce.putInDB(x, y);
        return ResponseEntity.ok("Data saved/updated successfully");
    }
}
