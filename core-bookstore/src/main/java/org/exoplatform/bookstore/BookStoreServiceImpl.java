/*
* Copyright (C) 2003-2012 eXo Platform SAS.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the ho
pe that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Affero General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package org.exoplatform.bookstore;

import org.exoplatform.bookstore.dao.DAOHandler;
import org.exoplatform.bookstore.entity.Book;
import org.exoplatform.commons.api.persistence.ExoTransactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by The eXo Platform SAS Author : eXoPlatform exo@exoplatform.com Jun
 * 26, 2012
 */
public class BookStoreServiceImpl implements BookStoreService {

  @Inject
  DAOHandler daoHandler;

  public BookStoreServiceImpl(DAOHandler daoHandler) {
    this.daoHandler = daoHandler;
  }

  @ExoTransactional
  public Book createBook(Book book) {
    return daoHandler.getBookHandler().create(book);
  }

  @ExoTransactional
  public Book getBook(String bookId) {
    return daoHandler.getBookHandler().find(bookId);
  }

  @ExoTransactional
  public void addBook(String bookTitle, long price) {
    daoHandler.getBookHandler().create(new Book(bookTitle, price));
  }

  @ExoTransactional
  public void deleteBook(String id) {
    Book book = daoHandler.getBookHandler().find(id);
    daoHandler.getBookHandler().delete(book);
  }

  @ExoTransactional
  public void editBook(String bookId, String bookTitle, long bookPrice) {
    Book book = daoHandler.getBookHandler().find(bookId);
    book.setTitle(bookTitle);
    book.setPrice(bookPrice);
    daoHandler.getBookHandler().update(book);
  }

  @ExoTransactional
  public List<Book> searchTitle(String key) {
    return daoHandler.getBookHandler().searchByTitle(key);
  }

  public List<Book> getAll() {
    return daoHandler.getBookHandler().findAll();
  }
}