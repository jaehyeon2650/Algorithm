
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Map;
    import java.util.PriorityQueue;
    import java.util.Queue;
    import java.util.StringTokenizer;
    import java.util.TreeMap;

    public class Main {

        private static int n;
        private static Map<String, Son> info = new TreeMap<>();
        private static boolean[][] checks = new boolean[11][7];

        static class Son {
            int week;
            int day;
            int money;

            public Son(final int week, final int day, final int money) {
                this.week = week;
                this.day = day;
                this.money = money;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(bf.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                info.put(st.nextToken(), new Son(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())));
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String name = st.nextToken();
                int price = Integer.parseInt(st.nextToken());
                Son son = info.get(name);
                if (son.money > price) {
                    info.remove(name);
                }
            }
            int maxCount = 0;
            int nowCount = 0;
            for (Son value : info.values()) {
                checks[value.week][value.day]=true;
            }
            for(int i=1;i<11;i++){
                for(int j=0;j<7;j++){
                    if(checks[i][j]){
                        nowCount++;
                    }else{
                        maxCount = Math.max(maxCount, nowCount);
                        nowCount=0;
                    }
                }
            }
            maxCount = Math.max(maxCount, nowCount);
            System.out.println(maxCount);
        }
    }
