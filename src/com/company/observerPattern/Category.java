package com.company.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Category {
    List categories = new ArrayList();
    private List<Observer> subs = new ArrayList<>();
    private String title;
    String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName; this.categories.add(categoryName); //adding categories to the list so subscriber can choose in the chat
    }

    public void subscribe(Observer sub){
        subs.add(sub);
    }

    public void unsubscribe(Observer sub){
        subs.remove(sub);
    }

    public void notifySubs(String text1,String text2){
        for(Observer sub: subs){
            sub.update(text1,text2);
        }
    }

    public List getList(){
        return this.categories;
    }

    public void upload(String title){
        this.title = title;
        notifySubs(title,categoryName);
    }
}
