package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplePublisherDto {
    private long id;
    private String name;

    public SimplePublisherDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
