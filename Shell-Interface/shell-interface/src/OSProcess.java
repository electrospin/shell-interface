
import java.io.*;

public class OSProcess {
	public static void main(String[] args) throws IOException{
		for (int i=0;i<args.length;i++)
            System.out.println("Arg[" + i + "]:" + args[i]);
            
		try{
			if (args.length != 1) {
	            System.err.println("Usage: Java OSProcess <command> ");
	            System.exit(0);
			}
			
			//get Runtime 
			Runtime rt = Runtime.getRuntime(); // allows our app to interface with the environment (ie.jre)
	        
	        // args[0] is the command.
	        
	        // declare a string array of commands
	        String[] cmds = {"ls","-l"};
	        String[] env = {"PATH=/bin:/usr/bin",
                        "TERM=xterm-color",
                        "DISPLAY=:0.0",
                        "HOME=."};
	        
	        ProcessBuilder pb = new ProcessBuilder(args[0]); // can take a list of type strings ,
	        Process proc = pb.start();
			
	        //obtain the input stream.
	        InputStream in_str = proc.getInputStream();
	        InputStreamReader in_str_reader = new InputStreamReader(in_str);
	        BufferedReader buff_reader = new BufferedReader(in_str_reader);
	        
	        System.out.println("prompt> ");
	        
	        //read what is returned from the <command>.
	        String line;
	        while ( (line = buff_reader.readLine() ) != null )
	            System.out.println(line);
	        buff_reader.close();
	        
		}catch (Exception ex){
			System.err.println("Error reading std input");
			System.err.println(ex);
			
		}
 
	}
}
