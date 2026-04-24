package com.genos.sindeps.repository;

import com.genos.sindeps.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales , Long>
{

}
