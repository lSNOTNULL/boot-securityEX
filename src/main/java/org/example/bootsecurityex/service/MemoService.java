package org.example.bootsecurityex.service;

import org.example.bootsecurityex.model.domain.Memo;

import java.util.List;

public interface MemoService {
    List<Memo> findAll();

    void create(Memo memo) throws Exception;

    void deleteAll();

    void deleteById(Long id);

    Memo findById(Long id);

    void update(Memo newMemo);
}
