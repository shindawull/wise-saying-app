package com.dawull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // 변수 선언
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;
    private int wiseSayingsSize;

    // 변수 초기화
    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명어 앱 ==");

        addWiseSaying("나의 죽음을 적들에게 알리지 마라.", "이순신장군");
        addWiseSaying("삶이 있는 한 희망은 있다.", "키케로");
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

    private WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        System.out.println("wiseSayings = " + wiseSayings);

        return wiseSaying;
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(content, author);

        //System.out.println(Arrays.toString(wiseSayings));
        System.out.println("%d번 명령이 등록되었습니다.".formatted(wiseSaying.getId()));

    }

    private void actionList() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println("------------------------");
        int i = 0;
        try {
            for (WiseSaying wiseSaying : wiseSayings) {
                System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
            }
        } catch (NullPointerException e) {
            System.out.println("등록된 명언이 없습니다.");
        }
    }
}
