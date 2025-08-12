package com.dawull;

import com.dawull.domain.wiseSaying.controller.WiseSayingController;
import com.dawull.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // 변수 선언
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;
    private WiseSayingController wiseSayingController;

    // 변수 초기화
    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
        wiseSayingController = new WiseSayingController();
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
                wiseSayingController.actionList(wiseSayings);
            } else if (cmd.startsWith("삭제?id=")) {
                wiseSayingController.actionDelete(cmd, wiseSayings);
            } else if (cmd.startsWith("수정?id=")) {
                String id = cmd.substring(6);
                actionModify(Integer.parseInt(id));
            }
        }
        scanner.close();
    }

    private void actionModify(int id) {
        WiseSaying foundWaseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                foundWaseSaying = wiseSaying;
                break;
            }
        }

        if (foundWaseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }
        System.out.println("명언(기존) : %s".formatted(foundWaseSaying.getContent()));
        System.out.print("새로운 명언 : ");
        String content = scanner.nextLine();

        System.out.println("작사(기존) : %s".formatted(foundWaseSaying.getAuthor()));
        System.out.print("새로운 작사 : ");
        String author = scanner.nextLine();

        foundWaseSaying.setContent(content);
        foundWaseSaying.setAuthor(author);
        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
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


}
