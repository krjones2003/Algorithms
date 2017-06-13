package for_practice;

import java.util.Arrays;

public class Solution {

//AN INTERVIEW QUESTION I GOT:
	
	/* a method that returns the number of contiguous sub-arrays whose products are less than k */
	static int count(int[] numbers, int k){
		int test;
		int count = 0;
		for(int j = 0; j < numbers.length; j++ ){
			test = 1;
			for(int i = j; (i<numbers.length)&&(test<k); i++){
				test *= numbers[i];
				if(test < k) {
					count++;
				}//if
			}//inner for
		}//outer for
		return count;
	}//solve
	
	
//WARMUP QUESTIONS FROM HACKERRANK:
	
	/* a utility method for staircase that repeats a string n times*/
	static String repeat(String myString, int myInt){
        String toReturn = "";
        for(int i = 0; i < myInt; i++){
            toReturn += myString;
        }//
        return toReturn;
    }
	
	/* a method that prints a left-justified staircase of pound signs, n steps tall*/
	static String staircase(int n){
		String line = "";
		for(int i = 1; i <= n; i++){
            line += repeat(" ", n-i) + repeat("#", i) + "\n";
        }
		return line;
	}
	
	/* a method for returning the minimum and maximum sums of 4 longs in a 5-long array */
	static long[] minMaxSum(long[] myArray){
        long sum = 0L;
        for(int m = 0; m < 5; m++){
            sum += myArray[m];
        }
        long min = sum;
        long max = 0;
        int k = 0;
        long mysum = 0L;
        while (k < 5){
           mysum = sum;
           mysum = mysum - myArray[k];
           if(mysum > max){
               max = mysum;
           }       
           if(mysum < min){
               min = mysum;
           } 
           k++;
        }
        long[] myReturn = new long[2];
        myReturn[0] = min;
        myReturn[1] = max;
        return myReturn;    
    }
	
	/* a method to return the number of tallest candles on a birthday cake with n candles */
	static int birthdayCake(int[] heights, int n){
		int max = 0;
        int numMax = 0;
        for(int i = 0; i < n; i++){
            if (heights[i] > max){
                max = heights[i];
            }
        }
        for(int j = 0; j < n; j++) {
            if(heights[j]==max){
                numMax++;
            }
        }
        return numMax;
	}
	
	/* method to convert American time in String format to European time in String format */
	static String timeConversion(String a){
        char[] ch = a.toCharArray();
        int length = ch.length;
        Character time = ch[length-2];
        String pM = "";
        pM += ch[0];
        pM += ch[1];
        int number = Integer.parseInt(pM);
        if(time.equals('P')){
            if(number==12){
                String toReturn = "";
                for (int i = 0; i < length-2; i++){
                    toReturn += ch[i];
                }
                return toReturn;
            }                
            int answer = number + 12;
            String stAns = Integer.toString(answer);
            char[] ch2 = stAns.toCharArray();
            ch[0] = ch2[0];
            ch[1] = ch2[1];
            String toReturn = "";
            for(int i = 0; i < length -2; i++){
                toReturn += ch[i];
            }
            return toReturn;
        }else{ 
            if(number==12){
                ch[0] = '0';
                ch[1] = '0';
                String answer = "";
                for (int i = 0; i < length-2; i++){
                    answer += ch[i];
                }
                return answer;
            }
            String aM = "";
            for(int i = 0; i < length-2; i++){
                aM += ch[i];
            }
            return aM;
        }
	}//timeConversion
	
	
	//IMPLEMENTATION QUESTIONS FROM HACKERRANK:
	
	/* a method to calculate rounded grades */
	/* round up to next multiple of 5 if distance to that multiple is less than 3 */
	/* if grade is less than 38, do nothing */
	static int[] grade(int[] grades){
        int myMod = 0;
        for(int i = 0; i < grades.length; i++){
            if(grades[i]<38){
                ; //do nothing
            }else{
            	myMod = grades[i]%5;
            	if(myMod == 3){
            		grades[i] = grades[i] + 2;
            	}//if
            	if (myMod == 4){
            		grades[i] = grades[i] + 1;
            	}//if
            }//else
        }//for
        return grades;
    }
	
