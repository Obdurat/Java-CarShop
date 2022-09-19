package com.obdurat.carshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obdurat.carshop.models.CarEntity;
import com.obdurat.carshop.repositories.CarRepository;

@Service
public class CarService implements IService<CarEntity> {

    @Autowired
    CarRepository repository;

    @Override
    public CarEntity create(CarEntity request) {
        CarEntity result = this.repository.save(request); 
        return result;
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);        
    }

    @Override
    public List<CarEntity> findAll() {
        List<CarEntity> result = this.repository.findAll();
        return result;
    }

    @Override
    public CarEntity findOne(String id) {
        Optional<CarEntity> result = this.repository.findById(id);
        var output = new CarEntity();
        BeanUtils.copyProperties(result, output);
        return output;
    }

    @Override
    public CarEntity update(String id, CarEntity request) {
        Optional<CarEntity> result = this.repository.findById(id);
        if (!result.isPresent()) { return null; };
        var updated = new CarEntity();
        BeanUtils.copyProperties(request, updated);
        updated.setId(id);
        this.repository.save(updated);
        return updated;        
  }
}