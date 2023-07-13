package org.openapitools.api;

import org.openapitools.model.ViewData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * A delegate to be called by the {@link ViewApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T02:47:03.635223+07:00[Asia/Bangkok]")
public interface ViewApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    default ViewApiDelegate getDelegate() {
        return this;
    }

    /**
     * GET /view : Return all create view data
     *
     * @return A list of create view data (status code 200)
     * @see ViewApi#viewGet
     */
    default ResponseEntity<List<ViewData>> viewGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"id\", \"title\" : \"title\", \"description\" : \"description\", \"day\" : \"day\", \"selectedMonth\" : \"selectedMonth\", \"year\" : \"year\", \"hour\" : \"hour\", \"minute\" : \"minute\", \"selectedCategories\" : [ \"selectedCategories\", \"selectedCategories\" ], \"selectedStatus\" : \"selectedStatus\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /view/{id}/{categories}/{date}
     *
     * @param id         id of the blog
     * @param categories categories of the blog
     * @param date       date of the blog
     * @return Recent view data retrieved successfully (status code 200)
     * @see ViewApi#viewIdCategoriesDateGet
     */
    default ResponseEntity<List<ViewData>> viewIdCategoriesDateGet(String id,
                                                                   String categories,
                                                                   String date) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"id\", \"title\" : \"title\", \"description\" : \"description\", \"day\" : \"day\", \"selectedMonth\" : \"selectedMonth\", \"year\" : \"year\", \"hour\" : \"hour\", \"minute\" : \"minute\", \"selectedCategories\" : [ \"selectedCategories\", \"selectedCategories\" ], \"selectedStatus\" : \"selectedStatus\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /view/{id} : Delete a specific blog by its ID
     *
     * @param id ID of the recent view data (required)
     * @return Recent view data deleted successfully (status code 200)
     *         or Invalid request payload (status code 400)
     * @see ViewApi#viewIdDelete
     */
    default ResponseEntity<Void> viewIdDelete(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /view/{id} : Update the edit view data
     *
     * @param id                 ID of the blog (required)
     * @param title              Title of the blog (required)
     * @param description        Description of the blog (required)
     * @param day                Day of the blog (required)
     * @param year               Year of the blog (required)
     * @param hour               Hour of the blog (required)
     * @param minute             Minute of the blog (required)
     * @param selectedMonth      Selected month of the blog (required)
     * @param selectedCategories Selected categories of the blog (required)
     * @param selectedStatus     Selected status of the blog (required)
     * @return Edit view data updated successfully (status code 200)
     * or Invalid request payload (status code 400)
     * @see ViewApi#viewIdPut
     */
    default ResponseEntity<Void> viewIdPut(@NotNull String id,
                                           @NotNull String title,
                                           @NotNull String description,
                                           @NotNull Integer day,
                                           @NotNull String selectedMonth,
                                           @NotNull Integer year,
                                           @NotNull Integer hour,
                                           @NotNull Integer minute,
                                           @NotNull List<String> selectedCategories,
                                           @NotNull String selectedStatus) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /view/{viewdata} : Create a new blog
     *
     * @param title              (required)
     * @param day                (required)
     * @param SelectedMonth      (required)
     * @param minute             (required)
     * @param description        (required)
     * @param selectedCategories (required)
     * @param selectedStatus     (required)
     * @param year               (required)
     * @param hour               (required)
     * @return Blog created successfully (status code 200)
     *         or Invalid request payload (status code 400)
     * @see ViewApi#viewViewdataPost
     */
    ResponseEntity<ViewData> viewViewdataPost(
            @NotNull String title,
            @NotNull Integer day,
            @NotNull String SelectedMonth,
            @NotNull Integer year,
            @NotNull Integer hour,
            @NotNull Integer minute,
            @NotNull String description,
            @NotNull List<String> selectedCategories,
            @NotNull String selectedStatus
    );

}
