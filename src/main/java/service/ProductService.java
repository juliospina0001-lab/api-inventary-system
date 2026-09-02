package service;

import domain.Product;
import dto.ProductRequestDTO;
import dto.ProductResponseDTO;
import repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        Product savedProduct = productRepository.save(product);
        return convertToResponseDTO(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
        return convertToResponseDTO(product);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        Product updatedProduct = productRepository.save(product);
        return convertToResponseDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
        productRepository.delete(product);
    }

    private ProductResponseDTO convertToResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }
}


