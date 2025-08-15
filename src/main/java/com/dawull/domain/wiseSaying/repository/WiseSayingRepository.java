 package com.dawull.domain.wiseSaying.repository;

import com.dawull.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 public class WiseSayingRepository {
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
    }

    public void add(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);
        wiseSayings.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
                .filter(wiseSaying ->  wiseSaying.getId() == id)
                .findFirst();
    }

     public void modify(WiseSaying wiseSaying) {
        // 현재는 메모리에 저장되기 때문에 여기서 딱히 할일이 없다.
     }
 }
