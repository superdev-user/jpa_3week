package com.superdev.jpa;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
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

  @ManyToMany
  @JoinTable(name = "MEMBER_PRODUCT",
          joinColumns = @JoinColumn(name="ID"),
          inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
  private List<Product> products = new ArrayList<Product>();

   @Builder
  public Member(String username , Integer age , RoleType roleType) {
    this.username = username;
    this.age = age;
    this.roleType = roleType;
  }
}