	/* a method that prints the number of apples and oranges that fall on a house. given distances */
	static int[] applesOranges(int[] apples, int[]oranges, int s, int t, int a, int b){
        int numApples = 0;
        int numOranges = 0;
        for(int i = 0; i < apples.length; i++){
            if (apples[i] < 0){
                ;//do nothing, ignore negative
            }else{
                int applePosition = a + apples[i];
                if(applePosition >= s && applePosition <= t){
                    numApples++;
                }
            }//else
        }//for
        for(int i = 0; i < oranges.length; i++){
            if (oranges[i] > 0){
                ;//do nothing, ignore positive
            }else{
                int orangePosition = b + oranges[i];
                if(orangePosition >= s && orangePosition <= t){
                    numOranges++;
                }
            }//else
        }//for
        
        int[] answer = new int[2];
        answer[0] = numApples;
        answer[1] = numOranges;
        return answer;
    }
	
	//from HackerRank.  I'm too tired to set up the test for it, but it passed HR.
	static int betweenTwoSets(int n, int m, int[] myNArray, int[] myMArray){
        int count = 0;
        int myAnswer = 0;
       boolean isFactor;
       boolean isFactor2;
       int[] myArray = new int[100];
       if(myNArray[0]==1){
           if(myNArray.length == 1){
            for(int j = 1; j <= 100; j++){
                isFactor = true;
                for(int i = 0; i < m && isFactor; i++){
                    if(myMArray[i]%j ==0){
                        if(i == (m-1)){
                            count++;
                        }
                    } else {
                        isFactor = false;
                    }
                }
            }
            return count;
           }
        } else{
            for(int j = 2; j <= 100; j++){ 
                isFactor = true;
                for(int i = 0; i < m && isFactor; i++){
                    if(myMArray[i]%j == 0){//j a factor...
                        if(i == (m-1)){//...for everything in mArray
                            myArray[count] = j; //add it to array of common factors of mArray items
                            count++;
                        }
                    }else{
                        isFactor = false; //it's not a factor, move to next j
                    }
                }//for
            }//for
        }//else
        //test that nArray items are all factors of myArray:
        for(int j = 0; j < count; j++){
            isFactor2 = true;
            for(int i = 0; i < n && isFactor2; i++){
                if(myArray[j] % myNArray[i] ==0){
                    if(i == (n-1)){
                        myAnswer++;
                    }//inner if       
                 }else{
                    isFactor2 = false;
                }
            }//for
        }//for
        return myAnswer;
    }//betweenTwoSets
	
	/* method to return number of times best score increased and number of times worst score decreased in array */
	static int[] getRecord(int[] s){
        int best = s[0];
        int worst = s[0];
        int increased = 0;
        int decreased = 0;
        int[] myAnswer = new int[2];
        for(int i = 0; i < s.length; i++){
            if(s[i] > best){
                increased++;
                best = s[i];
            }
            if(s[i] < worst){
                decreased++;
                worst = s[i];
            }
        }//for
        myAnswer[0] = increased;
        myAnswer[1] = decreased;
        return myAnswer;
        
    }
	
	/* a method to return the number of contiguous subarrays of size m whose sum is d */
	static int getWays(int[] squares, int d, int m){
        int sum;
        int total = 0;
        for(int i = 0; i < squares.length; i ++){
            sum = 0;
            for(int j = i; j < (i+m) && (i+m) <= squares.length; j++){
                sum += squares[j];
            }
            if (sum == d){
                total++;
            }//if
        }//for
        return total;   
    }
	
	//trying the pound pyramid again using only my repeat method
	static void tryAgain(int n){
		String myString = "";
			for(int i = 1; i <= n; i++ ){
				myString = repeat(" ", n-i);
				System.out.print(myString);
				myString = repeat("#", i);
				System.out.print(myString);
				System.out.println();
			}	
	}
	
