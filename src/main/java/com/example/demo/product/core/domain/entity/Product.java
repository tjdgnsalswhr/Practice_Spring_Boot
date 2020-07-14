package com.example.demo.product.core.domain.entity;

import com.example.demo.product.application.object.vo.ProductVo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "product")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                        //상품 id
    private String name;                    //상품명
    private String code;                    //상품코드
    private int stock;                      //재고량
    private int tmpStock;                    //임시 재고량
    private int price;                      //상품 금액정보
    private String mainInfo;                //상품 간략 설명
    private String detailInfo;              //상품 상세 설명
    private String imgUrl;                  //상품 이미지 url
    private Date regDate;                   //생성일자
    private Date updDate;                   //수정일자

    @Builder
    Product(ProductVo productVo, int tmpStock) {
        this.name = productVo.getName();
        this.code = productVo.getCode();
        this.stock = productVo.getStock();
        this.tmpStock = tmpStock;
        this.price = productVo.getPrice();
        this.mainInfo = productVo.getMainInfo();
        this.detailInfo = productVo.getDetailInfo();
        this.imgUrl = productVo.getImgUrl();
        this.regDate = new Date();
        this.updDate = new Date();
    }

    public void update(ProductVo productVo){
        this.name = productVo.getName();
        this.code = productVo.getCode();
        this.stock = productVo.getStock();
        this.tmpStock = tmpStock;
        this.price = productVo.getPrice();
        this.mainInfo = productVo.getMainInfo();
        this.detailInfo = productVo.getDetailInfo();
        this.imgUrl = productVo.getImgUrl();
        this.regDate = new Date();
        this.updDate = new Date();
    }
}
