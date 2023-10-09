package com.example.tp.domain.entity;


import com.example.tp.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class Comment2Entity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String commentWriter;

    @Column
    private String commentContents;

    /* Board:Comment = 1:N */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;


    public static Comment2Entity toSaveEntity(CommentDTO commentDTO, BoardEntity boardEntity) {
        Comment2Entity comment2Entity = new Comment2Entity();
        comment2Entity.setCommentWriter(commentDTO.getCommentWriter());
        comment2Entity.setCommentContents(commentDTO.getCommentContents());
        comment2Entity.setBoardEntity(boardEntity);
        return comment2Entity;
    }
}
