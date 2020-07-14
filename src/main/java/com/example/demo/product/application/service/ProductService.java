package com.example.demo.product.application.service;

import com.example.demo.common.exception.BizException;
import com.example.demo.product.application.object.vo.ProductVo;
import com.example.demo.product.core.domain.entity.Product;
import com.example.demo.product.core.port_infra.persistent.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getOneProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            return null;
        }
    }

    public void updateProduct(ProductVo productVo){
        Optional<Product> optionalProduct = productRepository.findById(productVo.getId());
        if(!optionalProduct.isPresent()){
            throw new BizException("0000","no product");
        }
        Product targetProduct = optionalProduct.get();
        targetProduct.update(productVo);
        productRepository.save(targetProduct);
    }

    public void deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent()){
            throw new BizException("0000","no product");
        }
        productRepository.delete(optionalProduct.get());
    }

}
