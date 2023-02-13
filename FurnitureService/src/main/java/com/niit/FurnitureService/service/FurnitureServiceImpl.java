package com.niit.FurnitureService.service;

import com.niit.FurnitureService.domain.Furniture;
import com.niit.FurnitureService.exception.FurnitureAlreadyExistsException;
import com.niit.FurnitureService.exception.FurnitureNotExistsException;
import com.niit.FurnitureService.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements IFurnitureService{

    @Autowired
    FurnitureRepository furnitureRepository;

    @Override
    public List<Furniture> allFurnitures() {
        return furnitureRepository.findAll();
    }

    @Override
    public Furniture saveFurniture(Furniture f) throws FurnitureAlreadyExistsException{
        if (furnitureRepository.findById(f.getTitle()).isPresent()){
            throw new FurnitureAlreadyExistsException();
        }
        return furnitureRepository.save(f);
    }

    @Override
    public boolean deleteFurniture(String id) throws FurnitureNotExistsException {
        if(furnitureRepository.findById(id).isPresent()){
         furnitureRepository.deleteById(id);
         return true;}
        else {
            throw new FurnitureNotExistsException();
        }
    }
}
