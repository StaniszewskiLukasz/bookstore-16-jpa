package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private long id;
    private String title;
    private int pagesNumber;
    private long isbn;
    private SimplePublisherDto publishers;

    public BookDto(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public BookDto() {
    }
}