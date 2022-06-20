import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class kazuate {

    public static int inputNumber() {
        int number;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.err.println("条件に合う数をもう一度入力してください。");
            number = inputNumber();
        } catch (IOException e) {
            System.err.println("条件に合う数をもう一度入力してください。");
            number = inputNumber();
        }
        return number;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int com = random.nextInt(90) + 10;
        int user = 0;
        int error = 0;
        int count = 1;

        while (count < 6) {
            while (user < 10 || 99 < user) {
                if (error == 1) {
                    System.err.println("条件に合う数をもう一度入力してください。");
                }
                System.out.printf("%d回目\n", count);
                System.out.print("2桁の自然数から予想した数を入力してください：");
                user = inputNumber();
                error = 1;
            }

            if (com == user) {
                System.out.println("当たりです！");
                count = 6;
            } else if (com < user) {
                System.out.println("設定された数より大きいです。");
                if (user - com >= 20) {
                    System.out.println("また、設定された数と20以上差があります。");
                }
            } else if (com > user) {
                System.out.println("設定された数より小さいです。");
                if (com - user >= 20) {
                    System.out.println("また、設定された数と20以上差があります。");
                }
            }
            count++;
            user = 0;
            error = 0;
        }
        System.out.println("これでゲーム終了です。");
    }
}