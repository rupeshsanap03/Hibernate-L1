package com.sample.CollectionMap;

public class Story {
    private int storyId;
    private String info;
    private Writer writer; // Reference to the Writer

    public Story() {}

    public Story(String info) {
        this.info = info;
    }

    // Getters and Setters
    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
