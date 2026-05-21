package programmers.kakao.openChat;

// 오픈채팅방

import java.util.*;

public class OpenChat {

    public String[] solution(String[] record) {
        List<String[]> recordTrace = new ArrayList<>();
        Map<String, String> nameTrace = new HashMap<>();

        Map<String, String> statusStr = new HashMap<>();
        statusStr.put("Enter", "님이 들어왔습니다.");
        statusStr.put("Leave", "님이 나갔습니다.");

        for(String str : record){
            String[] cur = str.split(" ");

            String status = cur[0];
            String uid = cur[1];

            if(status.equals("Enter") || status.equals("Change")){
                nameTrace.put(uid, cur[2]);
            }

            if(statusStr.containsKey(status)){
                String[] arr = new String[2];
                arr[0] = uid;
                arr[1] = statusStr.get(status);

                recordTrace.add(arr);
            }
        }

        String[] answer = new String[recordTrace.size()];

        for(int i = 0; i < recordTrace.size(); i++){
            String nickName = nameTrace.get(recordTrace.get(i)[0]);
            String str = recordTrace.get(i)[1];

            answer[i] = nickName + str;
        }

        return answer;
    }

    private static class Log{
        String uid;
        String status;

        Log(String uid, String status){
            this.uid = uid;
            this.status = status;
        }
    }

    public String[] solution2(String[] record) {
        List<Log> logTrace = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();

        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);

            String status = st.nextToken();
            String uid = st.nextToken();

            if(status.equals("Change")){
                nameMap.put(uid, st.nextToken());
            }else if(status.equals("Enter")){
                nameMap.put(uid, st.nextToken());
                logTrace.add(new Log(uid, "님이 들어왔습니다."));
            }else{
                logTrace.add(new Log(uid, "님이 나갔습니다."));
            }
        }

        String[] answer = new String[logTrace.size()];
        for(int i = 0; i < answer.length; i++){
            Log log = logTrace.get(i);
            answer[i] = nameMap.get(log.uid) + log.status;
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChat task = new OpenChat();

        String[] record ={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(task.solution(record)));
    }

}
