package com.incredible.xmltomysql;

import org.springframework.batch.item.ItemProcessor;  

public class CustomItemProcessor implements ItemProcessor<Tutorial, Tutorial> {  

   @Override 
   public Tutorial process(Tutorial item) throws Exception { 
      System.out.println("Processing..." + item); 
      return item; 
   } 

}      