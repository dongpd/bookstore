package org.exoplatform.bookstore.entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@ExoEntity
@Entity
@Table(name="BOOK")
@NamedQueries({
        @NamedQuery(name = "book.findByTitle", query = "SELECT b FROM Book b WHERE b.title LIKE ':title'")
})
public class Book {

  @Id
  @GeneratedValue
  @Column(name="BOOK_ID")
  private String id;

  @Column(name="TITLE")
  private String title;

  @Column(name="PRICE")
  private long price;

  public Book(String title, long price) {
    this.title = title;
    this.price = price;
  }

  public Book() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public Book clone() {
    Book book = new Book(this.getTitle(), this.getPrice());
    book.setId(getId());
    return book;
  }
}

