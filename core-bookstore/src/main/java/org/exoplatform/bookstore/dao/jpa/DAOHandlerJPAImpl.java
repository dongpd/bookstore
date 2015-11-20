package org.exoplatform.bookstore.dao.jpa;

import org.exoplatform.bookstore.dao.BookHandler;
import org.exoplatform.bookstore.dao.DAOHandler;
import org.exoplatform.bookstore.entity.Book;

import javax.inject.Singleton;

@Singleton
public class DAOHandlerJPAImpl implements DAOHandler {

  private BookHandler bookHandler;

  public DAOHandlerJPAImpl() {
    bookHandler = new BookStoreDAOImpl();
  }

  public BookHandler getBookHandler() {
    return bookHandler;
  }

  static <E> E clone(E e) {
    if (e == null) return null;
    if (e instanceof Book) {
      return (E) ((Book) e).clone();
    }

    return e;
  }
}
