package programmers.greedy.joyStick;

// 조이스틱

public class JoyStick {

    public int solution(String name) {
        int answer = 0;

        for(int i = 0; i < name.length(); i++){
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;

            answer += Math.min(up, down);
        }

        int move = name.length() - 1;
        for(int i = 0; i < name.length(); i++){
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') next++;

            move = Math.min(move, i * 2 + (name.length() - next));
            move = Math.min(move, (name.length() - next) * 2 + i);
        }

        System.out.println(answer + " : " + move);

        return answer += move;
    }

    // J E D A A A K D F J K L

    public static void main(String[] args) {
        JoyStick task = new JoyStick();
        String name = "JEDAAAKL";

        System.out.println(task.solution(name));
    }

}
