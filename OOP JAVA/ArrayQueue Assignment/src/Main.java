public class Main {
   private static int test1Count = 0;// counters to count the number of operations each test will take
    private static int test2Count = 0;
    private static int test3Count = 0;
    private static int test4Count = 0;
    private static int range;
    private static int interval;
   private static int num;
    private static boolean res1;
    private static boolean res2;
    private static int count;
    private static int count1;
    private static String input;
    private static int i;

    public static Boolean isPalindrome1(String a) {// first method for palindrome , basically reverse the string the compare to the original
        int i; test1Count++;
        int j = 0; test1Count++;
        String res = ""; test1Count++;
        for (i = a.length() - 1; i >= 0; i--) {// this reverses the string
            res = res + (a.charAt(i));    test1Count++;

        }
        while (j < a.length() - 1) {
            test1Count++;
            if (a.charAt(j) != res.charAt(j)) {// if original not equal to reverse return false
                test1Count++;
                return false;
            }//else keep going
            j++;test1Count++;
        }
        return true;

    }

    public static boolean isPalindrome2(String a) {//palindrome method 2 compare the first element to the last and work off that basis, if at any point it doesnt match break
        int i = 0;
        test2Count++;
        int j = a.length() - 1;//set j to the length of the string
        test2Count++;

        while (i < j) {
            test2Count++;
            if (a.charAt(i) != a.charAt(j)) {//if characters not equal return false
                test2Count++;
                return false;
            }//else keep incrementing
                i++;test2Count++;
                j--;test2Count++;

        }

        return true;

    }


    public static String reverse(String a) {// reverse method which is used for palindrome method 3, this is a recursive method
        String res;test3Count++;
        if (a.isEmpty()) {
            test3Count++;
            return a;
        }

        res = reverse(a.substring(1)) + a.charAt(0);test3Count++;
        return res;


    }

    public static boolean isPalindrome3(String a) {// palindrome method 3 basically compare the original string to what is returned from our reverse method
        String r = reverse(a);test3Count++;//reverse the string using method
        int i = 0;test3Count++;
        while (i < a.length() - 1) {
            test3Count++;
            if (a.charAt(i) != r.charAt(i)) {//if at any point it doesnt match return false
                test3Count++;
                return false;
            }//else keep incrementing
            i++;test3Count++;
        }

        return true;

    }

    public static boolean isPalindrome4(String a) {// palindrome method 4 involves using our stack and queue implementations then compare the digits on the stack to those in the queue
        ArrayStack stack = new ArrayStack();test4Count++;//declare stack and queue
        ArrayQueue queue = new ArrayQueue();test4Count++;

        for (int i = 0; i < a.length(); i++) {
            test4Count++;
            char ch = a.charAt(i);test4Count++;
            stack.push(ch);test4Count++;
            queue.enqueue(ch);test4Count++;

        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            test4Count++;

            if (stack.pop() != queue.dequeue()) {
                test4Count++;
                return false;
            }
        }
        return true;

    }

    public static String convert(String a) {//simple utility method to convert our integer numbers into binary
        int n = Integer.parseInt(a);
        return Integer.toBinaryString(n);
    }

    public static void main(String[] args) {// main method where i call each of our test methods
        range = 1000;
        interval = 100;
        num = 100;

        System.out.println("----------------Starting Test 1---------------- ");
        System.out.printf("Time: %.2f seconds\n", test1());
        System.out.println("Number of Operations: " + test1Count);

        num = 100;
        System.out.println("\n----------------Starting Test 2---------------- ");
        System.out.printf("Time: %.2f seconds\n", test2());
        System.out.println("Number of Operations: " + test2Count);

        num = 100;
        System.out.println("\n----------------Starting Test 3---------------- ");
        System.out.printf("Time: %.2f seconds\n", test3());
        System.out.println("Number of Operations: " + test3Count);

        num = 100;
        System.out.println("\n----------------Starting Test 4---------------- ");
        System.out.printf("Time: %.2f seconds\n", test4());
        System.out.println("Number of Operations: " + test4Count + "\n");

        System.out.println("----------------starting test 5----------------");
        test5();

    }
    private static double test1 () {// test1 where i test how long it takes for method palindrome1 to carry out on the first 1000000 numbers in integer and binary form
         count = 0;//reset values to 0
         count1 = 0;
         res1 =false;
         res2 = false;
        input = "";
         i = 1;
         test1Count = 0;
         double sTime = System.nanoTime();//start timer
         while (i <= range) { //iterate while i is less than the set range
            input = Integer.toString(i);//convert i to a string
            res1 = isPalindrome1(input);//set res1 as true or false depending on whether or not theres a palindrome
            String input2 = convert(input);//convert to binary string
           res2 = isPalindrome1(input2);//set res2 as true or false depending on whether or not theres a palindrome
            i++;
            if(res1){
                count++;//if res1 is true count
            }
            else if(res2){
                count1++;//if res2 is true count
            }
           else if(i % interval == 0){//print out the numbers at the set interval, this is what i used to graph my results
                System.out.println("POINT: " + num + " " + test1Count);
                num+= interval;
           }
        }
         //stop timer
        double eTime = System.nanoTime();
         System.out.println("Number of palindromes found: " + count + " " + count1);
        return (eTime - sTime)/1000000000;//return elapsed time

    }

    private static double test2() {// test2 where i test how long it takes for method palindrome2 to carry out on the first 1000000 numbers in integer and binary form
        count = 0;
        count1 = 0;// virtually the same as test 1 only i use the palindrome2 method
        res1 =false;
        res2 = false;
        input = "";
        i = 1;
        test2Count = 0;
        double sTime = System.nanoTime();
        while (i <= range) {
            input = Integer.toString(i);
          res1 = isPalindrome2(input);
            String input2 = convert(input);
           res2 = isPalindrome2(input2);
            i++;
            if(res1){
                count++;
            }
            else if(res2){
                count1++;
            }
           else if(i % interval == 0){
                System.out.println("POINT: " + num + " " + test2Count);
                num+= interval;
            }
        }
         double eTime = System.nanoTime();
        System.out.println("Number of palindromes found: " + count + " " + count1);
        return (eTime - sTime)/1000000000;
    }

    private static double test3() {// test3 where i test how long it takes for method palindrome3 to carry out on the first 1000000 numbers in integer and binary form
        count = 0;//virtually the same as test 1 only i use the palindrome3 method
        count1 = 0;
        res1 =false;
        res2 = false;
        input = "";
        i = 1;
         test3Count = 0;
        double sTime = System.nanoTime();
        while (i <= range) {
            input = Integer.toString(i);
            res1 =isPalindrome3(input);
            String input2 = convert(input);
            res2 = isPalindrome3(input2);
            i++;
            if(res1){
                count++;
            }
            else if(res2){
                count1++;
            }
             else if(i % interval == 0){
                System.out.println("POINT: " + num + " " + test3Count);
                num+= interval;
            }
        }
         double eTime = System.nanoTime();
        System.out.println("Number of palindromes found: " + count + " " + count1);
        return (eTime - sTime)/1000000000;
     }

    private  static double test4() {// test4 where i test how long it takes for method palindrome4 to carry out on the first 1000000 numbers in integer and binary form
        count = 0;// virtually the same as test 1 only i use the palindrome4 method
        count1 = 0;
        res1 =false;
        res2 = false;
        input = "";
        i = 1;
         test4Count = 0;
        double sTime = System.nanoTime();
        while (i <= range) {
            input = Integer.toString(i);
            res1 = isPalindrome4(input);
            String input2 = convert(input);
             res2 = isPalindrome4(input2);
            i++;
            if(res1){
                count++;
            }
            else if(res2){
                count1++;
            }
            else if(i % interval == 0){
                System.out.println("POINT: " + num + " " + test4Count);
                num+= interval;
            }
        }
         double eTime = System.nanoTime();
        System.out.println("Number of palindromes found: " + count + " " + count1);
        return (eTime - sTime)/1000000000;
    }

    private  static  void test5(){// test 5 just involves checking when we get true for the integer and true for the binary then just counting them
        count = 0;
        count1 = 0;
        res1 =false;
        res2 = false;
        input = "";
        i = 0;
        String input2;
        while (i <= range) {
            input = Integer.toString(i);
            res1 = isPalindrome2(input);
            input2 = convert(input);
            res2 = isPalindrome2(input2);
            i++;

            if(res1 && res2) {
                count++;
            }
        }
        System.out.println("There are " + count + " numbers where both are palindromes");
    }
}
