package com.incredible.xmltomysql;

import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement;  

@XmlRootElement(name = "tutorials") 
public class Tutorial {  
   
   int tutorial_id; 
   String tutorial_author;
   String submission_date; 
   String tutorial_title;
  
   @XmlAttribute(name = "tutorial_id") 
   public int getTutorial_id() { 
      return tutorial_id; 
   }  
   
   public void setTutorial_id(int tutorial_id) { 
      this.tutorial_id = tutorial_id; 
   }  
 
   @XmlElement(name = "tutorial_author") 
   public String getTutorial_author() { 
      return tutorial_author; 
   }  
   
   public void setTutorial_author(String tutorial_author) { 
      this.tutorial_author = tutorial_author; 
   }  
 
   @XmlElement(name = "tutorial_title") 
   public String getTutorial_title() { 
      return tutorial_title; 
   } 
  
   public void setTutorial_title(String tutorial_title) { 
      this.tutorial_title = tutorial_title; 
   }  
 
   @XmlElement(name = "submission_date") 
   public String getSubmission_date() { 
      return submission_date; 
   }

   public void setSubmission_date(String submission_date) { 
      this.submission_date = submission_date; 
   }  

   /*public String toString() { 
      return " [Tutorial Id=" + tutorial_id + "," 
      Tutorial Author =" + tutorial_author  + ", 
      Tutorial Title =" + tutorial_title + ", 
      Submission Date =" + submission_date + "]"; 
   } */
} 