package programmers.monthlyChallenge2.rotateParentheses;

// 괄호 회전하기

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class RotateParentheses {

    public int solution(String s) {
        int answer = 0;

        Map<Character, Character> pair = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );

        String str = s.repeat(2);

        for(int i = 0; i < s.length(); i++){

            answer += isValid(pair, str, i, s.length()+i);

        }

        return answer;
    }

    private int isValid(Map<Character, Character> pair, String str){

        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : str.toCharArray()){

            if(pair.containsKey(ch)){
                stack.addLast(ch);
            }else{

                if(stack.isEmpty()) return 0;

                if(pair.get(stack.pollLast()) != ch) return 0;

            }

        }

        return stack.isEmpty() ? 1 : 0;
    }

    private int isValid(Map<Character, Character> pair, String str, int start, int end){

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = start; i < end; i++){

            char cur = str.charAt(i);

            if(pair.containsKey(cur)){
                stack.addLast(cur);
            }else{

                if(stack.isEmpty()) return 0;

                if(pair.get(stack.pollLast()) != cur) return 0;
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }


    public static void main(String[] args) {
        RotateParentheses task = new RotateParentheses();
        String s = "[](){}";

        System.out.println(task.solution(s));
    }

//    public int solution(String s) {
//        int answer = 0;
//
//        Map<Character, Character> map = new HashMap<>();
//        map.put('(', ')');
//        map.put('[', ']');
//        map.put('{', '}');
//
//        String str = s.repeat(2);
//
//        for(int i = 0; i < s.length(); i++){
//            String target = str.substring(i, s.length() + i);
//
//            answer += checker(map, target);
//        }
//
//        return answer;
//    }
//
//    private int checker(Map<Character, Character> map, String str){
//        Map<Character, Integer> pair = new HashMap<>();
//
//        for(char ch : str.toCharArray()){
//
//            if(map.containsKey(ch)){
//                pair.put(map.get(ch), pair.getOrDefault(map.get(ch), 0) + 1);
//            }else{
//
//                if(!pair.containsKey(ch)) return 0;
//
//                int pVal = pair.get(ch) - 1;
//
//                if(pVal == 0){
//                    pair.remove(ch);
//                }else{
//                    pair.put(ch, pVal);
//                }
//
//            }
//
//        }
//
//        return 1;
//    }
}
