package com.dawull.domain.wiseSaying.controller;

import com.dawull.domain.wiseSaying.entity.WiseSaying;

import java.util.List;


public class WiseSayingController {
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
}