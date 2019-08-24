package service;

import dao.author.AuthorDao;
import entity.Author;

public class AuthorServiceImplement implements AuthorService {

    private AuthorDao authorDao;

    public AuthorServiceImplement(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author findById(Long id) {
        if (id != null) {
            return authorDao.find(id);
        }
        return new Author();
    }

    @Override
    public Author update(Author author) {
        if (author.getId() != 0 && author.getLastName() != null && author.getLastName().isEmpty() == false) {
            return authorDao.update(author);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            authorDao.delete(new Author(id));
        }
    }

    @Override
    public Author insert(Author author) {
       if(author.getLastName()!=null && author.getLastName().isEmpty()==false){
           authorDao.insert(author);
       }
       return null;
    }
}
