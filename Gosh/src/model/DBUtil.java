package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DBUtil {

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("Gosh");

	public static EntityManagerFactory getEmFactory() {
		return emf;
	}

	public static void insert(Gproduct prod) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(prod);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Gproduct> getProductList(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "Select t from Gproduct t where t.pusername ='" + username
				+ "'";
		TypedQuery<Gproduct> bq = em.createQuery(q, Gproduct.class);
		List<Gproduct> list = bq.getResultList();
		return list;
	}

	public static List<Gproduct> getProductList(int pid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "Select t from Gproduct t where t.id=" + pid;
		TypedQuery<Gproduct> bq = em.createQuery(q, Gproduct.class);
		List<Gproduct> list = bq.getResultList();
		return list;
	}

	public static Gproduct getProduct(String prodID) {
		System.out.println(prodID);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Gproduct prod = em.find(Gproduct.class, prodID);
		return prod;
	}

	public static void update(Gproduct prod) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(prod);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static void update(Gcart item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(item);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}
	

	public static void delete(Gproduct prod) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(prod));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(int pid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Gproduct prod = em.find(Gproduct.class, pid+ "");
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(prod));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	
	public static List<Gcart> getPurchased(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "Select t from Gcart t where t.cusername ='" + username
				+ "' and t.bought=1";
		TypedQuery<Gcart> bq = em.createQuery(q, Gcart.class);
		List<Gcart> list = bq.getResultList();
		return list;
	}
	public static List<Gcart> getPurchasedItem(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "Select t from Gcart t where t.cusername ='" + username
				+ "' and t.bought=0";
		TypedQuery<Gcart> bq = em.createQuery(q, Gcart.class);
		List<Gcart> list = bq.getResultList();
		return list;
	}
	public static void update(Guser u) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(u);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static Guser getUser(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "select t from Guser t where t.username='"+username+"'";
		System.out.println(q);
		TypedQuery<Guser> bq = em.createQuery(q, Guser.class);
		Guser u = bq.getSingleResult();
		return u;
	}
}