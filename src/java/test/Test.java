/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import model.CovidRank;
import model.Covid;

/**
 *
 * @author user
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       Covid cd = new Covid();
       CovidRank cr = new CovidRank();
       cr.Json();
       System.out.println(cr.getMale());
       
        
    }

}
