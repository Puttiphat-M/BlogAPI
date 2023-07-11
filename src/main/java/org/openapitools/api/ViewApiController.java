package org.openapitools.api;

import org.openapitools.model.Month;
import org.openapitools.model.ViewData;


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
public class ViewApiController implements ViewApi {

    private final ViewApiDelegate delegate;

    public ViewApiController(@Autowired(required = false) ViewApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ViewApiDelegate() {
            @Override
            public ResponseEntity<ViewData> viewViewdataPost(String title, Integer day, String SelectedMonth, Integer year, Integer hour, Integer minute, String description, List<String> selectedCategories, String selectedStatus) {
                return null;
            }
        });
    }

    @Override
    public ViewApiDelegate getDelegate() {
        return delegate;
    }

}
