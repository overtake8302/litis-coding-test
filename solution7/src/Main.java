import java.util.Random;
import java.util.Scanner;

public class Main {
    int score = 0;
    boolean[] base = new boolean[4];
    int playNum = 0;
    int winCount = 0;
    int drawCount = 0;
    double winRate = 0;
    int out = 0;
    int strike = 0;

    public static void main(String[] args) {

        Main main = new Main();
        main.game();
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (out < 3) {
            playNum++;

            if (strike >= 2) {
                out++;
                strike = 0;
                System.out.println("투스트라이크 아웃!");
                continue;
            }

            System.out.println("점수 : " + score + " |  스트라이크 : " + strike + " |  아웃 : " + out);

            System.out.println("----------주자-----------");

            if (base[1]) {
                System.out.println("           O     ");
            } else {
                System.out.println("           X     ");
            }

            if (base[2]) {
                System.out.print("        O");
            } else {
                System.out.print("        X");
            }

            if (base[0]) {
                System.out.println("     O");
            } else {
                System.out.println("     X");
            }

            System.out.println("-----------------------");

            int cpu = random.nextInt(3) + 1;
            System.out.println("| 1. 묵 | 2. 찌 | 3. 빠 |");
            System.out.println("원하는 묵찌빠에 해당하는 숫자를 입력해 주세요.");
            int player = scanner.nextInt();

            if (player < 0 || player > 3) {
                System.out.println("1 ~ 3 의 정수만 입력해 주세요.");
                continue;
            }

            if (cpu == 1) {
                if (player == 1) {
                    System.out.println("컴퓨터는 묵, 당신은 묵");
                    drawCount++;
                    System.out.println("비겼습니다. 다시 진행합니다.");
                    continue;
                } else if (player == 2) {
                    System.out.println("컴퓨터는 묵, 당신은 찌");
                    strike++;
                    System.out.println("졌습니다.");
                    continue;
                } else if (player == 3) {
                    System.out.println("컴퓨터는 묵, 당신은 빠");
                    winCount++;
                    System.out.println("이겼습니다!");
                    win();
                    continue;
                }
            } else if (cpu == 2) {
                if (player == 1) {
                    System.out.println("컴퓨터는 찌, 당신은 묵");
                    winCount++;
                    System.out.println("이겼습니다!");
                    win();
                    continue;
                } else if (player == 2) {
                    System.out.println("컴퓨터는 찌, 당신은 찌");
                    drawCount++;
                    System.out.println("비겼습니다. 다시 진행합니다.");
                    continue;
                } else if (player == 3) {
                    System.out.println("컴퓨터는 찌, 당신은 빠");
                    strike++;
                    System.out.println("졌습니다.");
                    continue;
                }
            } else if (cpu == 3) {
                if (player == 1) {
                    System.out.println("컴퓨터는 빠, 당신은 묵");
                    strike++;
                    System.out.println("졌습니다.");
                    continue;
                } else if (player == 2) {
                    System.out.println("컴퓨터는 빠, 당신은 찌");
                    winCount++;
                    System.out.println("이겼습니다!");
                    win();
                    continue;
                } else if (player == 3) {
                    System.out.println("컴퓨터는 빠, 당신은 빠");
                    drawCount++;
                    System.out.println("비겼습니다. 다시 진행합니다.");
                    continue;
                }
            }
        }

        System.out.println("3아웃으로 게임이 종료됩니다.");
        winRate = ((double) winCount / playNum) * 100;
        System.out.println("승리횟수 : " + winCount);
        System.out.println(" | 점수 : " + score + "점 | 진행한 횟수 : " + playNum + "번 | 비긴 횟수 : " + drawCount + "번 | 승률 : " + (int)winRate + "% |");
    }

    public void win() {
        base[3] = base[2];
        base[2] = base[1];
        base[1] = base[0];
        base[0] = true;

        if (base[3]) {
            score++;
            base[3] = false;
            System.out.println("승점 추가");
        }
    }
}
