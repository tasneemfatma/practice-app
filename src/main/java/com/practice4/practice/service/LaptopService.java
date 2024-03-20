package com.practice4.practice.service;


import com.practice4.practice.entity.Laptop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopService {

    List<Laptop> laptopList= new ArrayList<Laptop>(List.of(
            new Laptop(1, "Samsung", 20000),
            new Laptop(2, "Lenovo", 30000),
            new Laptop(3, "HP", 45000),
            new Laptop(4, "Dell", 67000)
    ));

    public List<Laptop> getAllLaptop(){
        return laptopList;
    }

    public Laptop setLaptop(Laptop laptop){
        laptopList.add(laptop);
        return laptop;
    }
}
