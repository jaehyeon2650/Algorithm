class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int x, int[][] computers){
        visited[x]=true;
        int[] connectComputer = computers[x];
        
        for(int i=0;i<connectComputer.length;i++){
            if(connectComputer[i]==1 && !visited[i]){
                dfs(i,computers);
            }
        }
    }
}