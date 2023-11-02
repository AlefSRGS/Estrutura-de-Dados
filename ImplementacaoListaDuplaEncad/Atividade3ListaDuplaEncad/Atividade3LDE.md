# Atividade 3 de Listas duplamente encadeadas Estruturas de Dados I 

### **1ª Questão**: Considere uma lista duplamente encadeada, com nó descritor, de números inteiros, não ordenada e que contém valores repetidos. Implemente um método de remoção que recebe como parâmetro um valor a ser removido. Este método deverá remover da lista todas as cópias deste valor, informando, ao final, quantas cópias foram removidas.
#### OBS: NÃO É PERMITIDO, chamar a função de busca neste método.

### **2ª Questão**: Considere dois conjuntos de números inteiros (A e B) implementados utilizando listas lineares duplamente encadeadas, com nó descritor, não ordenadas e sem repetidos. Implemente, na classe LDEInt, os métodos abaixo:
    (a) Função intersecao para criar uma lista e preenchê-la com os valores pertencentes à lista A e que também estão presentes na lista B. A função deverá retornar a nova lista gerada.
Exemplo de chamada da função: LDEInt C = A.intersecao (B);

    (b) Função uniao para criar uma lista e preenchê-la com os valores pertencentes à lista A e/ou pertencentes à lista B. A lista gerada não poderá conter valores repetidos. A função deverá retornar a nova lista gerada.
Exemplo de chamada da função: LDEInt D = A.uniao (B);

    (c) Função diferenca para criar uma lista e preenchê-la com os valores pertencentes à lista A e que não estão presentes na lista B. A lista gerada não poderá conter valores repetidos. A função deverá retornar a nova lista gerada.
Exemplo de chamada da função: LDEInt E = A.diferenca (B);


#### Implemente o programa para preencher as listas A e B com valores digitados e para gerar e exibir os valores das listas resultantes da interseçã(C), união (D) e diferença(E) entre as lista A e B. Implemente os procedimentos e funções que julgar necessários, além dos solicitados nos itens (a), (b) e (c).