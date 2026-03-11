package programmers.pcce.foldingBanknote;

// 지폐 접기

public class FoldingBanknote {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int w = Math.max(wallet[0], wallet[1]);
        int h = Math.min(wallet[0], wallet[1]);

        int bW = Math.max(bill[0], bill[1]);
        int bH = Math.min(bill[0], bill[1]);

        while(bW > w || bH > h){

            answer++;

            bW /= 2;

            if(bW < bH){
                int tmp = bW;
                bW = bH;
                bH = tmp;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        FoldingBanknote task = new FoldingBanknote();
        int[] wallet = {30, 15};
        int[] bill = {26, 17};

        System.out.println(task.solution(wallet, bill));
    }

}
