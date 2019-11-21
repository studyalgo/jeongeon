package programmers.dfsNbfs;

public class Word {

    static boolean[] v;     //remember node
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        v = new boolean[words.length + 1];   //started word is hit
        
        for(String word : words){
            if(target.equals(word))
                answer = dfs(begin, target, words);
        }
        return answer;
    }
    
    //±íÀÌ¿ì¼±Å½»ö »ç¿ë
    public int dfs(String begin, String target, String[] words){
        int answer = 0;
        String rBegin;
        
        for(int i = 0; i < words.length; i++ ){
            if(v[i])
                continue;
            
            for(int j =0; j < begin.length(); j++){
                rBegin = (j > 0) ? begin.substring(0, j) : "";
                rBegin += words[i].charAt(j);
                rBegin += (j < begin.length() - 1) ? begin.substring(j+1) : "" ;
            
                if(rBegin.equals(target))
                    return 1;
                if(rBegin.equals(words[i])){
                    v[i] = true;
                    answer++;
                    answer += dfs(rBegin, target, words);
                }
            }
        }
        return answer;
    }
}