package com.company.observerPattern;

public class Reader implements Observer {

    private String name;
    private Category category;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String title,String categoryName){
        System.out.println("Hi "+name+", New Blog Added: "+ title+" in "+ categoryName);
    }


}
