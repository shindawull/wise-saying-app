package com.dawull;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    // 변수 선언
    Scanner scanner;
    int lastId;
    WiseSaying[] wiseSayings;
    int wiseSayingsSize;

    // 변수 초기화
    App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new WiseSaying[100];
        wiseSayingsSize = 0;
    }

    public void run() {
        System.out.println("== 명어 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {

            } else if (cmd.startsWith("수정")) {

            }
        }
        scanner.close();
    }

    void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        int id = ++lastId;

        //저장
        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings[wiseSayingsSize] = wiseSaying;
        wiseSayingsSize++;

        //System.out.println(Arrays.toString(wiseSayings));
        System.out.println("%d번 명령이 등록되었습니다.".formatted(id));

    }

    void actionList() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println("------------------------");
        int i = 0;
        try {
            for (WiseSaying wiseSaying : wiseSayings) {
                if (wiseSaying == null) break;
                System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.content, wiseSaying.author));
            }
        } catch (NullPointerException e) {
            System.out.println("등록된 명언이 없습니다.");
        }
    }
}

class WiseSaying extends Object {
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