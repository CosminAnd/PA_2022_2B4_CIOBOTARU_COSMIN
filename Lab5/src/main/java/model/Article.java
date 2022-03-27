package model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Map;

@JsonTypeName("Article")
public class Article extends Item {
    private int number;

    public Article() {
    }

    public Article(String id, String title, String location, Map<String, Object> tags, int year, String author, int number) {
        super(id, title, location, tags, year, author);
        this.number = number;
    }

    public Article(String id, String title, String location, int year, String author, int number) {
        super(id, title, location, year, author);
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Article{" +
                "number=" + number +
                ", id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", year=" + getYear() +
                ", author='" + getAuthor() + '\'' +
                ", tags=" + getTags() +
                '}';
    }
}
