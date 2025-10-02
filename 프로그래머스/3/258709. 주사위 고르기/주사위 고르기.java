import java.util.*;

class Solution {
    private static int n;
    
    private static int[] winDice;
    private static int win = 0;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        go(dice,new int[n/2],new int[n/2],0,0,0);
        return winDice;
    }
    
    private void go(int[][] dice,int[] a, int[] b,int cnt, int ai,int bi){
        if(cnt==n){
            check(a,b,dice);
            return;
        }
        if(ai<n/2){
            a[ai]=cnt+1;
            go(dice,a,b,cnt+1,ai+1,bi);
            a[ai] = 0;
        }
        if(bi<n/2){
            b[bi]=cnt+1;
            go(dice,a,b,cnt+1,ai,bi+1);
            b[bi]=0;
        }
    }
    
    private void check(int[] a, int[] b, int[][] dice){
        List<Integer> aSums = getSums(dice, a, 0, 0);
        List<Integer> bSums = getSums(dice, b, 0, 0);
        Collections.sort(bSums);

        int winCnt = 0;
        for (int x : aSums) {
            int idx = Collections.binarySearch(bSums, x);
            if (idx < 0) {
                idx = -(idx + 1);  // 삽입 위치
            } else {
                while (idx > 0 && bSums.get(idx - 1) == x) {
                    idx--;
                }
            }
            winCnt += idx;  // x보다 작은 원소 개수
        }

        if (win < winCnt) {
            win = winCnt;
            winDice = Arrays.copyOf(a, a.length);
        }
    }
    
    private List<Integer> getSums(int[][] dice, int[] picks, int idx, int sum) {
        List<Integer> res = new ArrayList<>();
        if (idx == picks.length) {
            res.add(sum);
            return res;
        }
        int diceIdx = picks[idx] - 1;
        for (int val : dice[diceIdx]) {
            res.addAll(getSums(dice, picks, idx + 1, sum + val));
        }
        return res;
    }
}