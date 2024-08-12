import java.io.*;
import java.util.*;

class Main {
    public static int n;

    public static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        array=new int[n][8];
        for(int i=0;i<n;i++){
            String s=bf.readLine();
            for(int j=0;j<s.length();j++){
                array[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int m=Integer.parseInt(bf.readLine());
        for(int i=0;i<m;i++){
            String s= bf.readLine();
            String[] strings = s.split(" ");
            int a=Integer.parseInt(strings[0]);
            int b=Integer.parseInt(strings[1]);
            int[] rotates=new int[n];
            rotates[a-1]=b;
            rotate(a-1,rotates);
            change(rotates);
        }
        int total=0;
        for(int i=0;i<n;i++){
            if(array[i][0]==1) total++;
        }
        System.out.println(total);
    }

    public static void rotate(int index,int[] rotate){
        for(int i=index-1;i>=0;i--){
            if(rotate[i+1]==0) continue;
            if(array[i+1][6]==array[i][2]){
                rotate[i]=0;
            }else{
                rotate[i]=rotate[i+1]*-1;
            }
        }
        for(int i=index+1;i<n;i++){
            if(rotate[i-1]==0) continue;
            if(array[i-1][2]==array[i][6]){
                rotate[i]=0;
            }else{
                rotate[i]=rotate[i-1]*-1;
            }
        }
    }
    public static void change(int[] rotate){
        for(int i=0;i<n;i++){
            if(rotate[i]==1){
                int temp=array[i][7];
                for(int j=7;j>0;j--){
                    array[i][j]=array[i][j-1];
                }
                array[i][0]=temp;
            }else if(rotate[i]==-1){
                int temp=array[i][0];
                for(int j=0;j<7;j++){
                    array[i][j]=array[i][j+1];
                }
                array[i][7]=temp;
            }
        }
    }
}