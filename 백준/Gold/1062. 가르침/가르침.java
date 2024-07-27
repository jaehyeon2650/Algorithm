import java.util.*;
class Main {

    public static int n;
    public static int k;
    public static int[][] words;
    public static int maxn=0;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        k=scan.nextInt();
        words=new int[n][27];
        for(int i=0;i<n;i++){
            String s=scan.next();
            for(int j=0;j<s.length();j++){
                if(words[i][s.charAt(j)-'a']==0){
                    words[i][s.charAt(j)-'a']=1;
                }
            }
        }
        int[] b=new int[26];
        solution(b,0,0);
        System.out.println(maxn);
    }
    public static void print(int[] b){
        int count=0;
        for(int[] word:words){
            boolean can=true;
            for(int i=0;i<word.length;i++){
                if(word[i]==1&&b[i]!=1){
                    can=false;
                    break;
                }
            }
            if(can) count++;
        }
        maxn=Math.max(count,maxn);
    }
    public static void solution(int[] b,int count,int index){
        if(count==k){
            print(b);
        }
        if(index==26){
            return;
        }
        b[index]=1;
        solution(b,count+1,index+1);
        b[index]=0;
        if(index!='a'-'a'&&index!='n'-'a'&&index!='t'-'a'&&index!='i'-'a'&&index!='c'-'a'){
            solution(b,count,index+1);
        }
    }
}