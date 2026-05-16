package programmers.intro.cutAndSaveArr;

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutAndSaveArr {
    public String[] solutionA(String my_str, int n) {
        String[] answer = {};

        List<String> list = new ArrayList<>();
        makeStringArr(my_str, n, list);

        return list.toArray(new String[0]);
    }
    public String[] solutionB(String my_str, int n) {
        int size = (my_str.length() + n - 1) / n;

        String[] answer = new String[size];

        int start = 0;
        for(int i = 0; i < size; i++){

            answer[i] = my_str.substring(start, Math.min((start + n), my_str.length()));
            start += n;
        }

        return answer;
    }

    public void makeStringArr(String str, int n, List<String> list){
        if(str.isEmpty()) return;

        int end = Math.min(n, str.length());
        list.add(str.substring(0, end));

        makeStringArr(str.substring(end), n, list);
    }

    public static void main(String[] args) {
        CutAndSaveArr task = new CutAndSaveArr();
        String str = "abc1Addfggg4556b";
        System.out.println(Arrays.toString(task.solutionA(str, 6)));
        System.out.println(Arrays.toString(task.solutionB(str, 6)));

        Compare.measureTime(()->task.solutionA(str, 6), ()->task.solutionB(str, 6) );
    }
}
