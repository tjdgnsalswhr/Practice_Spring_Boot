package com.example.demo.product.controller.web;

import com.example.demo.product.application.object.dto.ResponseDto;
import com.example.demo.product.application.object.vo.ProductVo;
import com.example.demo.product.application.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/twd-product-api")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/products")
    @ApiOperation(value = "상품 정보 전체 조회", httpMethod = "GET", notes = "상품 정보 전체 조회 API. ")
    public ResponseEntity<Object> getAllProductInfoList() {
        return new ResponseEntity<>(new ResponseDto(productService.getAllProduct()), HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    @ApiOperation(value = "상품 정보 1건 조회", httpMethod = "GET", notes = "상품 정보 1건 조회 API. ")
    public ResponseEntity<Object> getProductInfo(@PathVariable Long id) {
        return new ResponseEntity<>(new ResponseDto(productService.getOneProduct(id)), HttpStatus.OK);
    }

    @PostMapping(value = "/product")
    @ApiOperation(value = "상품 정보 1건 추가", httpMethod = "POST", notes = "상품 정보 1건 추가 API. ")
    public ResponseEntity<Object> insertProductInfo(@RequestBody ProductVo productVo) {
//        productService.(productVo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/product")
    @ApiOperation(value = "상품 정보 1건 수정", httpMethod = "PUT", notes = "상품 정보 1건 수정 API. ")
    public ResponseEntity<Object> updateProductInfo(@RequestBody ProductVo productVo) {
        productService.updateProduct(productVo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/product")
    @ApiOperation(value = "상품 정보 1건 삭제", httpMethod = "DELETE", notes = "상품 정보 1건 삭제 API. ")
    public ResponseEntity<Object> deleteProductInfo(Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
