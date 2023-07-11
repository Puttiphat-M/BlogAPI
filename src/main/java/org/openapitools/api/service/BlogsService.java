package org.openapitools.api.service;

import org.openapitools.api.BlogsApiDelegate;
import org.openapitools.model.Blog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BlogsService implements BlogsApiDelegate {
    @Override
    public ResponseEntity<List<Blog>> blogsGet() {
        List<Blog> blogList = Arrays.asList(new Blog().title("TEST"));
        return ResponseEntity.ok(blogList);
    }

//    @Override
//    public ResponseEntity<Void> blogsIdDelete(String id) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Blog> blogsIdGet(String id) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Void> blogsIdPut(String id, Blog blog) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Void> blogsPost(Blog blog) {
//        return null;
//    }


}
