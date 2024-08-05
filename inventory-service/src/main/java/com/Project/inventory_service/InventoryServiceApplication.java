package com.Project.inventory_service;

import com.Project.inventory_service.model.Inventory;
import com.Project.inventory_service.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			try {
				Inventory inventory1 = new Inventory();
				inventory1.setSkuCode("iphone_13");
				inventory1.setQuantity(100);

				Inventory inventory2 = new Inventory();
				inventory2.setSkuCode("iphone_13_red");
				inventory2.setQuantity(0);

				inventoryRepository.save(inventory1);
				inventoryRepository.save(inventory2);

				logger.info("Inventory items saved successfully.");
			} catch (Exception e) {
				logger.error("Error occurred while saving inventory items: ", e);
			}
		};
	}
}
