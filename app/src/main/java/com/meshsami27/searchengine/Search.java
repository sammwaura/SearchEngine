package com.meshsami27.searchengine;

public class Search {
    private int search_id;
    private String name;


    public Search(int search_id, String name){
        this.search_id = search_id;
        this.name = name;
    }

    public void setSearch_id(int search_id) {
        this.search_id = search_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSearch_id() {
        return search_id;
    }

    public String getName() {
        return name;
    }
}
