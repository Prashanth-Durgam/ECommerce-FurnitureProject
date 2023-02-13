package com.niit.FurnitureService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Furniture Not Exists")
public class FurnitureNotExistsException extends Exception {
}
