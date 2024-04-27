package br.com.souza.strategyfactory.example.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductEntity {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer minClientLevelForDiscount;

}
