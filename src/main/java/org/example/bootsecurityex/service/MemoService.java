package org.example.bootsecurityex.service;

import org.example.bootsecurityex.model.domain.Memo;

import java.util.List;

public interface MemoService {
    List<Memo> findAll();

    void create(Memo memo) throws Exception;
}
