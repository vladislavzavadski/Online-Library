/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.book;

import com.library.database.Database;
import java.awt.Image;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Владислав
 */
public class BookList {
    private ArrayList<Book> list = null;
    public ArrayList<Book> getBookList(String query){
            list = null;
            list = new ArrayList();
            try {
                Statement stmt = Database.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){                
                   list.add(new Book(rs.getLong("id"), rs.getString("name"), rs.getInt("page_count"),
                           rs.getString("isbn"), rs.getString("genre"), rs.getString("author"), rs.getDate("publish_year"), rs.getString("publisher"), rs.getBytes("image")));
                }
                
            } catch (NamingException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return list;
    }
    public ArrayList<Book> getBooksByGenre(long id){
        return getBookList("select b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id "
                + "where genre_id=" + id + " order by b.name "
                + "limit 0,5");
    }
}