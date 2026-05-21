package programmers.hash.phoneNumberList;

// 전화번호 목록

import utils.Compare;

import java.util.Arrays;

class Trie {

    TrieNode root = new TrieNode();

    private static class TrieNode {
        TrieNode[] children = new TrieNode[10];
        boolean isEnd = false;
    }

    private boolean insert(String nStr){
        TrieNode node = root;

        for(char ch : nStr.toCharArray()){
            int index = ch - '0';

            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }

            node = node.children[index];

            if(node.isEnd) return false;
        }

        for(TrieNode child : node.children) {
            if(child != null) return false;
        }

        node.isEnd = true;
        return true;
    }

    public boolean checkPhoneNumbers(String[] phone_book){
        for(String phone : phone_book){
            if(!insert(phone)) return false;
        }
        return true;
    }
}

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {

        Trie trie = new Trie();

        return trie.checkPhoneNumbers(phone_book);
    }

    public boolean solution2(String[] phone_book){
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PhoneNumberList task = new PhoneNumberList();
        String[] phone_book = {"123","456","789"};

        System.out.println(task.solution(phone_book));

        Compare.measureTime(()->task.solution(phone_book), ()->task.solution2(phone_book));
    }

}
