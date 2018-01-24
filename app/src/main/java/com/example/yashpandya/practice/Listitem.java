package com.example.yashpandya.practice;

/**
 * Created by Yash Pandya on 1/2/2018.
 */

public class Listitem {


    private String name;
    private String team;
    private int publisher;
    private String Image;
    private String bio;

    public Listitem(String name, String team, int publisher, String image, String s,String bio) {
        this.name = name;
        this.team = team;
        this.publisher = publisher;
        this.Image = image;
        this.bio=bio;
    }

    public String getBio() {
        return bio;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getPublisher() {
        return publisher;
    }

    public String getImage() {
        return Image;
    }
}
