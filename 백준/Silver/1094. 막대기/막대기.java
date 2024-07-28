import java.util.*;
class Main {

    public static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int count=0;
        for(int i=1;i<=64;i=(i<<1)){
            if((n&i)>0){
                count++;
            }
        }
        System.out.println(count);
    }

}