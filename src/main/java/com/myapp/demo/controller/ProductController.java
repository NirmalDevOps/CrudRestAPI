package com.myapp.demo.controller;

import com.myapp.demo.dto.ProductRequestDTO;
import com.myapp.demo.dto.ProductResponseDTO;
import com.myapp.demo.request.ProductRequest;
import com.myapp.demo.response.APIResponse;
import com.myapp.demo.serviceImpl.ProductServiceImpl;
import com.myapp.demo.util.ValueMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/products")
//@AllArgsConstructor // or @RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<APIResponse> saveProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        log.info("ProductController::createNewProduct request body {}", ValueMapper.jsonAsString(productRequestDTO));

        ProductResponseDTO productResponseDTO = productService.saveProduct(productRequestDTO);

        APIResponse<ProductResponseDTO> responseDTO = APIResponse.<ProductResponseDTO>builder()
                .status("SUCCESS").results(productResponseDTO).build();

        log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<APIResponse> getAllProducts() {

        List<ProductResponseDTO> products = productService.getProducts();
        APIResponse<List<ProductResponseDTO>> responseDTO = APIResponse.<List<ProductResponseDTO>>builder().status("SUCCESS").results(products).build();
        log.info("ProductController::getProducts response {}", ValueMapper.jsonAsString(responseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<APIResponse> getProductById(@PathVariable Long productId){
        log.info("ProductController::getProductById id {}", productId);

        ProductResponseDTO productResponseDTO=productService.getProductById(productId);
        APIResponse<ProductResponseDTO> responseDTO = APIResponse.<ProductResponseDTO>builder()
                .status("SUCCESS").results(productResponseDTO).build();
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/types")
    public ResponseEntity<APIResponse> getProductsByType(){
        Map<String, List<ProductResponseDTO>> productsByType = productService.getProductsByType();

        APIResponse<Map<String, List<ProductResponseDTO>>> responseDTO  =APIResponse.<Map<String, List<ProductResponseDTO>>>builder().status("SUCCESS")
                .results(productsByType).build();
        log.info("ProductController::getProductsGroupByType by types  {}", ValueMapper.jsonAsString(responseDTO));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/delete/{productId}")
    public ResponseEntity<APIResponse> deleteProductById(@PathVariable Long productId){

        boolean status=productService.deleteProduct(productId);

        APIResponse <Boolean> deleteStatus= APIResponse.<Boolean>builder().status("SUCCESS").
                results(status).build();
        return new ResponseEntity<>(deleteStatus,HttpStatus.OK);

    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<APIResponse> updateProductById(@PathVariable long productId, @RequestBody ProductRequestDTO productRequestDTO){
            ProductResponseDTO productResponse=productService.updateProduct(productId,productRequestDTO);
        APIResponse<ProductResponseDTO> responseDTO = APIResponse.<ProductResponseDTO>builder()
                .status("SUCCESS").results(productResponse).build();

        log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PatchMapping("/updateField/{productId}")
    public ResponseEntity<APIResponse> updateRequiredFieldOfProductById(@PathVariable long productId, @RequestBody Map<String,Object> fields){
        ProductResponseDTO productResponse=productService.updateProductFields(productId,fields);
        APIResponse<ProductResponseDTO> responseDTO = APIResponse.<ProductResponseDTO>builder()
                .status("SUCCESS").results(productResponse).build();

        log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
