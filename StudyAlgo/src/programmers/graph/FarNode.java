package programmers.graph;
import java.util.*;

public class FarNode {
    public int solution(int n, int[][] edge) {
        int answer;
        int[][] map = new int[n][n];

        for(int i = 0; i < edge.length; i++ ){
            map[edge[i][0] - 1][edge[i][1] - 1] = map[edge[i][1] - 1][edge[i][0] - 1] = 1;
        }
        //System.out.println(Arrays.deepToString(map));
        answer = bfs(1, map);
       
        return answer;
    }
    
    int bfs(int r, int[][] map){
        Queue<Integer> q = new LinkedList<>();
        int[] cntArr = new int[map.length];
        Arrays.fill(cntArr, -1);
        r = r - 1;  // 1st node : index 0
        cntArr[r] = 0;
        q.offer(r);
        while(!q.isEmpty()){
            r = q.poll();
            for(int i = 0; i < map.length; i++ ){
                if(map[r][i] == 1 && cntArr[i] == -1){
                    cntArr[i] = cntArr[r]+1;
                    q.offer(i);
                }
            } 
        }
        int maxVal = 0;
        int cnt = 0;
        
        for(int c : cntArr){
            maxVal = (maxVal > c) ? maxVal : c;
        }
        for(int c : cntArr){
            if(maxVal == c) 
                cnt++;
        }

        return cnt;
    }
}