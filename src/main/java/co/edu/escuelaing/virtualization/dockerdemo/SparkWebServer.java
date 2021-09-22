/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.virtualization.dockerdemo;

import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

/**
 *
 * @author Javier
 */
public class SparkWebServer {
    
    public static void main(String... args){
          Connection db = new Connection();
          staticFileLocation("/public");
          port(getPort());
          get("/", (req,res) -> {res.redirect("/index.html");
                                return "";});    
          get("/testMongo", (req,res) ->{
            try{
                StringBuilder d = new StringBuilder();

                for (String[] s: db.getNames()){
                    String[] lol = s[0].split("-");
                    System.out.println(Arrays.toString(lol));
                    d.append("  <tr>\n" + "    <td>").append(lol[0]).append("</td>\n").append("<td> || ").append(s[1]).append("</td>").append("<td> ||" + lol[1] ).append( "</td> </tr>");
                }
                String message ="<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<meta charset=\"UTF-8\">\n"
                        + "<title>AREP</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<h1>TEST: </h1>\n"
                        + "<table>\n" +
                        "  <tr>\n" +
                        "    <th>Name</th>\n" +
                        "<th>Date</th>\n" +
                        "  </tr>\n"
                        + d.toString()
                        + "</body>\n"
                        + "</html>\n";

                return message;
            }catch (Exception e){
                e.printStackTrace();
                return "Error";
            }
          }); 
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}