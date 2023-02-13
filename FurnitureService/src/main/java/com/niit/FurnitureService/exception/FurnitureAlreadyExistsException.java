package com.niit.FurnitureService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Furniture Already Exists")
public class FurnitureAlreadyExistsException extends Exception {
}
