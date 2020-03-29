package com.superdev.jpa;

import javax.persistence.*;

public class JpaApplication {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

		try {
			tx.begin(); //트랜잭션 시작

			Team team1 = Team.builder()
					.name("Team1")
					.build();

			Member admin = Member.builder()
					.username("주인")
					.age(28)
					.team(team1)
					.roleType(RoleType.ADMIN)
					.build();

			Member member = Member.builder()
					.username("멤버")
					.age(30)
					.team(team1)
					.roleType(RoleType.USER)
					.build();

			team1.getMembers().add(admin);
			team1.getMembers().add(member);

			em.persist(admin);			//INSERT
			em.persist(member);			//INSERT
			em.persist(team1);			//INSERT , UPDATE admin , UPDATE member

			System.out.println("==========");
			System.out.println(em.find(Member.class , admin.getId()));
			System.out.println(em.find(Member.class , member.getId()));
			System.out.println(em.find(Team.class , team1.getId()).getMembers());
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