import java.io.*;
import java.util.*;
class Main {

    public static String words;
    public static boolean can=true;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        words = scan.nextLine();
        check(0);
        if(can){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    public static void check(int index){
        if(index==words.length()-1){
            can=false;
            return;
        }
        if(index>=words.length()){
            return;
        }
        if(words.substring(index,index+2).equals("pi")||words.substring(index,index+2).equals("ka")){
            check(index+2);
        }else if(index<=words.length()-3&&words.substring(index,index+3).equals("chu")){
            check(index+3);
        }else{
            can=false;
        }
    }
}