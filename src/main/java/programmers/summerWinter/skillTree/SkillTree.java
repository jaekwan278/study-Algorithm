package programmers.summerWinter.skillTree;

// 스킬트리

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String tree : skill_trees){

            StringBuilder sb = new StringBuilder();

            for(char ch : tree.toCharArray()){
                if(skill.indexOf(ch) != -1) sb.append(ch);
            }

            if(skill.startsWith(sb.toString())) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTree task = new SkillTree();

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(task.solution(skill, skill_trees));
    }
}
