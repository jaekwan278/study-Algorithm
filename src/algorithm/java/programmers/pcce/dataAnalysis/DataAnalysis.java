package programmers.pcce.dataAnalysis;

// 데이터 분석

import java.util.*;

public class DataAnalysis {

    /// global state
    private static final Map<String, Integer> conditionMap = Map.of(
            "code", 0,
            "date", 1,
            "maximum", 2,
            "remain", 3
    );

    ///  try 1
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> validData = new ArrayList<>(data.length);

        final int conditionIdx = conditionMap.get(ext);

        for(int i = 0; i < data.length; i++){

            int[] cur = data[i];

            if(cur[conditionIdx] < val_ext){
                validData.add(cur);
            }
        }

        final int sortIdx = conditionMap.get(sort_by);
        validData.sort(Comparator.comparingInt(a -> a[sortIdx]));

        return validData.toArray(new int[validData.size()][]);
    }

    public static void main(String[] args) {
        DataAnalysis task = new DataAnalysis();

        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        int[][] answer = task.solution(data, ext, val_ext, sort_by);

        for(int[] arr : answer){
            System.out.println(Arrays.toString(arr));
        }
    }

}
