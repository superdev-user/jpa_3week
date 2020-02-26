package com.superdev.jpa;

import javax.persistence.*;

public class JpaApplication {

	public static void main(String[] args) {

		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

		try {


			tx.begin(); //트랜잭션 시작

			Team team1 = new Team("팀1");
			em.persist(team1);

			Member member1 = new Member("회원1");
			member1.setTeam(team1);
			em.persist(member1);

			Member member2 = new Member("회원2");
			member2.setTeam(team1);
			em.persist(member2);

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