package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void testToString() {
        Product product = new Smartphone();
        product.toString();
    }
}