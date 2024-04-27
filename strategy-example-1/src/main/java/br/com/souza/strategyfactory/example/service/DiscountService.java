package br.com.souza.strategyfactory.example.service;

import br.com.souza.strategyfactory.example.dto.ProductDiscountResponse;
import br.com.souza.strategyfactory.example.model.ProductEntity;
import br.com.souza.strategyfactory.example.strategy.DiscountStrategy;
import br.com.souza.strategyfactory.example.strategy.factory.DiscountFactory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    private static final Map<Integer, ProductEntity> PRODUCTS = new HashMap<>();
    private final DiscountFactory discountFactory;

    static {
        PRODUCTS.put(1, ProductEntity.builder()
                .id(1)
                .name("Iphone 13")
                .price(new BigDecimal("3999"))
                .minClientLevelForDiscount(1)
                .build());

        PRODUCTS.put(2, ProductEntity.builder()
                .id(2)
                .name("Iphone 14 PRO")
                .price(new BigDecimal("6000"))
                .minClientLevelForDiscount(2)
                .build());

        PRODUCTS.put(3, ProductEntity.builder()
                .id(3)
                .name("Iphone 15 PRO Max")
                .price(new BigDecimal("10000"))
                .minClientLevelForDiscount(3)
                .build());

        PRODUCTS.put(4, ProductEntity.builder()
                .id(4)
                .name("Iphone 11")
                .price(new BigDecimal("2500"))
                .minClientLevelForDiscount(0)
                .build());
    }

    public DiscountService(DiscountFactory discountFactory) {
        this.discountFactory = discountFactory;
    }

    public ProductDiscountResponse getProductDiscount(Integer productIdentifier, Integer clientLevel) throws Exception {

        ProductEntity product = PRODUCTS.get(productIdentifier);
        if (product == null) {
            throw new Exception("Product not found");
        }
        return discountFactory.getStrategy(clientLevel).calcularDesconto(product);
    }
}
