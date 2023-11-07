package br.com.souza.strategyfactory.example.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDiscountResponse {

    private String productName;
    private BigDecimal priceWithoutDiscount;
    private BigDecimal priceWithDiscount;
    private BigDecimal discountQuantity;

}
