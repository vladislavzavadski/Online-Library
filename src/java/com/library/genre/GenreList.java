/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.genre;

import com.library.author.Author;
import com.library.author.AuthorList;
import com.library.database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Владислав
 */
public class GenreList {
        private ArrayList<Genre> authorList = null;

    public ArrayList<Genre> getGenrelist(){
        if(authorList==null){
            authorList = new ArrayList();
            Statement stmt = null;
            ResultSet rs = null;
            Connection con = null;
            try {
                con = Database.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select *from genre");
                while(rs.next()){
                    authorList.add(new Genre(rs.getString("name"), rs.getLong("id")));
                }
            } catch (NamingException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                
                try {
                    if(con!=null){
                        con.close();
                    }
                    if(stmt!=null)
                        stmt.close();
                    if(rs!=null)
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
                }
                Database.close();
            }
            Collections.sort(authorList);
            return authorList;
        }
        else{
            return authorList;
        }
    }
}
