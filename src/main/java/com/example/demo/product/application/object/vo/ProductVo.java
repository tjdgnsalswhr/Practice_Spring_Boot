package com.example.demo.product.application.object.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductVo {
    private Long id;                        //상품 id
    @ApiModelProperty(example = "갤럭시 S20 5G")
    private String name;                    //상품명
    @ApiModelProperty(example = "SM-G981N_128GA")
    private String code;                    //상품코드
    @ApiModelProperty(example = "100")
    private int stock;                      //재고량
    @ApiModelProperty(example = "1248500")
    private int price;                      //상품 금액정보
    @ApiModelProperty(example = "전에 없던 퀄리티의 사진과 동영상의 완성")
    private String mainInfo;                //상품 간략 설명
    @ApiModelProperty(example = "전에 없던 퀄리티의 사진과 동영상의 완성")
    private String detailInfo;              //상품 상세 설명
    @ApiModelProperty(example = "https://cdnw.shop.tworld.co.kr/pimg/phone/A1/A1VQ/default/A1VQ_001_1.jpg")
    private String imgUrl;                  //상품 이미지 url
    private Date regDate;                   //생성일자
    private Date updDate;                   //수정일자

    @Builder
    public ProductVo(Long id, String name, String code, int stock, int price, String mainInfo, String detailInfo, String imgUrl) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.stock = stock;
        this.price = price;
        this.mainInfo = mainInfo;
        this.detailInfo = detailInfo;
        this.imgUrl = imgUrl;
        this.regDate = new Date();
        this.updDate = new Date();
    }
}
