package spring.Pro_P_F.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id
    private String mid;

    private String m_pwd;

    private String m_name;

    @Column(unique = true)
    private String mphone;

    private String m_email;

    @Column(name = "m_intro", columnDefinition = "TEXT")
    private String intro;

    private String mgit;
}
