package dao.author;

import conncetion.BookstoreEMF;
import dao.author.AuthorDao;
import entity.Author;

import javax.persistence.EntityManager;

public class AuthorDaoImplement implements AuthorDao {
    @Override
    public Author find(long id) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Author author = entityManager.find(Author.class, id);
        entityManager.close();
        return author;
    }

    @Override
    public void insert(Author author) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Author author) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        entityManager.remove(author);
        entityManager.close();
    }

    @Override
    public Author update(Author author) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Author updatedAuthor = entityManager.merge(author); //update
        entityManager.close();
        return updatedAuthor;
    }
}
