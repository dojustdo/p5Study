package com.example.producter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducterApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void contextLoads() {
        sender.send();
    }

}
