import java.util.*;
class Main {

    public static int n;
    public static int k;
    public static int[] words;
    public static int maxn=0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        scan.nextLine();
        words = new int[n];
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            for(char c:s.toCharArray()){
                words[i]|=(1<<(c-'a'));
            }
        }
        solution(0,0,0);
        System.out.println(maxn);
    }
    public static void print(int mask){
        int count=0;
        for(int word:words){
            if((word&mask)==word){
                count++;
            }
        }
        maxn=Math.max(count,maxn);
    }
    public static void solution(int mask,int count,int index){
        if(count==k){
            print(mask);
            return;
        }
        if(index==26){
            return;
        }
        solution(mask|(1<<index),count+1,index+1);
        if(index!='a'-'a'&&index!='n'-'a'&&index!='c'-'a'&&index!='i'-'a'&&index!='t'-'a'){
            solution(mask,count,index+1);
        }
    }
}