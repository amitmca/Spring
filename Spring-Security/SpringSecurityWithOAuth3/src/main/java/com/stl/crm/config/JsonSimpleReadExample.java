package com.stl.crm.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleReadExample {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\AMIT\\Downloads\\customer.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}