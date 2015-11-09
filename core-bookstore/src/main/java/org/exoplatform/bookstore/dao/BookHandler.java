package org.exoplatform.bookstore.dao;

import org.exoplatform.bookstore.entity.Book;
import org.exoplatform.commons.api.persistence.GenericDAO;

import java.util.List;

/**
 * Created by dongpd on 11/19/15.
 */
public interface BookHandler extends GenericDAO<Book, String> {

  public List<Book> searchByTitle(String title);
}
