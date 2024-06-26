package BookModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksRecord(String id,
                          String title,
                          String author,
                          String type,
                          String number,
                          String expiration,
                          String owner) {
}
