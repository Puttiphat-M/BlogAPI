package org.openapitools.api;

import org.openapitools.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link CategoriesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-10T10:33:08.205777+07:00[Asia/Bangkok]")
public interface CategoriesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /categories : Return all categories
     *
     * @return A list of categories (status code 200)
     * @see CategoriesApi#categoriesGet
     */
    default ResponseEntity<List<Category>> categoriesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"title\" : \"title\", \"key\" : \"key\" }, { \"title\" : \"title\", \"key\" : \"key\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /categories/{title} : Delete a specific category by its title
     *
     * @param title title of the category (required)
     * @return Category deleted successfully (status code 200)
     *         or Invalid request (status code 400)
     * @see CategoriesApi#categoriesTitleDelete
     */
    default ResponseEntity<Void> categoriesTitleDelete(String title) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /categories/{title} : Retrieve a specific category (Search by key of title)
     *
     * @param title title of the category (required)
     * @return Category return successfully (status code 200)
     * or Category not found (status code 404)
     * @see CategoriesApi#categoriesTitleGet
     */
    default ResponseEntity<? extends List<Category>> categoriesTitleGet(String title) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"title\" : \"title\", \"key\" : \"key\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /categories/{title} : Create a new category with a custom key
     *
     * @param title title of the category (required)
     * @return Category created successfully (status code 201)
     *         or Invalid request payload (status code 400)
     * @see CategoriesApi#categoriesTitlePost
     */
    default ResponseEntity<Category> categoriesTitlePost(String title) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"title\" : \"title\", \"key\" : \"key\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
