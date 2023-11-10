# O que é o Strategy Pattern e para que ele serve?

O Strategy pattern é um padrão de projeto comportamental que permite que você defina uma familia de algoritmos, e faça os objetos deles intercambiáveis.

Basicamente, você pega uma classe que faz algo específico em diversas maneiras diferentes, geralmente usando diversos IF/ELSE ou Switch Case e extraia todos esses algoritmos para classes separadas chamadas estratégias.

Todas as estratégias seguem o contrato de uma interface, ou seja, todas tem a mesma assinatura de método, porém com lógicas diferentes.

# Então quais são os benefícios do Strategy?

<p>-Você pode trocar algoritmos usados dentro de um objeto durante a execução.</p>

<p>-Você pode isolar os detalhes de implementação de um algoritmo do código que usa ele.</p>

<p>Princípio aberto/fechado. Você pode introduzir novas estratégias sem mudar o contexto. Basicamente, sem ficar adicionando IF/ELSE e Switch Cases no seu código.</p>
