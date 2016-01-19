/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.author;

import com.library.database.Database;
import java.sql.Date;
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
public class AuthorList {
    private ArrayList<Author> authorList = null;

    public ArrayList<Author> getAuthorlist(){
        if(authorList==null){
            authorList = new ArrayList();
            try {
                Statement stmt = Database.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("select *from author");
                while(rs.next()){
                    authorList.add(new Author(rs.getString("fio"), rs.getDate("birthday")));
                }
            } catch (NamingException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
            Collections.sort(authorList);
            return authorList;
        }
        else{
            return authorList;
        }
    }
}
