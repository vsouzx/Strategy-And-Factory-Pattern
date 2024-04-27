package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.dto.ProductDiscountResponse;
import br.com.souza.strategyfactory.example.model.ProductEntity;
import br.com.souza.strategyfactory.example.strategy.DiscountStrategy;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class PremiumLevelDiscount implements DiscountStrategy {

    @Override
    public ProductDiscountResponse calcularDesconto(ProductEntity product) {
        BigDecimal discount = product.getPrice().multiply(new BigDecimal("0.25"));

        return ProductDiscountResponse.builder()
                .productName(product.getName())
                .priceWithoutDiscount(product.getPrice())
                .priceWithDiscount(product.getPrice().subtract(discount))
                .discountQuantity(discount)
                .build();
    }

    @Override
    public Integer getLevelDiscount() {
        return 3;
    }
}
