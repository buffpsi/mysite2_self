package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "Text")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne//답변은 많고 질문은 하나
    private Question question;
}
