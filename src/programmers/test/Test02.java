package programmers.test;

public class Test02 {
    public static void main(String[] args) {
        double target = 10;
        double compare = 188;
        String sign = "";

        if(target == 0 && compare == 0){
            System.out.println("+0%");
        }else{
            if(target >= compare){
                sign = "+";
            }

            System.out.println(sign + String.format("%.1f", (((target - compare) / compare) * 100)) + "%");
        }
    }
}
