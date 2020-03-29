package com.superdev.jpa;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team {

  @Id
  @Column(name = "TEAM_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "NAME")
  private String name;

  @OneToMany
  @JoinColumn(name= "TEAM_ID")
  List<Member> members = new ArrayList<Member>();

  @Builder
  public Team(String name) {
    this.name = name;
  }

}
