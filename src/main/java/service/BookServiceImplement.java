package service;

import dao.book.BookDao;
import dto.BookDto;
import entity.Book;
import entity.CategoryCode;

import java.util.List;

public class BookServiceImplement implements BookService {

    private BookDao bookDao;
    //    private BookDao bookDao = new BookDao()
//    tak nie robimy bo możemy mieć kiedyś dwa bookDao jaden dla Oracla a jeden dla MySQL i się popierdoli


    public BookServiceImplement(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book findById(Long id) {
        if (id != null) {
            return bookDao.find(id);
        }
        return new Book();
    }

    @Override
    public Book update(Book book) {
        if (book.getId() != 0 && book.getTitle() != null && book.getTitle().isEmpty() == false) {
            return bookDao.update(book);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            bookDao.delete(new Book(id));
        }
    }

    @Override
    public Book insert(Book book) {
        if (book.getTitle() != null && book.getTitle().isEmpty() == false) {
            bookDao.insert(book);
        }
        return null;
    }

    @Override
    public List<Book> find() {
        return null;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findByCategories(List<CategoryCode> categoryCode) {
        return null;
    }

    @Override
    public List<Book> findBiggestPublisherBook() {
        return null;
    }

    @Override
    public List<BookDto> findBooksWithPublishers() {
        return null;
    }

    @Override
    public List<BookDto> findByAuthorIdAndPagesRange(long id, int lowerLimit, int upperLimit) {
        return null;
    }


}
