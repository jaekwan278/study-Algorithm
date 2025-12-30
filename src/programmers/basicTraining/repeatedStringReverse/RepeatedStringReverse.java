package programmers.basicTraining.repeatedStringReverse;

// 문자열 여러 번 뒤집기

public class RepeatedStringReverse {

    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);

        for(int[] arr : queries){
            int start = arr[0];
            int end = arr[1];

            while(start < end){
                char tmp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, tmp);

                start++;
                end--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RepeatedStringReverse task = new RepeatedStringReverse();
        String my_string = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};

        System.out.println(task.solution(my_string, queries));
    }

}
