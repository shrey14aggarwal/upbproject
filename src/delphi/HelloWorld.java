package delphi;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class HelloWorld {
	
	  public static void main(String []args){
	         Path p  = Paths.get("https://upb.de");
	         
	         /* Start of test case*/
	         Path p1 = Paths.get("https://upb.de/site/drupal");
	         Path p2 = Paths.get("https://upb.de/site/b");
	         Path p3 = Paths.get("https://upb.de/site/drupal/new");
	         Path p4 = Paths.get("https://upb.de/site/drupal/new/c");
	         Path p5 = Paths.get("https://upb.de/site/b/a/d/e");
	         Path p6 = Paths.get("https://upb.de/site/b/a/d/f");
	         Path p7 = Paths.get("https://upb.de/site/b/a/d/f/h");
	         
	         
	         HashMap<Path,ArrayList<String>> table=new HashMap();
	         
	         ArrayList list= new ArrayList<String>();
	         list.add("java");
	         list.add("python");
	         list.add("angular2");
	         list.add("c++");
	         list.add("c#");
	         list.add("ruby");
	         
	         ArrayList list1= new ArrayList<String>();
	         list1.add("c");
	         list1.add("c++");
	         list1.add("php5");
	         list1.add("ruby");
	         list1.add("joomla");
	         
	         ArrayList list2= new ArrayList<String>();
	         list2.add("c#");
	         list2.add("drupal");
	         list2.add("css");
	         list2.add("html");
	         list2.add("joomla");
	         list2.add("bootstrap");
	         
	         ArrayList list3= new ArrayList<String>();
	         list3.add("spring");
	         list3.add("html");
	         list3.add("sql");
	         list3.add("bootstrap");
	         list3.add("drupal");
	         list3.add("redhat");
	         
	         ArrayList list4= new ArrayList<String>();
	         list4.add("c");
	         list4.add("c++");
	         list4.add("php5");
	         list4.add("ruby");
	         list4.add("joomla");
	         
	         
	         ArrayList list5= new ArrayList<String>();
	         list5.add("pdf generator");
	         
	         ArrayList list6= new ArrayList<String>();
	         list6.add("c");
	         list6.add("c++");
	         list6.add("php5");
	         list6.add("ruby");
	         list6.add("joomla");
	         
	                 
	         table.put( p1,list);
	         table.put( p2,list1);
	         table.put( p3,list2);
	         table.put( p4,list3);
	         table.put( p5,list4);
	         table.put( p6,list5);
	         table.put( p7,list6);
	         
	         /* End of test case*/
	
	
	        
	  HashMap<Path,ArrayList<String>> newmap=new HashMap();
	  
	  //creating a copy for original hashmap table
	  for (Map.Entry<Path, ArrayList<String>> entry : table.entrySet())
	  {
	    newmap.put(entry.getKey(),
	    new ArrayList<String>(entry.getValue()));
	  }

	    for(Path file: table.keySet())
        {
	      //getting the parent directory from the original hashmap
	      Path path9=file.getParent();
	      
	      while(path9.equals(p)==false)
	      { 
	        for(Path file1: table.keySet())
	        {       
	          //checking if the parent directory is in hashmap	
	          if(path9.equals(file1))
	          {
	        	//here file1 indicates the parent directory and file indicates the child directory
	        	//we will check the technologies of parent and child directories
                for (int i=newmap.get(file1).size()-1;i>=0;i--)
	            {
	              for(int  j=table.get(file).size()-1;j>=0;j--)
	              {    
	                if(table.get(file).get(j)==newmap.get(file1).get(i))        
	                { 
	                  //removing the technology from the original hashmap
	                  table.get(file).remove(j);
	                }         
	              }       
	            }	                  
	          }  
	        }
	     path9=path9.getParent();
	     }
	   }
  //creating iterator to access key value pairs	    
  Set entrySet = table.entrySet();
  Iterator iterator = entrySet.iterator();
  
  while (iterator.hasNext()) 
  { 	  
	//retrieving the entry at particular iteration  
    Entry<Path, ArrayList<String>> entry = (Entry<Path, ArrayList<String>>) iterator.next(); 
    
    //checking if the arraylist corresponding to a key is empty
    if(entry.getValue().isEmpty())
     {   
    	 //removing that entry from hashmap
         iterator.remove();
     }
  }
	    
	 System.out.println("-------------------------------------\n");
	 for(Path newpath: table.keySet())
	 {
	   System.out.print(newpath+"---->");
	   System.out.println(table.get(newpath));
	 } 
    }
	  
 }


