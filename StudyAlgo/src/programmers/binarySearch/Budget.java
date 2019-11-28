package programmers.binarySearch;

import java.util.Arrays;

public class Budget {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        
        Arrays.sort(budgets);
        
        int total = 0;
        for(int budget: budgets) 
            total += budget;
        
        if(total <= M) 
            return budgets[budgets.length-1];
        
        int max = budgets[budgets.length-1];
        int min = (int) Math.floor(M / budgets.length);
        int mid = 0;
        int compareMid = 0;
        
        while(true){
        	mid = (int) Math.ceil((max+min) / 2);
        	total = 0;
        	
        	for(int budget: budgets) 
                total += ( budget > mid ) ? mid : budget;
        	
    		if(mid == compareMid){
    			answer = mid;
    			break;
    		}
        	
        	if(total > M){
        		max = mid;
        	} else {
        		min = mid;
        	}
        	compareMid = mid;
        }
        
        return answer;
    }

}
