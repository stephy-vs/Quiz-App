package com.QuizApp.QuizApp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "addCategory")
    public ResponseEntity<CategoryDTO> addSubject(@RequestBody Category category){
        CategoryDTO categoryDTO = categoryService.addSubject(category);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("allCategory")
    public ResponseEntity<List<Category>> getAllCategory(){

        return categoryService.getAllCategory();
    }
}
