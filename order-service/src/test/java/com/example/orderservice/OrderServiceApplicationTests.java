package com.example.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.tracing.BraveAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {BraveAutoConfiguration.class})
class OrderServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
