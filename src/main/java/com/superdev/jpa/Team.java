package com.superdev.jpa;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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

  @Builder
  public Team(String name) {
    this.name = name;
  }
}
