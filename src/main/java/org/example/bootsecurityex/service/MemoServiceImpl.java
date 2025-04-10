package org.example.bootsecurityex.service;

import org.example.bootsecurityex.model.domain.Memo;
import org.example.bootsecurityex.model.mapper.MemoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {
    private final MemoMapper memoMapper;

    public MemoServiceImpl(MemoMapper memoMapper) {
        this.memoMapper = memoMapper;
    }
    @Override
    public List<Memo> findAll() {
        return memoMapper.findAll();
    }

    @Override
    public void create(Memo memo) throws Exception {
        memoMapper.insert(memo);
    }

}
