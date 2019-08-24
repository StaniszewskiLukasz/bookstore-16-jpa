import dao.book.BookDaoImplement;
import entity.Book;
import entity.Category;
import entity.CategoryCode;
import service.BookService;
import service.BookServiceImplement;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BookService bookService = new BookServiceImplement(new BookDaoImplement());
        Book byId = bookService.findById(2L);
        System.out.println(byId);

        Category category = new Category();
        category.setName("History");
        category.setCode(CategoryCode.HISTORY);


        Book book = new Book();
        book.setTitle("Ksiązka B");
        book.setPagesNumber(400);
        book.setIsbn(10101010101010L);

        bookService.insert(book);

        System.out.println(byId.getAuthors());



    }
}
