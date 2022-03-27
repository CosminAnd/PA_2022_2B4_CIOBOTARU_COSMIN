package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Map;

@JsonTypeName("Book")
public class Book extends Item {
    private String description;

    public Book() {
    }

    public Book(String id, String title, String location, Map<String, Object> tags, int year, String author, String description) {
        super(id, title, location, tags, year, author);
        this.description = description;
    }

    public Book(String id, String title, String location, int year, String author, String description) {
        super(id, title, location, year, author);
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "description='" + description + '\'' +
                ", id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", year=" + getYear() +
                ", author='" + getAuthor() + '\'' +
                ", tags=" + getTags() +
                '}';
    }
}
