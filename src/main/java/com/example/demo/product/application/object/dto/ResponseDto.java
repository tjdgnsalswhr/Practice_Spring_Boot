package com.example.demo.product.application.object.dto;

import com.example.demo.product.application.object.vo.ErrorVo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private T data;
    private ErrorVo errorVo;

    public ResponseDto(T data) {
        this(data, new ErrorVo());
    }

    public ResponseDto(ErrorVo errorVo) {
        this(null, errorVo);
    }

    public ResponseDto(CompletableFuture<String> canceledUpdateInventory, HttpStatus ok) {
    }
}
