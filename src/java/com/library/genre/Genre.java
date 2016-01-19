/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.genre;

/**
 *
 * @author Владислав
 */
public class Genre implements Comparable{
    private String name;
    public Genre(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Object o) {
        Genre temp = (Genre)o;
        return name.compareTo(temp.getName());
    }
}
