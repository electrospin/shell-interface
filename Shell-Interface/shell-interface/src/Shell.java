import java.io.*;
import java.util.*; // for arrays and array list

public class Shell{
   public static void main(String [] args) throws IOException{
      // get + (store) user input , read it (interpret it) ,handle it,
      // and pass the command as a sys call in bash.
      // when user enters <controll> <C> sys call , flush buffer and exit()
      String j_shell = "jsh$ ";
      //String usr_cl_arg;
      String usr_name = System.getProperty("user.name");
      String os_name = System.getProperty("os.name");
      String os_version = System.getProperty("os.version");
      String HOME = System.getProperty("user.home");
      String pwd = System.getProperty("user.dir");
      //String <list> system profile
      
      //get user input and pass it into the BufferedReader 
      BufferedReader console = new BufferedReader(
         new InputStreamReader(System.in) // the latter is like stdin in C
          );
      //System.out.print(j_shell);    
      // String usr_cl_arg  =  console.readLine();
      // this loop creates controll flow, exit()    
      // parse user input (read) 
      while(true){
         System.out.print(usr_name +"@"+ os_name +":"+pwd + ": "+j_shell);
         String usr_cl_arg  =  console.readLine();
        //if user entered return, just loop again
         if(usr_cl_arg.equals(""))
            continue;
         if(usr_cl_arg.equalsIgnoreCase("exit")|| usr_cl_arg.equalsIgnoreCase("quit")){
               System.out.println("Program will exit, Good bye.");
               System.exit(0);
             }
            /***********************Steps are:*****************************
             *1. parse the input to obtain the command and any parameters *
             *2. create a ProcessBuilder object                           *
             *3. start the process                                        *
             *4. obtain the output stream (read in System's output')      * 
             *5. output the contents returned by the command              *
             **************************************************************/
            //***********1.creating an external process on system via the jvm********
            //scan input and check for a "  " AND "-" if true then...
            //here is where we split the uer input
 
            //keep a list of user input (history) this way we can print history
            
            //if the user input doesnt match any of the regex delimiter, then 
            // then the resulting array has just one element, namely this string.
           // if(usr_cl_arg.contains(" " ))/*&& usr_cl_arg.length != 2))*/{
             //split the string, 
           if(usr_cl_arg.startsWith("cd")){
               File home = new File(HOME) ;
             }
             String [] parts = usr_cl_arg.split(" ");//,1);
//             System.out.println(Arrays.toString(parts));
//             for (String i: parts)
//                  System.out.println(i);
             //process builder takes in List params so store parts[] into a List
             List<String> parts_list = new ArrayList<String>(Arrays.asList(parts));    
             System.out.println(parts_list);
             //init a process
            try {
               ProcessBuilder pb = new ProcessBuilder(parts_list);
               Process process = pb.start();
               InputStream in_str = process.getInputStream();
               InputStreamReader in_str_reader = new InputStreamReader(in_str);
               BufferedReader sys_br = new BufferedReader(in_str_reader);
               String sys_out;
               while( (sys_out = sys_br.readLine()) != null ){
                  System.out.println(sys_out);
               }
            } catch (IOException ioe){
                  System.out.print("Error starting the process, invalid entry. \n");
                  continue;
               }
         //System.exit(0);
//            } else {
//                  throw new IllegalArgumentException("input string <" + usr_cl_arg + "> doesn't contain a space and 2nd arg");
//            } 

      }
      
   }
}

// Step 3 HISTORY feature, store in a queue , but only the correctly interpreted command 
//so, jHistory() will print the correctly interpreted commands
