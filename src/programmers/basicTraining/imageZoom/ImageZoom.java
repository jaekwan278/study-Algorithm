package programmers.basicTraining.imageZoom;

// 그림 확대

import utils.Compare;

import java.util.Arrays;

public class ImageZoom {

    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];

        for(int i = 0; i < answer.length; i += k){
            String[] line = new String[k];
            for(int j = 0; j < k; j++){
                String str = picture[i / k];
                StringBuilder sb = new StringBuilder();
                for(char ch : str.toCharArray()){
                    sb.append(String.valueOf(ch).repeat(k));
                }
                line[j] = sb.toString();
            }
            System.arraycopy(line, 0, answer, i, k);
        }

        return answer;
    }

    public String[] solution2(String[] picture, int k){
        int arrLen = picture.length;
        int strLen = picture[0].length();
        String[] answer = new String[arrLen * k];

        for(int i = 0; i < arrLen; i++){
            StringBuilder sb = new StringBuilder(strLen * k);
            for(char ch : picture[i].toCharArray()){
                sb.append(String.valueOf(ch).repeat(k));
            }
            String line = sb.toString();
            for(int j = 0; j < k; j++){
                answer[i * k + j] = line;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ImageZoom task = new ImageZoom();
        String[] picture = {"x.x", ".x.", "x.x"};
        int k = 3;

        System.out.println(Arrays.toString(task.solution2(picture, k)));

        Compare.measureTime(()->task.solution(picture, k), ()->task.solution2(picture, k));
    }

}
