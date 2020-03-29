package com.superdev.jpa;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.concurrent.locks.Lock;

public class JpaApplication {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

		try {
			tx.begin(); //트랜잭션 시작

			Product product = new Product();
			product.setName("삼성");

			Member member = new Member();
			member.setUsername("구매자");
			member.setAge(28);
			member.setRoleType(RoleType.USER);

			em.persist(product);
			em.persist(member);

			OrderMemberProduct order = new OrderMemberProduct();
			order.setMember(member);
			order.setProduct(product);
			order.setOrderAmount(10);

			em.persist(order);

			OrderMemberProduct findMemberProduct = em.find(OrderMemberProduct.class , order.getId());

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