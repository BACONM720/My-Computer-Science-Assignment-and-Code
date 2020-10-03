
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

public class Stegano2
{
    /**
     * Constructor for objects of class Stegano1
     */
    public Stegano2()
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
            int i = 0;// i for use as an index
             
            
           if(binString.length() > 56){// the file is 56 lines so if the user enters a binString longer than that, force an error
            System.out.println("binString cannot exceed the number of files in the file");
            reader.close();
            writer.close();
           }
           if(binString.length() % 2 != 0) {// if the binString is an odd length add an extra 0 on to the end to make it even
               //this was achieved using the modulus operator
               binString += '0';// add a 0 to the binString
            }
           while (line != null) { // while theres still lines to be read...
             if(i < binString.length()-1){
               if(binString.charAt(i) == '0' && binString.charAt(i + 1) == '0'){
                   line += "  ";
                   i+=2;
                   // check the binString to see if it contains two cosecutive 0's
                   //if so increment i by 2 and add a double space to the line
               }
               else if(binString.charAt(i) == '1' && binString.charAt(i + 1) == '0'){
                   line += "   ";
                   i+=2;
                   // check the binString to see if it contains  a 1 and 0 beside each other
                   //if so increment i by 2 and add a triple space to the line
               }  
               else if(binString.charAt(i) == '0' && binString.charAt(i + 1) == '1'){
                   line += "   ";
                   i+=2;
                    // check the binString to see if it contains  a 0 and 1 beside each other
                   //if so increment i by 2 and add a triple space to the line
               }
               else if(binString.charAt(i) == '1' && binString.charAt(i + 1) == '1'){
                   line += "    ";
                   i+=2;
                    // check the binString to see if it contains two cosecutive 0's
                   //if so increment i by 2 and add a quadruple space to the line
               }  
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
              if(line.length() > 0){//only if the length of the line is greater than 0
                  
                if(line.charAt(line.length() - 4) == ' ' && line.charAt(line.length() -3) == ' ')  {
                    System.out.println("11") ;
                    //if at the length of the line - 4 is a space it must be a 11 that we hid
                    //also check that -3 is also a space because i ran into the problem where some lines
                    //had 4 letter words at the end so when it checked for -4 it also found a space
                }
                 else if(line.charAt(line.length() - 3) == ' '){
                    System.out.println("10 or 01");
                    //if at the length of the line - 3 is a space it must be a 01 or 10 combo that we hid
                    //note i could not quite figure out how to distinguish between 10 and 01 because they both add three spaces
                }
                else if(line.charAt(line.length() - 2) == ' '){
                     System.out.println("00");
                    //if at the length of the line - 2 is a space it must be a 00 combo that we hid
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
