package com.dawull;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    public void run() {

        System.out.println("== 명어 앱 ==");

        //생성
        Scanner scanner = new Scanner(System.in);

        int lastId = 0;
        WiseSaying lastWiseSaying = null;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                int id = ++lastId;

                //저장
                WiseSaying wiseSaying = new WiseSaying(id, content, author);

                lastWiseSaying = wiseSaying;

                System.out.println("%d번 명령이 등록되었습니다.".formatted(id));

            } else if (cmd.equals("목록")) {
                System.out.println(" 번호 / 작가 / 명언 ");
                System.out.println("----------------------");
                try {
                    System.out.println("%d / %s / %s".formatted(lastWiseSaying.id, lastWiseSaying.content, lastWiseSaying.author));
                } catch (NullPointerException e) {
                    System.out.println("등록된 명언이 없습니다.");
                }


            }
        }
        scanner.close();
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }

}