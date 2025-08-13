package com.dawull;

import com.dawull.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    // 변수 선언
    private final Scanner scanner;
    private WiseSayingController wiseSayingController;

    // 변수 초기화
    public App() {
        scanner = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(scanner);
    }

    public void run() {
        System.out.println("== 명어 앱 ==");

        wiseSayingController.makeSampleData();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if (cmd.startsWith("삭제?id=")) {
                wiseSayingController.actionDelete(cmd);
            } else if (cmd.startsWith("수정?id=")) {
                wiseSayingController.actionModify(cmd);
            }
        }
        scanner.close();
    }
}
