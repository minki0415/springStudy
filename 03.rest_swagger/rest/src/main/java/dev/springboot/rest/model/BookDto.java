package dev.springboot.rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String name;
    private String author;

    
    @Override
    public String toString() {
        return "BookDto [author=" + author + ", name=" + name + "]";
    }

}
