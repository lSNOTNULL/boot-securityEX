package org.example.bootsecurityex.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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
}
