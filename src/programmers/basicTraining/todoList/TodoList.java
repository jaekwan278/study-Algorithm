package programmers.basicTraining.todoList;

// 할 일 목록

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TodoList {

    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length).filter(i -> !finished[i]).mapToObj(i -> todo_list[i]).toArray(String[]::new);
    }

    public String[] solution2(String[] todo_list, boolean[] finished){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < finished.length; i++){
            if(!finished[i]) list.add(todo_list[i]);
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        TodoList task = new TodoList();
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        System.out.println(Arrays.toString(task.solution2(todo_list, finished)));

        Compare.measureTime(()->task.solution(todo_list, finished), ()-> task.solution2(todo_list, finished));
    }
}
