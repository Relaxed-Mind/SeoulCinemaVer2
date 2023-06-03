package com.dbd.seoulcinema.domain.entity;

import com.dbd.seoulcinema.domain.enumeration.ClientGrade;
import com.dbd.seoulcinema.global.utils.ClientGradeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Member {

    @Id
    @Column(name = "CLIENT_ID", length = 20)
    private String clientId;

    @Column(name = "PASSWORD", length = 64)
    private String password;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "POINT")
    private Long point;

    @Column(name = "CLIENT_GRADE_CODE")
    @Convert(converter = ClientGradeConverter.class)
    private ClientGrade clientGrade;

    @Column(name = "BIRTH")
    private LocalDate localDate;

    public void accumulateAndUsePoint(Integer point, Integer totalPrice) {
        this.point-=point;
        this.point += (long)(totalPrice * 0.1);
    }
}
