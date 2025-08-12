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
}