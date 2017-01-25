import java.io.*;
import java.util.*;

public class Shell{
   public static void main(String [] args) throws IOException{
      // get (store) user input , read it (interpret it) ,handle it,
      // and pass the command as a sys call in bash.
      // when user enters <controll> <C> sys call , flush buffer and exit()
      String j_shell = "jsh$ ";
      //String usr_cl_arg;
      String HOME = System.getProperty("user.home");
      
      //String <list> sys
      
      //get user input and pass it into the BufferedReader 
      BufferedReader cli_arg = new BufferedReader(
         new InputStreamReader(System.in) // the latter is like stdin in C
          );
      System.out.print(j_shell);    
      String usr_cl_arg  =  cli_arg.readLine();
          
      // this loop will dictate if program will exit()    
      // parse user input (read) 
      
      
      while(true){
        // System.out.print(j_shell);
         System.out.print(HOME +"\n \n");
        //if user entered return, just loop again
         if(usr_cl_arg.equals(""))
            continue;
            
            /***********************Steps are:*****************************
             *1. parse the input to obtain the command and any parameters *
             *2. create a ProcessBuilder object                           *
             *3. start the process                                        *
             *4. obtain the output stream (read in System's output')      * 
             *5. output the contents returned by the command              *
             **************************************************************/
            
            //***********1.creating an external process on system via the jvm********
            //scan input and check for a "_" AND "-" if true then...
            
            //here is where we split the uer input
 
            //keep a list of user input (history) this way we can print history
            
            //if the user input doesnt match any of the regex delimiter, then 
            // then the resulting array has just one element, namely this string.
            
            if(usr_cl_arg.contains(" " ))/*&& usr_cl_arg.length != 2))*/{
             //split the string, 
             String [] parts = usr_cl_arg.split(" ");//,1);
             String part1 = parts[0];
             String part2 = parts[1];
            
               //if(parts.length != 2)/* && part2.length < 2 )*/{ 
                  //throw new IllegalArgumentException("input string <" + usr_cl_arg + "> doesn't contain a 2nd arg"); }
             System.out.print("we successfully split the string into " + part1+ " " + part2+ "!\n");
             System.out.print("length of split array is : " + parts.length +"\n");
             System.exit(0);
            } else {
                  throw new IllegalArgumentException("input string <" + usr_cl_arg + "> doesn't contain a space and 2nd arg");
            } 
//         if(us_cl_arg.equals("ls")){
//            
//         }
         // ls , 
      }
      
   }
}

// Step 3 HISTORY feature, store in a queue , but only the correctly interpreted command 
//so, jHistory() will print the correctly interpreted commands
