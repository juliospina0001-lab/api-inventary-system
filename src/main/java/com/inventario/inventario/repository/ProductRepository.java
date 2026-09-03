package com.inventario.inventario.repository;

import com.inventario.inventario.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Consulta adicional 1: Buscar por categoría
    List<Product> findByCategoryIgnoreCase(String category);

    // Consulta adicional 2: Buscar por nombre que contenga la palabra
    List<Product> findByNameContainingIgnoreCase(String name);
}