package br.com.souza.strategyfactory.example.strategy;

import br.com.souza.strategyfactory.example.dto.ProductDiscountResponse;
import br.com.souza.strategyfactory.example.model.ProductEntity;

public interface DiscountStrategy {

    ProductDiscountResponse calcularDesconto(ProductEntity produto);
    Integer getLevelDiscount();

}
