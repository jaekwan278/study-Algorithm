package print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SimplePrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        String name = st.nextToken();

//        int cnt = Integer.parseInt(br.readLine());

        while(cnt-- > 0){
//            String name = br.readLine();
            System.out.println("Hello, " + name + "!");
        }
    }
}