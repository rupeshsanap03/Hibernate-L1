package com.sample.CollectionMap;

import java.util.HashSet;
import java.util.Set;

public class Writer {
    private int id;
    private String name;
    private Set stories = new HashSet();

    public Writer() {}

    public Writer(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getStories() {
        return stories;
    }

    public void setStories(Set stories) {
        this.stories = stories;
    }
    
}
