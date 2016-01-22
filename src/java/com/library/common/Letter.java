/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.common;

/**
 *
 * @author Владислав
 */
public class Letter {
    public static char[] alphabet = new char[33];
    static{
        for(int i = 0; i<32; i++){
            alphabet[i] = (char)('А'+i);
        }
    }
}
