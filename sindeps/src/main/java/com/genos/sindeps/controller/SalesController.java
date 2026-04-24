package com.genos.sindeps.controller;

import com.genos.sindeps.entity.Sales;
import com.genos.sindeps.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController
{
    @Autowired
    private SalesRepository repo;

    @GetMapping("/sales")
    public List<Sales> getSales()
    {
        return repo.findAll();
    }

    @PostMapping("/sales")
    public Sales postSales(@RequestBody Sales sales)
    {
        return repo.save(sales);
    }

    @PutMapping("/sales/{id}")
    public Sales updateSales(@PathVariable long id , @RequestBody Sales sales)
    {
        sales.setId(id);
        return repo.save(sales);
    }

    @DeleteMapping("/sales/{id}")
    public void deleteSales(@PathVariable long id)
    {
        repo.deleteById(id);
    }
}
