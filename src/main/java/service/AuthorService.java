package service;

import entity.Author;

public interface AuthorService {
    Author findById(Long id);

    Author update(Author author);

    void delete(Long id);

    Author insert (Author author);
}
