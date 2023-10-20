package spring.Pro_P_F.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Posting {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series")
    private Series series;

    private String p_title;
    private String p_content;
    private int p_like;
    private String p_img;
    private int p_view;

    @LastModifiedDate
    private LocalDate p_date;
    // 스크랩 컬럼, 테이블 추가 필요

    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PComment> comments = new ArrayList<>();

}
