 package com.dawull.domain.wiseSaying.repository;

 import com.dawull.domain.wiseSaying.entity.WiseSaying;

 import java.util.List;
 import java.util.Optional;

 public abstract class WiseSayingRepository {

    public abstract void add(WiseSaying wiseSaying);

    public abstract List<WiseSaying> findAll();

    public abstract boolean removeById(int id);

    public abstract Optional<WiseSaying> findById(int id);

     public abstract void modify(WiseSaying wiseSaying);
 }
