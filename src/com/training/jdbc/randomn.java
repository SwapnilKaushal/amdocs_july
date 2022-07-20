package com.training.jdbc;

public class randomn {
	public static int[] getRandomNumbersWithNoDuplicates(int range, int length){
	    if (length<range){
	        // this is where all the random numbers
	        int[] randomNumbers = new int[length];
	        
	        // loop through all the random numbers to set them
	        for (int q = 0; q < randomNumbers.length; q++){
	            
	            // get the remaining possible numbers
	            int remainingNumbers = range-q;
	            
	            // get a new random number from the remainingNumbers
	            int newRandSpot = (int) (Math.random()*remainingNumbers);
	            
	            newRandSpot++;
	            
	            // loop through all the possible numbers
	            for (int t = 1; t < range+1; t++){
	                
	                // check to see if this number has already been taken
	                boolean taken = false;
	                for (int number : randomNumbers){
	                    if (t==number){
	                        taken = true;
	                        break;
	                    }
	                }
	                
	                // if it hasnt been taken then remove one from the spots
	                if (!taken){
	                    newRandSpot--;
	                    
	                    // if we have gone though all the spots then set the value
	                    if (newRandSpot==0){
	                        randomNumbers[q] = t;
	                    }
	                }
	            }
	        }
	        return randomNumbers;
	    } else {
	        // invalid can't have a length larger then the range of possible numbers
	    }
	    return null;
	}
}
