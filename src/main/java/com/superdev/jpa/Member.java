package com.superdev.jpa;

import lombok.*;

import java.util.Date;
import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "NAME", nullable = false, length = 10)
  private String username;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  private Integer age;

  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  @Builder
  public Member(String username , Team team , Integer age , RoleType roleType) {
    this.username = username;
    this.team = team;
    this.age = age;
    this.roleType = roleType;
  }
}
