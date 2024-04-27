package br.com.souza.strategyfactory.example.strategy.factory;

import br.com.souza.strategyfactory.example.strategy.DiscountStrategy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class DiscountFactory {

    private final Map<Integer, DiscountStrategy> strategies = new HashMap<>();

    public DiscountFactory(Set<DiscountStrategy> strategySet){
        strategySet.forEach(s -> strategies.put(s.getLevelDiscount(), s));
    }

    public DiscountStrategy getStrategy(Integer clientLevel) throws Exception{
        DiscountStrategy strategy = strategies.get(clientLevel);
        if(strategy == null){
            throw new Exception("Invalid client Level");
        }
        return strategy;
    }
}
