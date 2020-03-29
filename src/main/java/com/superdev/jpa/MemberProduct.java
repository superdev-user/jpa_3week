package com.superdev.jpa;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@IdClass(MemberProductId.class)
@Entity
public class MemberProduct  {

    @Id
    @ManyToOne
    @JoinColumn(name="ID")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int orderAmount;

    @Builder
    public MemberProduct(Member member , Product product , int orderAmount) {
        this.member = member;
        this.product = product;
        this.orderAmount = orderAmount;
    }
}
