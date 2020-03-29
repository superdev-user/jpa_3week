package com.superdev.jpa;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class MemberProductId implements Serializable {

    private Long member;
    private Long product;

    @Builder
    public MemberProductId(Long member, Long product) {
        this.member = member;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberProductId that = (MemberProductId) o;
        return Objects.equals(member, that.member) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, product);
    }
}
