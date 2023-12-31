package spring.Pro_P_F.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cy_seq;

    private String cyId;
    private String cy_pwd;
    private String companyname;
    private String manager_name;
    private String manager_email;
    private String manager_phone;

    @Column(columnDefinition = "TEXT")
    private String intro;
    private String link;
//    private String img;
    private String location;

}
