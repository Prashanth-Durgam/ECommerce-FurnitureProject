package com.niit.FurnitureService.repository;

import com.niit.FurnitureService.domain.Furniture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends MongoRepository<Furniture, String> {
}
