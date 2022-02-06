package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    Product one = new Book(1, "Гарри Поттер и Философский камень", 800, "Джоан Роулинг");
    Product two = new Book(2, "Путешествие к центру земли", 700, "Жюль Верн");
    Product three = new Book(3, "Приключения Тома Сойера", 750, "Марк Твен");
    Product four = new Smartphone(4, "Iphone", 100000, "Apple");
    Product five = new Smartphone(5, "3210", 2000, "Nokia");
    Product six = new Smartphone(6, "RZRV3", 15000, "Motorolla");
    Product seven = new Book(7, "Гарри Поттер и Тайная комната", 800, "Джоан Роулинг");
    Product eight = new Smartphone(8, "Iphone", 100000, "Apple");

    @Test
    void shouldSaveItem() {
        repository.save(one);
        repository.save(two);

        Product[] expected = new Product[]{one, two};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDeleteById() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);

        repository.removeById(3);

        assertArrayEquals(new Product[]{one, two, four, five}, repository.findAll());
    }
    @Test
    void shouldThrowNotFoundExeptionIfProductWithIdNotExist() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}