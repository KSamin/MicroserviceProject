package com.Project.inventory_service.service;

import com.Project.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class InventoryService {
    private  final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){

        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
