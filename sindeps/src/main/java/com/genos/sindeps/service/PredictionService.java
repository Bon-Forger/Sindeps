package com.genos.sindeps.service;

import com.genos.sindeps.dto.PredictionResponse;
import com.genos.sindeps.entity.Product;
import com.genos.sindeps.entity.Sales;
import com.genos.sindeps.repository.ProductRepository;
import com.genos.sindeps.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredictionService
{
//1. Get sales of a product
//2. Take last few records
//3. Calculate average
//4. Return predicted demand

    @Autowired
    private SalesRepository salesData;
    @Autowired
    private ProductRepository productRepository;

    public PredictionResponse predictDemand(long productId) {

        List<Sales> filtered = new ArrayList<>();

        List<Sales> data = salesData.findAll();

        for (Sales sale : data) {
            if (sale.getProductId() == productId) {
                filtered.add(sale);
            }
        }

        filtered.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        int limit = Math.min(5, filtered.size());
        List<Sales> recentSales = filtered.subList(0, limit);

        double total = 0;

        for (Sales sale : recentSales) {
            total += sale.getQuantitySold();
        }

        double avg = (limit == 0) ? 0 : total / limit;


        String message1;

        if (avg > 20) {
            message1 = "High demand. Reorder immediately!";
        } else if (avg >= 10) {
            message1 = "Moderate demand. Monitor stock levels.";
        } else {
            message1 = "Low demand. Stock is sufficient.";
        }

        Product product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            return new PredictionResponse("Product not found", avg ,productId);
        }

        long stock = product.getQuantity();

        String message2;
        if (stock < avg * 3) {
            message2 = "Reorder recommended. Stock may run out soon.";
        } else {
            message2 = "Stock is sufficient.";
        }

        return new PredictionResponse(message1 + " " + message2 , avg , productId );

    }
}
