package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product one = new Book(1, "Гарри Поттер и Философский камень", 800, "Джоан Роулинг");
    Product two = new Book(2, "Путешествие к центру земли", 700, "Жюль Верн");
    Product three = new Book(3, "Приключения Тома Сойера", 750, "Марк Твен");
    Product four = new Smartphone(4, "Iphone", 100000, "Apple");
    Product five = new Smartphone(5, "3210", 2000, "Nokia");
    Product six = new Smartphone(6, "RZRV3", 15000, "Motorolla");

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);


    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
    }

    @Test
    public void addProduct() {
        manager.add(one);
        assertArrayEquals(new Product[]{one}, repository.findAll());
    }


    @Test
    void findByNameSmartphone() {
        setUp();
        Product[] expected = new Product[]{four};
        Product[] actual = manager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findNoValue() {
        setUp();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByNameBook() {
        setUp();
        Product[] expected = new Product[]{two};
        Product[] actual = manager.searchBy("Путешествие к центру земли");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByNameCreator() {
        setUp();
        Product[] expected = new Product[]{five};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }
}