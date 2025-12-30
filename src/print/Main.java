package print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        while(cnt-- > 0){
            String name = br.readLine();
            System.out.println("Hello, " + name + "!");
        }
    }
}