package com.example.inventorydemo;

import com.example.inventorydemo.model.Inventory;
import com.example.inventorydemo.repository.InventoryRepository;
import com.netflix.appinfo.ApplicationInfoManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(InventoryDemoApplication.class, args);
    }

    //this need to fill the inventory table with some data
    @Bean
    public CommandLineRunner loadRunner(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(100);
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_13_Red");
            inventory1.setQuantity(100);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }
}
