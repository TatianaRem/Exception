import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.mainclasses.Book;
import ru.netology.mainclasses.Product;
import ru.netology.mainclasses.Smartphone;

public class ProductRepositoryTest {

    @Test
    public void shouldDeleteWhenIdExist() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(111, "Geborgtes Leben", 1500, "Erich Maria Remarque");
        Book book2 = new Book(222, "Thorn Birds", 1000, "Colleen McCullough");
        Book book3 = new Book(333, "The Master and Margarita", 2000, "Mikhail Bulgakov");

        Smartphone smartphone1 = new Smartphone(01, "14 pro Max", 100_000, "Apple");
        Smartphone smartphone2 = new Smartphone(02, "Galaxy S23 Plus", 120_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(03, "Galaxy S23 Ultra", 130_000, "Samsung");

        repository.saveProducts(book1);
        repository.saveProducts(book2);
        repository.saveProducts(book3);

        repository.saveProducts(smartphone1);
        repository.saveProducts(smartphone2);
        repository.saveProducts(smartphone3);
        repository.deleteById(02);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteWhenIdNotExist() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(111, "Geborgtes Leben", 1500, "Erich Maria Remarque");
        Book book2 = new Book(222, "Thorn Birds", 1000, "Colleen McCullough");
        Book book3 = new Book(333, "The Master and Margarita", 2000, "Mikhail Bulgakov");

        Smartphone smartphone1 = new Smartphone(01, "14 pro Max", 100_000, "Apple");
        Smartphone smartphone2 = new Smartphone(02, "Galaxy S23 Plus", 120_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(03, "Galaxy S23 Ultra", 130_000, "Samsung");

        repository.saveProducts(book1);
        repository.saveProducts(book2);
        repository.saveProducts(book3);

        repository.saveProducts(smartphone1);
        repository.saveProducts(smartphone2);
        repository.saveProducts(smartphone3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.deleteById(1111)
        );
    }
}
