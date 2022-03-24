package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class Item implements Serializable {
    private String id;
    private String title;
    private String location;
    private Map<String, Object> tags = new HashMap<>();
    private int year;
    private String author;

    public Item() {
    }

    public Item(String id, String title, String location, Map<String, Object> tags, int year, String author) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = tags;
        this.year = year;
        this.author = author;
    }

    public Item(String id, String title, String location, int year, String author) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
