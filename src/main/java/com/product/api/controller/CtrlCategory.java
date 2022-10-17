package com.product.api.controller;

import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;
import com.product.api.service.SvcCategoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CtrlCategory {

    @Autowired
    SvcCategory svc;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategories(){
        return new ResponseEntity<>(svc.getCategories(), HttpStatus.OK);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<Category> getCategory(@PathVariable int category_id){
        return new ResponseEntity<>(svc.getCategory(category_id), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category, BindingResult bindingResult){

        String message = "";
        if(bindingResult.hasErrors()){
            message = bindingResult.getAllErrors().get(1).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(svc.createCategory(category), HttpStatus.OK);
    }

    @PutMapping("/category/{category_id}")
    public ResponseEntity<String> updateCategory(@PathVariable int category_id, @Valid @RequestBody Category category, BindingResult bindingResult){
        String message = "";
        if(bindingResult.hasErrors()){
            message = bindingResult.getAllErrors().get(1).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(svc.updateCategory(category_id, category), HttpStatus.OK);

    }

    @DeleteMapping("/category/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int category_id){
        return new ResponseEntity<>(svc.deleteCategory(category_id), HttpStatus.OK);
    }

}
