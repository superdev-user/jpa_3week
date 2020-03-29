package com.superdev.jpa;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "LOCKER_ID"))
public class Member {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "NAME", nullable = false, length = 10)
  private String username;

   private Integer age;

  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  @OneToOne
  @JoinColumn(name = "LOCKER_ID")
  private Locker locker;

   @Builder
  public Member(String username , Integer age , RoleType roleType , Locker locker) {
    this.username = username;
    this.age = age;
    this.roleType = roleType;
    this.locker = locker;
  }
}
