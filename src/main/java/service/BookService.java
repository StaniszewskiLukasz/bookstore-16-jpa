package service;

import dto.BookDto;
import entity.Book;
import entity.CategoryCode;

import java.util.List;

public interface BookService {
    Book findById(Long id);

    Book update(Book book);

    void delete(Long id);

    Book insert (Book book);

    List<Book> find();

    List<Book> findByTitle(String title);

    List<Book> findByCategories(List<CategoryCode> categoryCode);

    List<Book> findBiggestPublisherBook();

    List<BookDto> findBooksWithPublishers();

    List<BookDto> findByAuthorIdAndPagesRange(long id, int lowerLimit,int upperLimit);


}
