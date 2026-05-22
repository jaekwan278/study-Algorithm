package programmers.skillCheck.level2.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_3_1 {
    private static class File{
        private String head;
        private String number;
        private String tail;

        File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    private void sortFile(List<File> list){

        list.sort((a, b) -> {
            int headCompare = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if(headCompare != 0){
                return headCompare;
            }

            int aNum = Integer.parseInt(a.number);
            int bNum = Integer.parseInt(b.number);
            if(aNum != bNum){
                return Integer.compare(aNum, bNum);
            }

            return 0;
        });
    }

    private List<File> makeFileList(String[] files){
        List<File> list = new ArrayList<>();

        for(String file : files){

            String head;
            String number;
            String tail;

            int idx = 0;
            StringBuilder sb = new StringBuilder();

            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                sb.append(file.charAt(idx++));
            }
            head = sb.toString();
            sb.setLength(0);

            while(idx < file.length() && Character.isDigit(file.charAt(idx))){
                sb.append(file.charAt(idx++));
            }
            number = sb.toString();

            tail = file.substring(idx);

            list.add(new File(head, number, tail));
        }

        return list;
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<File> list = makeFileList(files);

        sortFile(list);

        for(int i = 0; i < answer.length; i++){
            File file = list.get(i);
            answer[i] = file.head + file.number + file.tail;
        }

        return answer;
    }

    public static void main(String[] args) {
        Level2_3_1 task = new Level2_3_1();

        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(task.solution(files)));
    }

}
