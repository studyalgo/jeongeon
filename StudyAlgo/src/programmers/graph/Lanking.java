package programmers.graph;
import java.util.*;

public class Lanking {
	
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n][n];
        
        for(int[] r : results){
            map[r[0] - 1][r[1] - 1] = 1;
        }
        //System.out.println(Arrays.deepToString(map));
        
        for (int i = 0; i < n; ++i) {
            boolean isConnected = true;
        
            for (int j = 0; j < n; ++j) {
                if (i != j && !isLinked(map, i, j)) {
                    isConnected = false;
                    break;
                }
            }
            if (isConnected) answer++;
        }
        return answer;
    }
    
    boolean isLinked(int[][] map, int i, int j){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[map.length];
        int inCnt = 0;
        int outCnt = 0;
        
        st.push(i);
        visited[i] = true;
        
        while(!st.empty()){
            int idx = st.pop();
            for(int k = 0; k < map.length; k++){
                if(map[idx][k] == 1 && !visited[k]){
                    st.push(k);
                    visited[k] = true;
                    outCnt++;
                }
            }
        }
        
        
        System.out.println(outCnt);
        return false;
    }
    
}