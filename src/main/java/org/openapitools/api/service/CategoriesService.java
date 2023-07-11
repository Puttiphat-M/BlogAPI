package org.openapitools.api.service;

import org.openapitools.api.CategoriesApiDelegate;
import org.openapitools.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesService implements CategoriesApiDelegate {
    private List<Category> categoryList = new ArrayList<>();

    public CategoriesService() {
        // Initialize the categoryList with some sample categories
        Category category1 = new Category();
        category1.setTitle("TEST");
        category1.setKey(category1.getTitle().toLowerCase());
        categoryList.add(category1);

        Category category2 = new Category();
        category2.setTitle("TEST2");
        category2.setKey(category2.getTitle().toLowerCase());
        categoryList.add(category2);
    }
    @Override
    public ResponseEntity<List<Category>> categoriesGet() {
        return ResponseEntity.ok(categoryList);
    }

    @Override
    public ResponseEntity<Void> categoriesTitleDelete(String title) {
        // Convert the title to lowercase for case-insensitive comparison
        String key = title.toLowerCase();

        // Find the category with the given title
        Optional<Category> optionalCategory = categoryList.stream()
                .filter(category -> category.getKey().equals(key))
                .findFirst();

        if (optionalCategory.isPresent()) {
            // Category found, remove it from the list
            Category select_category = optionalCategory.get();
            categoryList.remove(select_category);
            return ResponseEntity.ok().build();
        } else {
            // Category not found, return a not found response
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<? extends List<Category>> categoriesTitleGet(String title) {
        List<Category> matchingCategories = categoryList.stream()
                .filter(category -> category.getKey().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());

        if (!matchingCategories.isEmpty()) {
            return ResponseEntity.ok(matchingCategories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<Category> categoriesTitlePost(String title) {
        // Convert the title to lowercase to generate the key
        String key = title.toLowerCase();

        // Check if the key already exists
        Optional<Category> existingCategory = categoryList.stream()
                .filter(category -> category.getKey().equals(key))
                .findFirst();

        if (existingCategory.isPresent()) {
            // Key already exists, return a conflict response
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            // Create a new category with the provided title and generated key
            Category newCategory = new Category();
            newCategory.setTitle(title);
            newCategory.setKey(key);

            categoryList.add(newCategory);

            return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
        }
    }
}
