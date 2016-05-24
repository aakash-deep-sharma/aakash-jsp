package dao;

import java.util.List;

import hib_pojos.Book;

import org.hibernate.*;

import utils.HibernateUtils;

public class BookDaoImpl implements BookDao {

	@Override
	public Integer addBook(Book b1) throws Exception {
		// get session from SF
		Session hibSession = HibernateUtils.getFactory().openSession();
		// begin tx
		Transaction tx = hibSession.beginTransaction();
		Integer id = null;
		try {
			id = (Integer) hibSession.save(b1);
			/*
			 * System.out.println("press enter to continue"); System.in.read();
			 */
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hibSession != null)
				hibSession.close();// pooled out rets to cn pool.
		}
		return id;
	}

	@Override
	public Book getBookById(Integer bookId) throws Exception {
		// sess
		Session sess = HibernateUtils.getFactory().openSession();
		// tx
		Transaction tx = sess.beginTransaction();
		Book ref=null;
		try {
			ref=(Book) sess.get(Book.class, bookId);
			ref=(Book) sess.get(Book.class, bookId);
			ref=(Book) sess.get(Book.class, bookId);
			ref=(Book) sess.get(Book.class, bookId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (sess != null)
				sess.close();
		}
		return ref;//DETACHED  -- de coupled from session
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks() throws Exception {
		String jpql="select b from Book b";
		List<Book> l1=null;
		//sess -- rets new session if no existing sess
		//rets existing sess --if one already exists
		Session sess=HibernateUtils.getFactory().getCurrentSession();
		Transaction tx=sess.beginTransaction();
		try{
			l1=sess.createQuery(jpql).list();//list of PERSISTENT pojos
			tx.commit();//sess is implictely closed
		} catch (HibernateException e)
		{
			if(tx != null)
				tx.rollback();//sess is implictely closed
		} 
		System.out.println("dao reted list "+l1);//list of DETACHED pojos
		return l1;
	}
	

}
