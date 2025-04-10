package org.example.bootsecurityex.model.mapper;

import org.apache.ibatis.annotations.*;
import org.example.bootsecurityex.model.domain.Memo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

@Mapper
public interface MemoMapper {
    @Select("SELECT * FROM memo")
    List<Memo> findAll();

    @Insert("INSERT INTO memo (text) values (#{text})")
//    @Options(useGeneratedKeys = true,keyProperty = "id") supabase의 autoIncrement와 충돌
    void insert(Memo memo);

// 소프트 딜리트 <-> 하드 딜리트 TIL
    @Delete("DELETE FROM memo")
    void deleteAll();

    @Delete("DELETE FROM memo WHERE id = (#{id})")
    void deleteById(Long id);

    @Select("SELECT * FROM memo WHERE id = (#{id})")
    Memo findById(Long id);

    @Update("UPDATE memo SET text = (#{text}) WHERE id=(#{id})")
    void update(Memo memo);
}
