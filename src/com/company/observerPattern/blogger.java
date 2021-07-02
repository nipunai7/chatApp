package com.company.observerPattern;

public class blogger {

    public static void main(String[] args) throws InterruptedException {

        Category valorant = new Category("Valorant");
        Category cod4 = new Category("CoD4");

        Observer reader1 = new Reader("Nipuna");
        Observer reader2 = new Reader("Muansinghe");
        Observer reader3 = new Reader("Rajesh");

        valorant.subscribe(reader1);
        valorant.subscribe(reader2);
        cod4.subscribe(reader3);

        cod4.upload("Welcome to Cod4");
        valorant.upload("Welcome to Valorant");

        pause();
        valorant.unsubscribe(reader2);

        cod4.upload("How to create a Cod4 Server");
        valorant.upload("Adjust your eDPI of Valorant sens");

        pause();
        cod4.unsubscribe(reader3);

        cod4.upload("How to create a Cod4 Server");
        valorant.upload("About the Best Valorant Jett 'TenZ'");

    }

    public static void pause() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("\n");

    }
}
