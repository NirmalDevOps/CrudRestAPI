package com.myapp.demo.service;

import com.myapp.demo.dto.ProductRequestDTO;
import com.myapp.demo.dto.ProductResponseDTO;
import com.myapp.demo.entity.Product;
import com.myapp.demo.exception.ProductNotFoundException;
import com.myapp.demo.exception.ProductServiceBusinessException;
import com.myapp.demo.repository.ProductRepository;
import com.myapp.demo.util.ValueMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) throws ProductServiceBusinessException {
//        ProductResponseDTO productResponseDTO;
//        try {
//            log.info("ProductService:saveProduct execution started.");
//            Product product = ValueMapper.convertToEntity(productRequestDTO);
//            log.debug("ProductService:saveProduct request parameters {}", ValueMapper.jsonAsString(productRequestDTO));
//
//            Product productResults = productRepository.save(product);
//            productResponseDTO = ValueMapper.convertToDTO(productResults);
//            log.debug("ProductService:createNewProduct received response from Database {}", ValueMapper.jsonAsString(productRequestDTO));
//
//        } catch (Exception ex) {
//            log.error("Exception occurred while persisting product to database , Exception message {}", ex.getMessage());
//            throw new ProductServiceBusinessException("Exception occurred while saving a new product");
//        }
//        log.info("ProductService:createNewProduct execution ended.");
//        return productResponseDTO;
//    }
//
//    @Cacheable(value = "product")
//    public List<ProductResponseDTO> getProducts() throws ProductServiceBusinessException {
//        List<ProductResponseDTO> productResponseDTOS;
//        log.info("ProductService: getProducts execution started");
//        try {
//            List<Product> productList = productRepository.findAll();
//            if (!productList.isEmpty()) {
//                productResponseDTOS = productList.stream().map(ValueMapper::convertToDTO).collect(Collectors.toList());
//            } else {
//                productResponseDTOS = Collections.emptyList();
//            }
//            log.debug("ProductService:getProducts retrieving products from database  {}", ValueMapper.jsonAsString(productResponseDTOS));
//        } catch (Exception ex) {
//            log.error("Exception occurred while retrieving products from database , Exception message {}", ex.getMessage());
//            throw new ProductServiceBusinessException("Exception occurred while fetch all products from Database");
//        }
//        log.info("ProductService: getProducts execution ended");
//        return productResponseDTOS;
//    }
//
//    public ProductResponseDTO getProductById(Long productId) {
//        log.info("ProductService: getProductById execution started");
//        ProductResponseDTO productResponseDTO;
////        Optional<Product> product = productRepository.findById(productId);
////        if(product.isPresent()){
////            productResponseDTO=ValueMapper.convertToDTO(product.get());
////        }
////        else{
////            log.error("Product not found for the Id {} ",productId);
////            throw new ProductNotFoundException("Product not found for the Id "+productId);
////        }
//        try {
//            Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found for the Id " + productId));
//            productResponseDTO = ValueMapper.convertToDTO(product);
//            log.debug("ProductService:getProductById retrieving product from database for id {} {}", productId, ValueMapper.jsonAsString(productResponseDTO));
//        } catch (Exception ex) {
//            log.error("Exception occurred while retrieving product {} from database , Exception message {}", productId, ex.getMessage());
//            throw new ProductServiceBusinessException("Exception occurred while fetch product from Database " + productId);
//        }
//        log.info("ProductService: getProductById execution ended");
//        return productResponseDTO;
//    }
//
//    public Map<String, List<ProductResponseDTO>> getProductsByType() {
//
//        log.info("ProductService:getProductsByType execution started");
//        try {
//            Map<String, List<ProductResponseDTO>> productsMap =
//                    productRepository.findAll().stream()
//                            .map(ValueMapper::convertToDTO)
//                            .filter(productResponseDTO -> productResponseDTO.getProductType() != null)
//                            .collect(Collectors.groupingBy(ProductResponseDTO::getProductType));
//
//            return productsMap;
//        } catch (Exception ex) {
//            log.error("Exception occurred while retrieving product grouping by type from database , Exception message {}", ex.getMessage());
//            throw new ProductServiceBusinessException("Exception occurred while fetch product from Database ");
//
//        }
//    }
//
//    public boolean deleteProduct(long productId){
//        boolean deleteFlag = false;
//        try{
//            productRepository.deleteById(productId);
//            return deleteFlag=true;
//        }
//        catch (Exception ex){
//            log.info("Exception occurred while deleting the productId {} reason is ",productId ,ex.getMessage());
//        throw new ProductNotFoundException("ProductId {} not found to delete"+String.valueOf(productId));
//        }
//    }
}
