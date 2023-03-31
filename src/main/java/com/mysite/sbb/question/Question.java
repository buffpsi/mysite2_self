package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;
    @Column(columnDefinition = "TEXT")//글자수를 제한 하지 않을 때 사용함
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    // Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달해야 한다.
    //CascadeType.REMOVE = 질문 하나에는 여러개의 답변이 작성될 수 있다. 이때 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해서 @OneToMany의 속성으로 cascade = CascadeType.REMOVE를 사용했다.

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;
}
