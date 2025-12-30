package programmers.searchAlgorithm.bfs.convertWord;

// 단어 변환

/*

    boolean[] used - 사용여부 판단

 */

import java.util.*;

public class ConvertWord {

    private static class Node{
        String word;
        int level;

        private Node(String word, int level){
            this.word = word;
            this.level = level;
        }
    }

    public int solution(String begin, String target, String[] words) {

        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);

        return set.contains(target) ? bfs(words, set, target, begin) : 0;
    }

    private int bfs(String[] words, Set<String> set, String target, String begin){

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(begin, 0));

        while(!que.isEmpty()){
            Node node = que.poll();
            int level = node.level;
            String word = node.word;

            if(word.equals(target)) return level;

            for (String str : words) {
                if (!set.contains(str)) continue;

                int cnt = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != word.charAt(j)) {
                        cnt++;
                        if (cnt > 1) break;
                    }
                }

                if (cnt == 1) {
                    set.remove(str);
                    que.add(new Node(str, level + 1));
                }
            }

        }

        return 0;
    }


    public static void main(String[] args) {
        ConvertWord task = new ConvertWord();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(task.solution(begin, target, words));
    }
}
