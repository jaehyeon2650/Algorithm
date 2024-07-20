import java.util.*;
class Main {
    public static int n;
    public static int food[][];
    public static int limit[]=new int[4];
    public static int price[];
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        food=new int[n][4];
        price=new int[n];
        for(int i=0;i<4;i++){
            limit[i]= scan.nextInt();;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                food[i][j]= scan.nextInt();
            }
            price[i]= scan.nextInt();
        }
        solution();
    }

    public static void solution(){
        int maxn=-1;
        int minprice=Integer.MAX_VALUE;
        for(int i=0;i<(1<<n);i++){
            int prices=0;
            int sums[]=new int[4];
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0){
                    for(int k=0;k<4;k++){
                        sums[k]+=food[j][k];
                    }
                    prices+=price[j];
                }
            }
            boolean can=true;
            for(int j=0;j<4;j++){
                if(sums[j]<limit[j]){
                    can=false;
                    break;
                }
            }
            if(can){
                if(minprice>prices){
                    minprice=prices;
                    maxn=i;
                }else if(minprice==prices){
                    String s1="";
                    String s2="";
                    for(int j=0;j<n;j++){
                        if((maxn&(1<<j))>0){
                            s1+=(j+1);
                        }
                    }
                    for(int j=0;j<n;j++){
                        if((i&(1<<j))>0){
                            s2+=(j+1);
                        }
                    }
                    if(s2.compareTo(s1)<0){
                        maxn=i;
                    }
                }
            }
        }
        if(maxn!=-1){
            System.out.println(minprice);
            for(int i=0;i<n;i++){
                if((maxn&(1<<i))>0){
                    System.out.print(i+1+" ");
                }
            }
        }else{
            System.out.println(-1);
        }
    }
}