URL:
https://www.interviewcake.com/question/java/find-rotation-point

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        final String firstword = words[0]; 
        int ceilingIndex = words.length -1;
        int floorIndex = 0;
        
        
        // loop to find the rotation point
        while(floorIndex<ceilingIndex){
            int guessIndex = floorIndex + (ceilingIndex - floorIndex)/2;
            
            String guessword = words[guessIndex];
            
            /* CompareTo result
            An int value: 0 if the string is equal to the other string.
            < 0 if the guess word string is lexicographically less than the second string
            > 0 if the guess word string is lexicographically greater than the other string (more characters)
             */
            if(guessword.compareTo(firstword) < 0){ // negative -- Guessword is started alphabetically than firstword
                ceilingIndex = guessIndex; // go left
            }
            else{
                floorIndex = guessIndex;
            }
            
            if(floorIndex+1 == ceilingIndex){
                return ceilingIndex;
            }
        }
        return 0;
    }
