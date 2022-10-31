package com.evesga.breweryclient.web.client;

import com.evesga.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void testGetBeerById() {
        CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        CustomerDto dto = CustomerDto.builder().name("New Customer").build();

        URI uri = customerClient.saveCustomer(dto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        CustomerDto dto = CustomerDto.builder().name("New Customer").build();

        customerClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}