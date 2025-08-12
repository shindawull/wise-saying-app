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

        makeSampleData();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?id=")) {
                String id = cmd.substring(6);
                actionDelete(Integer.parseInt(id));
            } else if (cmd.startsWith("수정?id=")) {

            }
        }
        scanner.close();
    }

    private void actionDelete(int id) {
        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        if (removed) {
            System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        } else {
            System.out.println("%d번 명언은 존재하지않습니다.".formatted(id));
        }

    }

    private void makeSampleData() {
        addWiseSaying("나의 죽음을 적들에게 알리지 마라.", "이순신장군");
        addWiseSaying("삶이 있는 한 희망은 있다.", "키케로");
    }

    private WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

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

        try {
            int i = 0;
            for (WiseSaying wiseSaying : wiseSayings.reversed()) {
                System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
            }
            /*for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                WiseSaying wiseSaying = wiseSayings.get(i);
                System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
            }*/
        } catch (NullPointerException e) {
            System.out.println("등록된 명언이 없습니다.");
        }
    }
}
