package for_practice;

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
	
	}
	

}
