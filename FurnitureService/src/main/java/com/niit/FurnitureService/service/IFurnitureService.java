package com.niit.FurnitureService.service;

import com.niit.FurnitureService.domain.Furniture;
import com.niit.FurnitureService.exception.FurnitureAlreadyExistsException;
import com.niit.FurnitureService.exception.FurnitureNotExistsException;

import java.util.List;

public interface IFurnitureService {
    List<Furniture> allFurnitures();

    Furniture saveFurniture(Furniture f) throws FurnitureAlreadyExistsException;

    boolean deleteFurniture(String id) throws FurnitureNotExistsException;

}