	/* a method that returns the number of (i,j) pairs in an array of n numbers a(0)...(a(n-1)
	 * where i < j and a(i) + a(j) is evenly divisible by K*/
	public static int divisibleSumPairs(int k, int n, int [] a){
		int myCount = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if((a[i]+a[j])%k == 0){
                    myCount++;
                }
            }//inner for
        }//outer for
        return myCount;
	}
	
	/* a method to return the type of most commonly occurring number in an array
	 * where the numbers are always 1, 2, 3, 4 or 5 */
	public static int migratoryBirds(int[] types){
		int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        for(int i = 0; i < types.length; i++){
            if(types[i]==1){
                one++;
            }else if (types[i]==2){
                two++;
            }else if (types[i]==3){
                three++;
            }else if (types[i]==4){
                four++;
            }else{
                five++;
            }
        }
        int[] myAnswer = new int[6];
        myAnswer[1] = one;
        myAnswer[2] = two;
        myAnswer[3] = three;
        myAnswer[4] = four;
        myAnswer[5] = five;
        int max = myAnswer[1];
        for(int j = 2; j < 6; j++){
            if(myAnswer[j]>max){
                max = myAnswer[j];
                myAnswer[0] = j;
            }
        }
        return myAnswer[0];
	}
	
	/* a method that returns the date of the 256th day of the year in 
	 * Russia, given the year
	 */
	static String dayOfProgrammer(int year){
        String toReturn ="";
        if(year > 1918){//Gregorian calendar
            if((year%400==0) || (year%4==0 && year%100!=0)){//leap year, add one day
                toReturn = "12.09." + year;
            }else{
                toReturn = "13.09." + year;
            }
        }//year greater than 1918
        else if(year==1918){//switch year between calendars
            toReturn = "26.09.1918";
        }else{//Julian calendar
            if(year%4==0){//leap year, add one day
                toReturn = "12.09." + year;
            }else{
                toReturn = "13.09." + year;
            }
        }
        return toReturn;
    }
	
	/*
	 * a method to split a restaurant bill: given
	 * an array of item costs, and a kth item that Anna didn't eat, split the bill and determine whether 
	 * what Brian charged Anna was fair (and return "Bon Appetit") or else return Anna's refund.
	 */
	public static String bonAppetit(int n, int k, int[] itemsCost, int charge){
        double shouldPay = 0.0;
        double refund = 0.0;
        //calculate what Anna should pay
        for(int i = 0; i < n; i++){
            if(i==k){
                ;//do nothing
            }else{
                shouldPay += (itemsCost[i]/2.0);
            }
        }
        double myCharge = (double)charge;
        if(myCharge == shouldPay){
            return "Bon Appetit";
        }else{
            refund = myCharge - shouldPay;
            int myRefund = (int)refund;
            return Integer.toString(myRefund);
        }   
    }
	
	/*
	 * a method to return the total number of matching pairs in an array,
	 * where pair values span 1 to 100
	 */
	 public static int sockMerchant(int[] c){
	        int numPairs = 0; 
	        int[] pairs = new int[101];//indices 1-100 represent sock values
	        for(int i = 0; i < 101; i++){
	            pairs[i] = 0; //initialize to 0
	        }
	        for(int j = 0; j < c.length; j++){
	            pairs[c[j]]++; //at index in pairs representing the number in c, increment by 1
	        }
	        for(int k =1; k < 101; k++){
	            if(pairs[k]==0){
	                ;//do nothing
	            }else {
	                numPairs += pairs[k]/2;
	            }
	        }
	        return numPairs;    
	    }//sockMerchant
	
	 //Honestly this HR question was really annoying, 
	 //so I'm not going to explain it, but I got it right.
	 static int drawingBook(int n, int p){
	        if(n%2 != 0){//n is odd
	            if(p == n || p == n-1){
	                return 0;
	            }
	            int j = n - 1;
	            int turnsBackward = 0;
	            while(j > p){
	                j = j - 2;
	                turnsBackward ++;
	            }
	            int i = 1;
	            int turnsForward = 0;
	            while(i < p){
	                i = i+2;
	                turnsForward++;
	            }
	            if(turnsBackward < turnsForward){
	                return turnsBackward;
	            }
	            return turnsForward;
	        } else{ //n is even
	            if(p == n){
	                return 0;
	            }
	            int j = n;
	            int turnsBackward = 0;
	            while(j > p){
	                j = j - 2;
	                turnsBackward ++;
	            }
	            int i = 1;
	            int turnsForward = 0;
	            while(i < p){
	                i = i+2;
	                turnsForward++;
	            }
	            if(turnsBackward < turnsForward){
	                return turnsBackward;
	            }
	            return turnsForward;
	        }
	    }
	 
	 
	 /*
	  * A method to return the number of "valleys," defined as spans of negative
	  * values bookended by zeroes, that occur in a "hike," defined as a string
	  * signifying up and down steps, such as UDDUUUDDDDU
	  */
	 public static int countingValleys(int len, String stringy){
		 //turn string into an array of rising and sinking values
		 int[] nums = new int[len + 1];
	        nums[0] = 0;
	        for(int i = 0; i < len; i++){
	            if(stringy.charAt(i)=='D'){
	                nums[i+1] = nums[i] - 1;
	            }else{
	                nums[i+1] = nums[i] + 1;
	            }
	        }
	       //track sections of negatives bookended by zeroes
	        int valleys = 0;
	        boolean zeroWaiting = true;
	        boolean negsAccumulating = false;
	        for(int j = 1; j < len+1; j++){
	           if(nums[j] > 0){
	               zeroWaiting = false;
	           }
	           if(nums[j] < 0){
	               if(zeroWaiting){
	                   negsAccumulating = true;
	               }
	           }
	           if(nums[j] == 0){
	               zeroWaiting = true;
	               if(negsAccumulating){
	                   valleys++;
	                   negsAccumulating = false;
	               }
	           }
	        }    
	         return valleys;   
	    }
	 
	 /*
	  * A method to return the maximum amount of money that can be spent on exactly one
	  * keyboard and one drive, where total must be less than or equal to s, or else -1
	  * if condition cannot be met.
	  */
	 static int getMoneySpent(int[] keyboards, int[] drives, int s){
	        int maxPrice = -1;
	        int price = 0;
	        for(int i = 0; i < keyboards.length; i++){
	            for(int j = 0; j < drives.length; j++){
	                price = keyboards[i] + drives[j];
	                if(price > maxPrice && price <= s){
	                    maxPrice = price;
	                }
	            }//inner for
	        }//outer for
	       return maxPrice;  
	    }
	 
	 /*
	  * a method to determine which of 2 "cats" (which number of 2 numbers) is closer to the "mouse" (the third number),
	  * given an array containing n sets of 3.
	  */
	 public static String catsMouse(int[] myArray){
	        String toReturn = "";
	        for(int i = 0; i <= (myArray.length - 3); i=i+3){
	            int diffA = java.lang.Math.abs(myArray[i+2] - myArray[i]);
	            int diffB = java.lang.Math.abs(myArray[i+2] - myArray[i+1]);
	            if(diffA < diffB){
	                toReturn += "Cat A \n";
	            }else if (diffA > diffB){
	                toReturn += "Cat B \n";
	            }else{
	                toReturn += "Mouse C \n";
	            }
	        }
	        return toReturn;
	    }
	 
	 /*
	  * A method that prints the maximum number of integers you can select from a given array 
	  * such that the absolute difference between any two of the chosen integers
	  * is less than or equal to 1.
	  */
	 public static int solve(int[] a){
	        Arrays.sort(a);
	        int max = 0;
	        for(int i = 0; i < a.length-1; i++){
	            int count = 1;
	            for(int j = i+1; j < a.length; j++){
	                if(java.lang.Math.abs(a[i] - a[j]) <= 1){
	                    count++;
	                }
	            }//inner
	            if (count > max){
	                max = count;
	            }
	        }//outer
	        return max;   
	    }
	 
	 
	 /*
	  * a method to return the minimum sum of two numbers from two arrays,
	  * where the indices can never be the same.
	  */
	 static int twinArrays1(int[] ar1, int[] ar2){
	        int length = ar1.length;
	        int min = ar1[0] + ar2[1];
	        int sum = 0;
	        for(int i = 0; i < length; i++){
	            for(int j = 0; j != i && j < length; j++){
	                    sum = ar1[i] + ar2[j];
	                    if(sum < min){
	                        min = sum;
	                    }
	                }
	            }
	        
	        return min;
	    }
	 
	 /*
	  * More efficient version of twinArrays1
	  */
	 static int twinArrays2(int[] ar1, int[] ar2){
	        int length = ar1.length;
	        
	        //find min of ar1
	        int min1 = ar1[0];
	        int index1 = 0;
	        for(int i = 0; i < length; i++){
	            if(ar1[i] < min1){
	                min1 = ar1[i];
	                index1 = i;
	            }
	        }
	        //find min of ar2
	        int min2 = ar2[0];
	        int index2 = 0;
	        for(int j = 0; j < length; j++){
	            if(ar2[j] < min2){
	                min2 = ar2[j];
	                index2 = j;
	            }
	        }
	        //make sure their indices are not the same
	        if(index1 != index2){
	            return (min1 + min2);
	        }
	        //if they were the same, find the next min for ar1
	        int nextMin1 = (int)Math.pow(10, 5);   
	        for(int k = 0; k != index1 && k < length; k++){
	            if(ar1[k] < nextMin1){
	                nextMin1 = ar1[k];
	            }
	        }
	        //find next min for ar2
	        int nextMin2 = (int)Math.pow(10, 5);
	        for(int l = 0; l != index2 && l < length; l++){
	            if(ar2[l] < nextMin2){
	                nextMin2 = ar2[l];
	            }
	        }
	        //test possible combinations
	        int sum1 = min1 + nextMin2;
	        int sum2 = nextMin1 + min2;
	        
	        if(sum1 < sum2){
	            return sum1;
	        }
	        return sum2;
	    }
	 
	
	public static void main(String[] args) {
		System.out.println("Testing the method count:");
		int[] myArray = new int[3];
		for(int i = 0; i < 3; i++){
			myArray[i] = i+1;
		}
		
		int k = 6;
		int m = 7;
		int q = 110;
		int answer1 = count(myArray, k);
		int answer2 = count(myArray, m);
		
		
		int[] myArray2 = new int[5];
		for(int i = 0; i < 5; i++){
			myArray2[i] = i+1;
		}
		int answer3 = count(myArray2, q);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);

		
		System.out.println();
		System.out.println("Testing staircase method:");
		System.out.println(staircase(6));
		
		
		System.out.println();
		long[] myMinMaxSum = new long[5];
		myMinMaxSum[0] = 1L;
		myMinMaxSum[1] = 2L;
		myMinMaxSum[2] = 3L;
		myMinMaxSum[3] = 4L;
		myMinMaxSum[4] = 5L;
		System.out.println("Testing minMaxSum method:");
		long[] myMinMaxResult = new long[2];
		myMinMaxResult = minMaxSum(myMinMaxSum);
		System.out.print((myMinMaxResult[0]));
		System.out.print(" ");
		System.out.println(myMinMaxResult[1]);
		
		System.out.println();
		System.out.println("Testing birthdayCake method:");
		int[] cakeArray = new int[5];
		cakeArray[0] = 1;
		cakeArray[1] = 2;
		cakeArray[2] = 3;
		cakeArray[3] = 3;
		cakeArray[4] = 2;
		
		int candleNum = birthdayCake(cakeArray, 5);
		System.out.println(candleNum);
		System.out.println();
		
		System.out.println("Testing time conversion method:");
		System.out.println("07:45:05PM converts to");
		System.out.println(timeConversion("07:45:05PM"));
		System.out.println("00:00:00AM converts to:");
		System.out.println(timeConversion("00:00:00AM"));
		System.out.println("12:00:00PM converts to:");
		System.out.println(timeConversion("12:00:00PM"));
		
		System.out.println();
		System.out.println("Testing grades");
		int[] grades = new int[4];
		grades[0] = 73;
		grades[1] = 67;
		grades[2] = 38;
		grades[3] = 33;
		int[] gradesAnswer = new int[4];
		gradesAnswer = grade(grades);
		for(int i = 0; i < 4; i++){
			System.out.print(gradesAnswer[i] + " ");
		}
	
		System.out.println();
		System.out.println();
		System.out.println("Testing getWays");
		int numberWays = getWays(grades, 140, 3);
		System.out.println(numberWays);
		
		System.out.println("trying again:");
		tryAgain(5);
	
		System.out.println("Testing divisibleSumPairs:");
		int[] divSumPairs = new int[6];
		divSumPairs[0] = 1;
		divSumPairs[1] = 3;
		divSumPairs[2] = 2;
		divSumPairs[3] = 6;
		divSumPairs[4] = 1;
		divSumPairs[5] = 2;
		int divSumAnswer = divisibleSumPairs(3, 6, divSumPairs);
		System.out.println(divSumAnswer);
		
		divSumPairs[3] = 2;
		System.out.println("Testing migratoryBirds (should be 2):");
		int birdsAnswer = migratoryBirds(divSumPairs);
		System.out.println(birdsAnswer);
		
				
	}
		
		
}
