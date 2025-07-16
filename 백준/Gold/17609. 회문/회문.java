import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            int result = check(s);
            sb.append(result+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int check(String s){
        int startIndex = 0;
        int endIndex = s.length()-1;
        while (startIndex<endIndex){
            if(s.charAt(startIndex)==s.charAt(endIndex)){
                startIndex++;
                endIndex--;
                continue;
            }
            if(isPal(s,startIndex+1,endIndex) || isPal(s,startIndex,endIndex-1)) return 1;
            return 2;
        }
        return 0;
    }

    private static boolean isPal(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
}
