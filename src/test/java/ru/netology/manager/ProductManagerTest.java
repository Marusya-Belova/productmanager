package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
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
    Product seven = new Book(7, "Гарри Поттер и Тайная комната", 800, "Джоан Роулинг");
    Product eight = new Smartphone(8, "Iphone", 100000, "Apple");

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
    }


    @Test
    void shouldsearchByNoBookWithName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Алиса в стране чудес");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByNameSmartphone() {
        Product[] expected = new Product[]{four, eight};
        Product[] actual = manager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
    }


    @Test
    void findByNameBook() {
        Product[] expected = new Product[]{two};
        Product[] actual = manager.searchBy("Путешествие к центру земли");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByNameCreator() {
        Product[] expected = new Product[]{five};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByAuthor() {
        Product[] expected = new Product[]{one, seven};
        Product[] actual = manager.searchBy("Джоан Роулинг");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByNoSmartphoneWithCreator() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
}