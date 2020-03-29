package com.superdev.jpa;

import javax.persistence.*;
import java.util.concurrent.locks.Lock;

public class JpaApplication {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

		try {
			tx.begin(); //트랜잭션 시작

			Product product = Product.builder()
					.name("삼성")
					.build();

			Member member = Member.builder()
					.username("구매자")
					.age(28)
					.roleType(RoleType.USER)
					.build();

			em.persist(product);
			em.persist(member);

			MemberProduct memberProduct = MemberProduct.builder()
					.member(member)
					.product(product)
					.orderAmount(3)
					.build();

			em.persist(memberProduct);

			MemberProductId memberProductId = MemberProductId.builder()
					.member(member.getId())
					.product(product.getId()).build();


			MemberProduct findMemberProduct = em.find(MemberProduct.class , memberProductId);

			System.out.println("==========");
			System.out.println(findMemberProduct.getMember());
			System.out.println(findMemberProduct.getProduct());
			System.out.println(findMemberProduct.getOrderAmount());
			System.out.println("==========");


			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
		} finally {
			em.close(); //엔티티 매니저 종료
		}

		emf.close(); //엔티티 매니저 팩토리 종료
	}

}