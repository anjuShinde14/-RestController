package com.nimap.Task.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nimap.Task.entity.Categories;
import com.nimap.Task.entity.Products;

@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;

	public String addcategories(Categories c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(c);
			tx.commit();
			msg = "Data Addedd Succefully..";

		} catch (Exception e) {
			// TODO: handle exeption
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}

	public List<Categories> getAllcategories(int page) {
		Session session = null;
		Transaction tx = null;
		String strQuery = "from Categories";
		List<Categories> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			int startingindex=page*0;
			list = session.createQuery(strQuery, Categories.class).setFirstResult(startingindex).setMaxResults(page).list();

			
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Categories categoriesByID(int id) {
		Session session = null;
		Transaction tx = null;
		Categories ct = null;
		String strquery = "from Categories where id=:myid";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Categories> query = session.createQuery(strquery, Categories.class);
			query.setParameter("myid", id);
			ct = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return ct;
	}

	public String updateCategories(Categories c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Categories categories = session.get(Categories.class, c.getCid());

			categories.setCname(c.getCname());

			session.merge(categories);
			tx.commit();
			msg = "Record is updatated";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteCategories(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Categories categories = session.get(Categories.class, id);

			session.remove(categories);
			tx.commit();

			msg = "Record is Deleted";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String addProducts(Products p) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(p);
			tx.commit();
			msg = "Data Addedd Succefully..";

		} catch (Exception e1) {
			// TODO: handle exeption
			if (tx != null) {
				tx.rollback();
			}
			e1.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Products> getAllProducts(int page) {
		Session session = null;
		Transaction tx = null;
		String strQuery = "from Products";
		List<Products> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
            
			int  startingindex=page*0;
			list = session.createQuery(strQuery, Products.class).setFirstResult(startingindex).setMaxResults(page).list();

			tx.commit();

		} catch (Exception e1) {
			if (tx != null){
				tx.rollback();
			}

			e1.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	
	@SuppressWarnings({ "deprecation", "unused" })
	public String updateProducts(Products p) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();

			Products products = session.get(Products.class, p.getId());
			products.setName(p.getName());
			products.setPhoneno(p.getPhoneno());
//			products.setCategories(p.getCategories());
			products.setCreatedby(p.getCreatedby());
			products.setCreateddtm(p.getCreateddtm());
			products.setUpdatedby(p.getUpdatedby());
			products.setUpdateddtm(p.getUpdateddtm());
			session.update(products);
			session.beginTransaction().commit();
			msg = "Record is updatated...";

		} catch (Exception e1) {
			if (tx != null) {
				//tx.rollback();
			}
			e1.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public Products ProductsByID(int id) {
		Session session = null;
		Transaction tx = null;
		Products product = null;
		String strquery = "from Products where id=:myid";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Products> query = session.createQuery(strquery, Products.class);
			query.setParameter("myid", id);
			product = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}

	public String deleteProducts(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Products products = session.get(Products.class, id);

			session.remove(products);
			tx.commit();

			msg = "Record is Deleted...........";
		} catch (Exception e1) {
			if (tx != null) {
				tx.rollback();
			}

			e1.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

}
