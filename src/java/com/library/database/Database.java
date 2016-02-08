/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Владислав
 */
public class Database {
    private static InitialContext ic = null;
    private static DataSource ds;
    public static Connection getConnection() throws NamingException, SQLException{
        if(ic==null){
            ic = new InitialContext();
            ds = (DataSource)ic.lookup("jdbc/Library");
            
            return ds.getConnection();
        }
        else{
            return ds.getConnection();
        }
    } 
    public static void close(){
        if(ic!=null){
            try {
                ic.close();
                ic = null;
            } catch (NamingException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ds = null;
    }
}
