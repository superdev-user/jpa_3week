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

			Locker locker = Locker.builder()
					.name("Team1")
					.build();

			Member admin = Member.builder()
					.username("주인")
					.age(28)
					.locker(locker)
					.roleType(RoleType.ADMIN)
					.build();

			em.persist(admin);			//INSERT
			em.persist(locker);			//INSERT , UPDATE admin , UPDATE member

			System.out.println("==========");
			System.out.println(em.find(Member.class , admin.getId()));
			System.out.println(em.find(Locker.class , locker.getId()));
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