package com.robosoft.onetoone.service;

import com.robosoft.onetoone.modal.Laptop;
import com.robosoft.onetoone.repository.BrandRepository;
import com.robosoft.onetoone.repository.LaptopRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    BrandRepository brandRepository;

    public Laptop saveLaptop(Laptop laptop){
        return (Laptop) laptopRepository.save(laptop);
    }

    public List<Laptop> getLaptop(){
        return laptopRepository.findAll();
    }
}
