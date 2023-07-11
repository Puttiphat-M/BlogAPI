package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Blog
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T02:47:03.635223+07:00[Asia/Bangkok]")
public class Blog {

  private String title;

  private String image;

  private String link;

  public Blog title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the blog
   * @return title
  */
  
  @Schema(name = "title", description = "The title of the blog", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Blog image(String image) {
    this.image = image;
    return this;
  }

  /**
   * The URL of the blog image
   * @return image
  */
  
  @Schema(name = "image", description = "The URL of the blog image", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Blog link(String link) {
    this.link = link;
    return this;
  }

  /**
   * The URL of the blog link
   * @return link
  */
  
  @Schema(name = "link", description = "The URL of the blog link", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("link")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Blog blog = (Blog) o;
    return Objects.equals(this.title, blog.title) &&
        Objects.equals(this.image, blog.image) &&
        Objects.equals(this.link, blog.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, image, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Blog {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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

