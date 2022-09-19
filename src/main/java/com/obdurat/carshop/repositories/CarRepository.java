package com.obdurat.carshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.obdurat.carshop.models.CarEntity;

@Repository
public interface CarRepository extends MongoRepository<CarEntity, String> {}
