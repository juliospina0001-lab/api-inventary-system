package com.inventario.inventario.service;

import com.inventario.inventario.domain.Product;
import com.inventario.inventario.dto.ProductRequestDTO;
import com.inventario.inventario.dto.ProductResponseDTO;
import com.inventario.inventario.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = mapToEntity(dto);
        Product savedProduct = productRepository.save(product);
        return mapToDTO(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        return mapToDTO(product);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setAvailableQuantity(dto.getAvailableQuantity());
        product.setCategory(dto.getCategory());

        Product updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        productRepository.delete(product);
    }

    public List<ProductResponseDTO> getProductsByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductResponseDTO> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Métodos privados para mapear entre Entidad y DTOs
    private Product mapToEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setAvailableQuantity(dto.getAvailableQuantity());
        product.setCategory(dto.getCategory());
        return product;
    }

    private ProductResponseDTO mapToDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setAvailableQuantity(product.getAvailableQuantity());
        dto.setCategory(product.getCategory());
        dto.setCreatedAt(product.getCreatedAt());
        return dto;
    }
}