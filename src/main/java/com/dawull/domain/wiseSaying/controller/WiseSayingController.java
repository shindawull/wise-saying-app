package com.dawull.domain.wiseSaying.controller;

import com.dawull.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WiseSayingController {
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingController(Scanner scanner){
        this.scanner = scanner;
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public void makeSampleData() {
        addWiseSaying(wiseSayings,"나의 죽음을 적들에게 알리지 마라.", "이순신장군");
        addWiseSaying(wiseSayings,"삶이 있는 한 희망은 있다.", "키케로");
    }

    public WiseSaying addWiseSaying(List<WiseSaying> wiseSayings, String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(wiseSayings, content, author);

        //System.out.println(Arrays.toString(wiseSayings));
        System.out.println("%d번 명령이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println("------------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
        }
    }

    public void actionDelete(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);
        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        else System.out.println("%d번 명언은 존재하지않습니다.".formatted(id));
    }

    public void actionModify(String cmd) {
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