package com.example.tp.domain.repository;


import com.example.tp.domain.entity.BoardEntity;
import com.example.tp.domain.entity.Comment2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment2Entity, Long> {
    // select * from comment_table where board_id=? order by id desc;
    List<Comment2Entity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}
