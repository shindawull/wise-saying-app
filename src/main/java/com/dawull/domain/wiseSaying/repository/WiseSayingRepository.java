 package com.dawull.domain.wiseSaying.repository;

 import com.dawull.domain.wiseSaying.entity.WiseSaying;

 import java.util.List;
 import java.util.Optional;

 /* abstract class 를 interface 로  같다고 보면 된다.
 * 전부 abstract며 interface면 public abstract 생략 가능 */
 public interface WiseSayingRepository {

    void add(WiseSaying wiseSaying);

    List<WiseSaying> findAll();

    boolean removeById(int id);

    Optional<WiseSaying> findById(int id);

     void modify(WiseSaying wiseSaying);
 }
