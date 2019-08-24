package dao.book;

import conncetion.BookstoreEMF;
import dto.BookDto;
import dto.SimplePublisherDto;
import entity.Book;
import entity.CategoryCode;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class BookDaoImplement implements BookDao {


    @Override
    public Book find(long id) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        //spring robi to za nas a tak musimy to pisać
        return book;
    }

    @Override
    public void insert(Book book) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book); //insert
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Book book) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        entityManager.remove(book);
        entityManager.close();
    }

    @Override
    public Book update(Book book) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Book updatedBook = entityManager.merge(book); //update
        entityManager.close();
        return updatedBook;
    }

    @Override
    public List<Book> find() {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select b from Book b");
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<Book> findByTitle(String title) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select b from Book b where b.title = :givenTitle");
        query.setParameter("givenTitle",title);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<Book> findByCategories(List<CategoryCode> categoryCodes) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select b from Book b where b.category.code in  (:givenCategoryCodes)");
        query.setParameter("givenCategoryCodes",categoryCodes);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<Book> findBiggestPublisherBook() {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select new Book(b.pagesNumber, b.title) from Book b where b.pagesNumber in " +
                "(select max(b.pagesNumber) from Book b group by b.publisher.id)");

        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<BookDto> findBooksWithPublishers() {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select new dto.BookDto(b.id, b.title) from Book b ");
        List resultList = query.getResultList();
        fillSimplePublisherDto(resultList);
        entityManager.close();

        return resultList;
    }

    @Override
    public List<BookDto> findByAuthorIdAndPagesRange(long id, int lowerLimit, int upperLimit) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select new dto.BookDto(b.id,b.title) from Book b " +
                "join b.authors a where a.id = :authorId and b.pagesNumber between :min and :max");
        query.setParameter("authorId",id);
        query.setParameter("min",lowerLimit);
        query.setParameter("max",upperLimit);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<BookDto> findByIsbn(long isbn) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        //session jest tym samym w hibernate co entitymanger w JPA
        org.hibernate.query.Query query = session.createQuery("select b.id as id,b.title as title" +
                " from Book b where b.isbn = :givenIsbn");
        query.setParameter("givenIsbn",isbn);
        query.setResultTransformer(new ResultTransformer() {
            //przekreślone bo nie polacane do użycia
            //implementujemy dwie metody transformList i transformTuple to jest odpowiednik resultSet
            //to nam pozwala tworzyć różne zapytania bez konieczności tworzenia konstruktorów z takimi samymi
            //argumentami i ich kolejnością jak w zapytaniu. Było by ich bardzo dużo w klasach entity
            @Override
            public Object transformTuple(Object[] objects, String[] strings) {
                int id = Arrays.asList(strings).indexOf("id");
                int title = Arrays.asList(strings).indexOf("title");
                int isbn = Arrays.asList(strings).indexOf("isbn");
                int pagesNumber = Arrays.asList(strings).indexOf("pagesNumber");

                BookDto bookDto = new BookDto();
                bookDto.setId(id!=-1 ? (Long) objects[id] : 0);
                bookDto.setTitle(title!=-1 ? (String)objects[title] : null);
                bookDto.setIsbn(isbn!=-1 ? (Long) objects[isbn] : 0);
                bookDto.setPagesNumber(pagesNumber!=-1 ? (int) objects[pagesNumber]: 0);
                return bookDto;
            }

            @Override
            public List transformList(List list) {
                return list;
            }
        });
        List resultList = query.getResultList();

        entityManager.close();
        return resultList;
    }



    private void fillSimplePublisherDto(List<BookDto> books) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        for(BookDto book:books) {
            Query query = entityManager.createQuery("select new dto.SimplePublisherDto(p.id,p.name) from Publisher p join p.books b where b.id = :bookId");
            query.setParameter("bookId",book.getId());
            SimplePublisherDto singleResult = (SimplePublisherDto)query.getSingleResult();
            book.setPublishers(singleResult);
        }
        entityManager.close();
    }
}
