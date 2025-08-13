package com.dawull;

import com.dawull.domain.wiseSaying.controller.WiseSayingController;
import com.dawull.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // 변수 선언
    private final Scanner scanner;

    private final List<WiseSaying> wiseSayings;
    private WiseSayingController wiseSayingController;

    // 변수 초기화
    public App() {
        scanner = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        wiseSayingController = new WiseSayingController();
    }

    public void run() {
        System.out.println("== 명어 앱 ==");

        wiseSayingController.makeSampleData(wiseSayings);

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd(scanner, wiseSayings);
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList(wiseSayings);
            } else if (cmd.startsWith("삭제?id=")) {
                wiseSayingController.actionDelete(cmd, wiseSayings);
            } else if (cmd.startsWith("수정?id=")) {
                wiseSayingController.actionModify(scanner, cmd, wiseSayings);
            }
        }
        scanner.close();
    }
}
