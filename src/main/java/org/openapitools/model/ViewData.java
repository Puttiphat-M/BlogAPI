package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ViewData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-10T10:33:08.205777+07:00[Asia/Bangkok]")
public class ViewData {

  private String id;

  private String title;

  private String description;

  private Integer day;

  private Integer year;

  private Integer hour;

  private Integer minute;

  private String selectedMonth;

  @Valid
  private List<String> selectedCategories;

  private String selectedStatus;

  public ViewData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The title,date and time of the blog
   * @return id
   */

  @Schema(name = "id", description = "The title,date and time of the blog", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ViewData title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */

  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ViewData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */

  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ViewData day(Integer day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
   */

  @Schema(name = "day", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("day")
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public ViewData year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */

  @Schema(name = "year", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public ViewData hour(Integer hour) {
    this.hour = hour;
    return this;
  }

  /**
   * Get hour
   * @return hour
   */

  @Schema(name = "hour", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hour")
  public Integer getHour() {
    return hour;
  }

  public void setHour(Integer hour) {
    this.hour = hour;
  }

  public ViewData minute(Integer minute) {
    this.minute = minute;
    return this;
  }

  /**
   * Get minute
   * @return minute
   */

  @Schema(name = "minute", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minute")
  public Integer getMinute() {
    return minute;
  }

  public void setMinute(Integer minute) {
    this.minute = minute;
  }

  public ViewData selectedMonth(String selectedMonth) {
    this.selectedMonth = selectedMonth;
    return this;
  }

  /**
   * Get selectedMonth
   * @return selectedMonth
   */

  @Schema(name = "selectedMonth", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Jan-Dec", allowableValues = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec"})
  @JsonProperty("selectedMonth")
  public String getSelectedMonth() {
    return selectedMonth;
  }

  public void setSelectedMonth(String selectedMonth) {
    this.selectedMonth = selectedMonth;
  }

  public ViewData selectedCategories(List<String> selectedCategories) {
    this.selectedCategories = selectedCategories;
    return this;
  }

  public ViewData addSelectedCategoriesItem(String selectedCategoriesItem) {
    if (this.selectedCategories == null) {
      this.selectedCategories = new ArrayList<>();
    }
    this.selectedCategories.add(selectedCategoriesItem);
    return this;
  }

  /**
   * Get selectedCategories
   * @return selectedCategories
   */

  @Schema(name = "selectedCategories", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("selectedCategories")
  public List<String> getSelectedCategories() {
    return selectedCategories;
  }

  public void setSelectedCategories(List<String> selectedCategories) {
    this.selectedCategories = selectedCategories;
  }

  public ViewData selectedStatus(String selectedStatus) {
    this.selectedStatus = selectedStatus;
    return this;
  }

  /**
   * Get selectedStatus
   * @return selectedStatus
   */

  @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Draft or Published", allowableValues = {"Draft", "Published"})
  @JsonProperty("selectedStatus")
  public String getSelectedStatus() {
    return selectedStatus;
  }

  public void setSelectedStatus(String selectedStatus) {
    this.selectedStatus = selectedStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ViewData viewData = (ViewData) o;
    return Objects.equals(this.id, viewData.id) &&
            Objects.equals(this.title, viewData.title) &&
            Objects.equals(this.description, viewData.description) &&
            Objects.equals(this.day, viewData.day) &&
            Objects.equals(this.year, viewData.year) &&
            Objects.equals(this.hour, viewData.hour) &&
            Objects.equals(this.minute, viewData.minute) &&
            Objects.equals(this.selectedMonth, viewData.selectedMonth) &&
            Objects.equals(this.selectedCategories, viewData.selectedCategories) &&
            Objects.equals(this.selectedStatus, viewData.selectedStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, day, year, hour, minute, selectedMonth, selectedCategories, selectedStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ViewData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
    sb.append("    minute: ").append(toIndentedString(minute)).append("\n");
    sb.append("    selectedMonth: ").append(toIndentedString(selectedMonth)).append("\n");
    sb.append("    selectedCategories: ").append(toIndentedString(selectedCategories)).append("\n");
    sb.append("    selectedStatus: ").append(toIndentedString(selectedStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

