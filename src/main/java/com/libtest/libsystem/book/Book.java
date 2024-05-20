package com.libtest.libsystem.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
  
    private Integer id;
    private String title;
    private String author;
    private String genre;
    private Integer year;
    private Integer pages;
    private String publisher;
    private String isbn;
    private String language;
    private String format;
    private String description;
    private String cover;
    private Integer quantity;
    private Integer available;
    private Integer borrowed;
    private Integer reserved;
    private Integer lost;
    private Integer damaged;
    private Integer deleted;
  
    public Book(String title, String author, String genre, Integer year, Integer pages, String publisher, String isbn, String language, String format, String description, String cover, Integer quantity, Integer available, Integer borrowed, Integer reserved, Integer lost, Integer damaged, Integer deleted) {
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.year = year;
      this.pages = pages;
      this.publisher = publisher;
      this.isbn = isbn;
      this.language = language;
      this.format = format;
      this.description = description;
      this.cover = cover;
      this.quantity = quantity;
      this.available = available;
      this.borrowed = borrowed;
      this.reserved = reserved;
      this.lost = lost;
      this.damaged = damaged;
      this.deleted = deleted;
    }
  
    public Integer getId() {
      return id;
    }
  
    public String getTitle() {
      return title;
    }
  
    public String getAuthor() {
      return author;
    }
  
    public String getGenre() {
      return genre;
    }
  
    public Integer getYear() {
      return year;
    }
  
    public Integer getPages() {
      return pages;
    }
  
    public String getPublisher() {
      return publisher;
    }
  
    public String getIsbn() {
      return isbn;
    }
  
    public String getLanguage() {
      return language;
    }
  
    public String getFormat() {
      return format;
    }
  
    public String getDescription() {
      return description;
    }
  
    public String getCover() {
      return cover;
    }
  
    public Integer getQuantity() {
      return quantity;
    }
  
    public Integer getAvailable() {
      return available;
    }
  
    public Integer getBorrowed() {
      return borrowed;
    }
  
    public Integer getReserved() {
      return reserved;
    }
  
    public Integer getLost() {
      return lost;
    }
  
    public Integer getDamaged() {
      return damaged;
    }

}
