
/**
 * Skeleton code for Steganography assignment.
 *
 * @author Michael Schukat
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stegano1
{
    /**
     * Constructor for objects of class Stegano1
     */
    public Stegano1()
    {
    }

    public static void main(String[] args) {
        String arg1, arg2, arg3, arg4;
        Boolean err = false;
        
        if (args != null && args.length > 1) { // Check for minimum number of arguments
            arg1 = args[0];
            arg2 = args[1];
                
            if (arg2 == "") {
                err = true;
            }
            else if ((arg1 == "A") && (args.length > 3)){
                // Get other arguments
                arg3 = args[2];
                arg4 = args[3];
                if (arg3 == "" || arg4 == "") {
                    err = true;
                }
                else {
                    // Hide bitstring
                    hide(arg2, arg3, arg4);
                }
            }
            else if (arg1 == "E"){
                // Extract bitstring from text   
                retrieve(arg2);   
            }
            else {
                err = true;
            }
        }
        else {
            err = true;
        }
        
        if (err == true) {
            System.out.println();
            System.out.println("Use: Stegano1 <A:E><Input File><OutputFile><Bitstring>");
            System.out.println("Example: Stegano1 A inp.txt out.txt 0010101");
            System.out.println("Example: Stegano1 E inp.txt");
            
        } 
    }
    
    static void hide(String inpFile, String outFile, String binString) {
        // 
        BufferedReader reader;
        BufferedWriter writer;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String line = reader.readLine();
            int i = 0;// int i for use as an index
             
            
            if(binString.length() > 56){// the file is 56 lines so if the user enters a binString longer than that, force an error
            System.out.println("binString cannot exceed the number of files in the file");
            reader.close();
            writer.close();
           }
           
           while (line != null) { //while the file isnt null
                
               if(binString.charAt(i) == '0' && i < binString.length()-1 ){
                   line += " ";
                   i++;//increment i
                   //if the char in the binString is 0 add add a space at the end of the line also make sure i is within the length of the binstring
               }
               else if(binString.charAt(i) == '1'  && i < binString.length()-1){
                   line += "  ";
                   i++;//increment i
                   //if the char in the binString is 1 add add a double space at the end of the line also make sure i is within the length of the binstring
               }  
                writer.newLine();
                writer.write(line);
                // Store amended line in output 
		// read next line
		line = reader.readLine();
              
            
            } 
            reader.close();
            writer.close();
	   } catch (IOException e) {
	    e.printStackTrace();
	}

    }

    static void retrieve(String inpFile) {
        BufferedReader reader;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            String line = reader.readLine();
            while (line != null) {
                // Your code starts here
              if(line.length() > 0){// make sure theres a line there greater than length 0
               
                if(line.charAt(line.length() - 2) == ' '){// if theres a space at the length of the given line - 2 this means it must be 1 that we hid
                    System.out.println("1");//print out 1 to the user
                }
                else if(line.charAt(line.length() - 1) == ' '){// if theres a space at the length of the given line - 1 this means it must be 0 that we hid  
                    System.out.println("0") ;//print out 0 to the user
                }
            }
 
               // System.out.println(line);
               line = reader.readLine();
            
        }
            reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
