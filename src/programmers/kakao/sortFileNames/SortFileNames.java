package programmers.kakao.sortFileNames;

// 파일명 정렬

import java.util.Arrays;

public class SortFileNames {

    private static class File{
        String head;
        int num;
        String origin;

        File(String origin){
            this.origin = origin;

            StringBuilder sb = new StringBuilder();

            int idx = 0;
            while(idx < origin.length() && !Character.isDigit(origin.charAt(idx))){
                sb.append(origin.charAt(idx++));
            }

            this.head = sb.toString().toUpperCase();
            sb.setLength(0);

            while(idx < origin.length() && Character.isDigit(origin.charAt(idx))){
                sb.append(origin.charAt(idx++));
            }

            this.num = Integer.parseInt(sb.toString());
        }
    }

    private int compareName(File fileA, File fileB){

        int headCompare = fileA.head.compareTo(fileB.head);
        if(headCompare != 0) return headCompare;

        return fileA.num - fileB.num;
    }

    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        for(int i = 0; i < files.length; i++){
            fileArr[i] = new File(files[i]);
        }

        Arrays.sort(fileArr, this::compareName);

        String[] answer = new String[files.length];
        for(int i = 0; i < fileArr.length; i++){
            answer[i] = fileArr[i].origin;
        }

        return answer;
    }

    public static void main(String[] args) {
        SortFileNames task = new SortFileNames();

        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(task.solution(files)));
    }

}
