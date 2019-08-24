package dao.book;


import dao.AbstractDao;
import dto.BookDto;
import entity.Book;
import entity.CategoryCode;

import java.util.List;

public interface BookDao extends AbstractDao<Book> {
    //metody jpql
    List<Book> find();
    List<Book> findByTitle(String title);
    List<Book> findByCategories(List<CategoryCode> categoryCode);
    List<Book> findBiggestPublisherBook();
    List<BookDto> findBooksWithPublishers();
    List<BookDto> findByAuthorIdAndPagesRange(long id, int lowerLimit,int upperLimit);
    List<BookDto> findByIsbn(long isbn);
}
