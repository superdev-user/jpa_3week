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

			Product product1 = Product.builder()
					.name("맥북")
					.build();

			Member admin = Member.builder()
					.username("주인")
					.age(28)
					.roleType(RoleType.ADMIN)
					.build();

			Member admin1 = Member.builder()
					.username("구매자")
					.age(32)
					.roleType(RoleType.USER)
					.build();

			admin.getProducts().add(product);
			admin.getProducts().add(product1);

			admin1.getProducts().add(product);
			admin1.getProducts().add(product1);

			em.persist(product);
			em.persist(product1);
			em.persist(admin);
			em.persist(admin1);

			em.flush();
			em.clear();

			System.out.println("==========");
			em.find(Member.class , admin.getId())
					.getProducts().stream().forEach(System.out::println);

			em.find(Member.class , admin1.getId())
					.getProducts().stream().forEach(System.out::println);

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