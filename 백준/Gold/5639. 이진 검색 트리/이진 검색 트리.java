import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Node top;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Node current = null;
        while ((input = bf.readLine()) != null && !input.isEmpty()) {
            int number = Integer.parseInt(input);
            if (top == null) {
                top = new Node(number);
            } else {
                Node now = new Node(number);
                current = top;
                while (true){
                    if(current.number>now.number){
                        if(current.left!=null){
                            current=current.left;
                        }else{
                            break;
                        }
                    }else{
                        if(current.right!=null){
                            current=current.right;
                        }else{
                            break;
                        }
                    }
                }
                    if(current.number<now.number){
                        current.right=now;
                    }else{
                        current.left=now;
                    }
                    now.parent=current;
            }
        }
        print(top);
    }

    public static void print(Node cur) {
        if (cur.left != null) {
            print(cur.left);
        }
        if (cur.right != null) {
            print(cur.right);
        }
        System.out.println(cur.number);
    }


    public static class Node {
        public Node parent;
        public Node left;
        public Node right;
        public int number;

        public Node(int number) {
            this.parent = null;
            this.left = null;
            this.right = null;
            this.number = number;
        }
    }
}
