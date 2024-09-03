package com.SmProjects.dreamshops.controller;

import com.SmProjects.dreamshops.exceptions.AlreadyExistsException;
import com.SmProjects.dreamshops.exceptions.ResourceNotFoundException;
import com.SmProjects.dreamshops.model.Category;
import com.SmProjects.dreamshops.response.ApiResponse;
import com.SmProjects.dreamshops.service.category.ICategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok((new ApiResponse("Found!",categories)));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error!",INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category) {
        try {
            Category category1 = categoryService.addCategory(category);
            return ResponseEntity.ok((new ApiResponse("Added!",category1)));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/category/{id}/category")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return ResponseEntity.ok((new ApiResponse("Found!",category)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body((new ApiResponse(e.getMessage(),null)));
        }
           }

    @GetMapping("/category/{name}/category")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name) {
        try {
            Category category = categoryService.getCategoryByName(name);
            return ResponseEntity.ok((new ApiResponse("Found!",category)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body((new ApiResponse(e.getMessage(),null)));
        }
    }

    @DeleteMapping("/category/{id}/delete")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategoryById(id);
            return ResponseEntity.ok((new ApiResponse("Found!",null)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body((new ApiResponse(e.getMessage(),null)));
        }
    }

    @PutMapping("/category/{id}/update")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id,@RequestBody Category category) {
        try {
            Category updateCategory = categoryService.updateCategory(category,id);
            return ResponseEntity.ok((new ApiResponse("Update Success",updateCategory)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body((new ApiResponse(e.getMessage(),null)));
        }
    }


}
