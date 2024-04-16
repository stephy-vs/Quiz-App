package com.QuizApp.QuizApp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryDTO addSubject(Category category) {
        try {
            Category category1 = categoryRepo.save(category);
            return new CategoryDTO(category1.getId(),category1.getSubject());
        }catch (Exception e){
            e.printStackTrace();
        }
        return new CategoryDTO(0,null);
    }

    public ResponseEntity<List<Category>> getAllCategory() {
        try {
            return new ResponseEntity<>(categoryRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
