package com.dawull.domain.wiseSaying.controller;

import com.dawull.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Scanner;


public class WiseSayingController {
    Scanner scanner;

    public WiseSayingController(){
        scanner = new Scanner(System.in);
    }

    public void actionList(List<WiseSaying> wiseSayings) {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println("------------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
        }
    }

    public void actionDelete(String cmd, List<WiseSaying> wiseSayings) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);
        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        else System.out.println("%d번 명언은 존재하지않습니다.".formatted(id));
    }

    public void actionModify(String cmd, List<WiseSaying> wiseSayings) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);
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
}