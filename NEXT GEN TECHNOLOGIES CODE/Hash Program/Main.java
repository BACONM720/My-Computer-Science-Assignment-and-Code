package com.company;
import java.util.Random;

//package ct255;
public class Main {

    public static void main(String[] args) {
                double res = 0;
                if (args != null && args.length > 0) { // Check for <input> value
                    res = hashF1(args[0]); // call hash function with <input>
                    if (res < 0) { // Error
                        System.out.println("Error: <input> must be 1 to 64 characters long.");
                    } else {
                        System.out.println("input = " + args[0] + " : Hash = " + res);
                        System.out.println("Start searching for collisions \n");
                        // Your code starts here!
                        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";//base of our random string
                        int counter = 1;// counter declaration
                        int loopNum = 0;//number of loops counter declaration

                        while (loopNum < 50000) {//a while loop that runs a variable amount of times.
                            StringBuilder strTest = new StringBuilder();// a new string builder object for our test string
                            for (int i = 0; i < (getRandomInt(64) + 1); ++i) {//
                                strTest.append(str1.charAt(getRandomInt(62)));/*appending our test string to random characters from str1
                                producing a random string*/
                            }
                            if (hashF1(strTest.toString()) == res) {/*if statement to check if our hash value for our random string
                                is the same as the hash value of the predefined string we passed in*/
                                System.out.flush();
                                System.out.println( "initial  value: " + strTest.toString());// print statements to print values
                                System.out.println("Number of Loops: " + loopNum);
                                System.out.println("hash = " + hashF1(strTest.toString()));
                                System.out.println("counter = " + counter+ "\n");

                                ++counter;// increment counter which will also be the total number of collisions we have
                            }
                            loopNum++;// increment the number of loops counter until we hit 50000 then break
                        }

                    }

                }else{
                    // No <input>
                    System.out.println("Use: CT255_HashFunction1 <Input>");
                }
            }

            private static double hashF1(String s){
                double ret;
                int i;
                int[] hashA = new int[]{1,1,1,1,1,1,1,1,1,1,1};// increased the size of the array hashA by 7 to make it more robust.

                String filler, sIn;

                filler = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" );// changed the filler to have more variation.

                if ((s.length() > 64) || (s.length() < 1)) { // String does not have required length
                    ret = -1;
                }
                else {

                    sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
                   //sIn = sIn.substring(0, 150); // when i dont limit the string to just 64 characters, there are much less collisions.
                    for (i = 0; i < sIn.length(); i++){
                        char byPos = sIn.charAt(i); // get i'th character
                        hashA[0] += (byPos * 177362101); // increased the size we multiply byPos by to create a larger hash value.
                        hashA[1] += (byPos * 301536575);
                        hashA[2] += (byPos * 104149219);
                        hashA[3] += (byPos * 179342922);
                        hashA[4] += (byPos * 167931525);
                        hashA[5] += (byPos * 196733183);
                        hashA[6] += (byPos * 153939759);
                        hashA[7] += (byPos * 514341921);
                        hashA[8] += (byPos * 130937707);
                        hashA[9] += (byPos * 434343153);
                        hashA[10] +=(byPos * 324667247);

                    }

                    hashA[0] %=  18013 ;  //increased the size of the modulus considerably to make it more random
                    hashA[1] %=  18013 ;
                    hashA[2] %=  18013 ;
                    hashA[3] %=  18013 ;
                    hashA[4] %=  18013 ;
                    hashA[5] %=  18013 ;
                    hashA[6] %=  18013 ;
                    hashA[7] %=  18013 ;
                    hashA[8] %=  18013 ;
                    hashA[9] %=  18013 ;
                    hashA[10] %= 18013 ;


                    ret = hashA[0] + (hashA[1] * 256) + (hashA[2] * 256 * 256) + (hashA[3] * 256 * 256 * 256) + (hashA[4] * 256 * 256 * 256 * 256) + (hashA[5] * 256 * 256 * 256 * 256 * 256 ) + (hashA[6] * 256 * 256 * 256 * 256 * 256 * 256) + (hashA[7] * 256 * 256 * 256 * 256 * 256 * 256 * 256) + (hashA[8] * 256 * 256 * 256 * 256 * 256 * 256 * 256 * 256 ) + (hashA[9] * 256 * 256 * 256 * 256 * 256 * 256 * 256 * 256 * 256 ) + (hashA[10] * 256 * 256 * 256 * 256 * 256 * 256 * 256 * 256 * 256 * 256 ) ;
                    if (ret < 0) ret *= -1;
                }
                return ret;
            }
            private static int getRandomInt(int upper) {// random int generator function using the java.util.Random library
                Random r = new Random();
                return r.nextInt(upper);
            }
            }





