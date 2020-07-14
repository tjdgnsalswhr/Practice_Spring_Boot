//package com.example.demo.product.controller.handler;
//
//import com.skt.twd.common.inventory.core.object.command.UpdateProductCommand;
//import com.skt.twd.common.inventory.core.object.event.CompletedUpdateProductEvent;
//import com.skt.twd.common.inventory.core.object.event.FailedUpdateProductEvent;
//import com.skt.twd.product.application.object.event.PlaceUpdateProductEvent;
//import com.skt.twd.product.application.object.vo.ProductVo;
//import com.skt.twd.product.core.domain.entity.Product;
//import com.skt.twd.product.core.port_infra.persistent.ProductRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.axonframework.commandhandling.gateway.CommandGateway;
//import org.axonframework.config.ProcessingGroup;
//import org.axonframework.eventhandling.EventHandler;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@AllArgsConstructor
//@Slf4j
//@Component
//@ProcessingGroup("ProductInventoryProjectionDaav")
//public class ProductInventoryProjectionHandler {
//    private final CommandGateway commandGateway;
//    private final ProductRepository productRepository;
//    private final ModelMapper modelMapper;
//
//    @EventHandler
//    public void on(PlaceUpdateProductEvent event) {
//
//        ProductVo productVo = event.getProductVo();
//        Optional<Product> optionalProduct = productRepository.findById(productVo.getId());
//        Product findProduct = optionalProduct.get();
//        int tmpStock = productVo.getStock();        //변경 stock tempStock으로 할당
//        productVo.setStock(findProduct.getStock()); //stock 정보는 현재로 유지
//        Product product = Product.builder().productVo(productVo).tmpStock(tmpStock).build();
//        modelMapper.map(product, findProduct);
//        productRepository.save(findProduct);
//
//        commandGateway.send(UpdateProductCommand.builder().productId(productVo.getId()).stock(tmpStock).build());
//        log.debug("UpdateProductCommand 송신");
//    }
//
//    @EventHandler
//    public void on(CompletedUpdateProductEvent event) {
//        log.debug("CompletedUpdateProductEvent 수신");
//        Optional<Product> optionalProduct = productRepository.findById(event.getProductId());
//        Product findProduct = optionalProduct.get();
//        findProduct.setStock(findProduct.getTmpStock());
//        productRepository.save(findProduct);
//    }
//
//    @EventHandler
//    public void on(FailedUpdateProductEvent event) {
//        log.debug("FailedUpdateProductEvent 수신");
//    }
//
//}
