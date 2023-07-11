package org.openapitools.api;

import org.openapitools.model.Blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T02:47:03.635223+07:00[Asia/Bangkok]")
@Controller
@RequestMapping("${openapi.getItemsInCustomCarousel.base-path:/api}")
public class BlogsApiController implements BlogsApi {

    private final BlogsApiDelegate delegate;

    public BlogsApiController(@Autowired(required = false) BlogsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new BlogsApiDelegate() {});
    }

    @Override
    public BlogsApiDelegate getDelegate() {
        return delegate;
    }

}
