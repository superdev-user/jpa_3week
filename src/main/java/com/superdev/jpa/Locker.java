package com.superdev.jpa;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "ID" )
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

    @Builder
    public Locker(String name) {
        this.name = name;
    }
}
