package org.exoplatform.bookstore.dao.jpa;


import org.exoplatform.bookstore.dao.BookHandler;
import org.exoplatform.bookstore.entity.Book;
import org.exoplatform.commons.persistence.impl.GenericDAOJPAImpl;

import java.util.List;

/**
 * Created by dongpd on 11/19/15.
 */
public class BookStoreDAOImpl extends GenericDAOJPAImpl<Book, String> implements BookHandler {

  @Override
  public Book update(Book entity) {
    return cloneEntity(super.update(entity));
  }

  @Override
  public void delete(Book entity) {
    Book b = getEntityManager().find(Book.class, entity.getId());
    if (b != null) {
      super.delete(b);
    }
  }

  @Override
  public List<Book> searchByTitle(String title) {
    return getEntityManager().createNamedQuery("book.findByTitle").setParameter("title", "%" + title + "%")
            .getResultList();
  }

  protected <E> E cloneEntity(E e) {
    return DAOHandlerJPAImpl.clone(e);
  }
}
