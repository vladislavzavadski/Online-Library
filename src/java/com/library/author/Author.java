/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.author;

import java.sql.Date;

/**
 *
 * @author Владислав
 */
public class Author implements Comparable {
    private String name;
    private Date birthDate;
    public String getName(){return name;}
    public Date getDate(){return birthDate;}
    public void setName(String name){ this.name = name;}
    public void setDate(Date date){birthDate = date;}
    public Author(String name, Date date){
        this.name = name;
        birthDate = date;
    }
    @Override
    public int hashCode(){
        return name.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(!(obj instanceof Author)){
            return false;
        }
        Author temp = (Author)obj;
        return name.equals(temp.name);
    }

    @Override
    public int compareTo(Object o) {
        Author temp = (Author)o;
        return name.compareTo(temp.getName());
    }
}
