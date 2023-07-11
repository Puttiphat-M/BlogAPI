package org.openapitools.api;

import org.openapitools.model.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link BlogsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T02:47:03.635223+07:00[Asia/Bangkok]")
public interface BlogsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /blogs : Return a list of blogs for the carousel(all)
     *
     * @return A list of blogs (status code 200)
     * @see BlogsApi#blogsGet
     */
    default ResponseEntity<List<Blog>> blogsGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"image\" : \"https://example.com/aeiou\", \"link\" : \"https://example.com/aeiou\", \"title\" : \"title\" }, { \"image\" : \"https://example.com/aeiou\", \"link\" : \"https://example.com/aeiou\", \"title\" : \"title\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /blogs/{title} : Delete a specific blog by its ID
     *
     * @param title title of the blog (required)
     * @return Blog deleted successfully (status code 200)
     *         or Invalid request (status code 400)
     * @see BlogsApi#blogsTitleDelete
     */
    default ResponseEntity<Void> blogsTitleDelete(String title) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /blogs/{title} : Return a specific blog by its ID
     *
     * @param title title of the blog (required)
     * @return Blog retrieved successfully (status code 200)
     *         or Blog not found (status code 404)
     * @see BlogsApi#blogsTitleGet
     */
    default ResponseEntity<Blog> blogsTitleGet(String title) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"image\" : \"https://example.com/aeiou\", \"link\" : \"https://example.com/aeiou\", \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /blogs/{title} : Update a specific blog by its ID
     *
     * @param title title of the blog (required)
     * @param blog  (required)
     * @return Blog updated successfully (status code 200)
     *         or Invalid request payload (status code 400)
     * @see BlogsApi#blogsTitlePut
     */
    default ResponseEntity<Void> blogsTitlePut(String title,
        Blog blog) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
