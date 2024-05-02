### Atividade de Estruturas de Dados I Árvores Binárias e Árvores Binárias de Busca 

#### 1ª Questão: Implemente o cadastro de produtos de uma empresa utilizando uma árvore binária de busca. Cada nó da árvore deve armazenar as informações relativas a um produto: código, descrição, fornecedor, preço e quantidade em estoque. A chave de ordenação da árvore é o código do produto. O programa deverá ter os seguintes sub-programas: 

- Procedimento para cadastrar um novo produto. O procedimento deverá solicitar ao usuário as informações do produto a ser cadastrado e inserir o produto no cadastro. Não serão aceitos mais de um produto com mesmo código. 

- Procedimento para exibir as informações (código, descrição, fornecedor, preço e quantidade em estoque) de todos os produtos cadastrados por ordem crescente de código. Este procedimento deverá utilizar o passeio em ordem. 

- Função para procurar um produto no cadastro. A função deverá receber como parâmetro o código do produto procurado e deverá retornar uma referência para o produto procurado ou null, caso não encontre. Esta função deverá ser utilizada pelos procedimentos dos itens (d), (e) e (f). 

- Procedimento para alterar o preço de um produto. O procedimento deverá receber como parâmetro o código do produto cujo preço será alterado. Este procedimento deverá utilizar a função definida no item (c). 

- Procedimento para alterar a quantidade em estoque de um produto. O procedimento deverá receber como parâmetro o código do produto cuja quantidade será alterada. Este procedimento deverá utilizar a função definida no item (c). 

- Procedimento para exibir as informações (código, descrição, fornecedor, preço e quantidade em estoque) de um produto. O procedimento deverá receber como parâmetro o código do produto cujas informações serão exibidas. Este procedimento deverá utilizar a função definida no item (c). 

##### OBSERVAÇÕES: 

- Este programa deverá ser, no mínimo, cinco classes: a classe Produto, a classe SearchTree, a classe TreeNode e a classe da Aplicação. 

- A classe Produto é a classe base. Um código identifica um produto unicamente. 

- A classe Tree deve ter apenas os métodos que implementam as operações de árvore. 

#### 2ª Questão: Implemente o método de busca (não recursivo) em uma árvore binária de busca. Este método deverá receber como parâmetro o objeto procurado. 

 

#### 3ª Questão: Implemente o método de inserção (não recursivo) em uma árvore binária de busca. Este método deverá receber como parâmetro o objeto a ser inserido. 

 

#### 4ª Questão: Considere uma árvore binária de busca de números inteiros. Implemente os métodos abaixo: 

 

- Uma função para retornar o endereço do nó que contém o menor valor armazenado na árvore.

- Uma função para retornar o endereço do nó que contém o maior valor armazenado na árvore. 

- Uma função para contar o número de nós da árvore. 

- Uma função para contar o número de folhas da árvore. 

- Uma função para contar o número de nós não-terminais da árvore. 

#### 5ª Questão: Considere uma árvore binária qualquer. Implemente os métodos abaixo: 

- Um procedimento não recursivo para percorrer a árvore utilizando o passeio em- ordem. 

- Um procedimento não recursivo para percorrer a árvore utilizando o passeio em pré- ordem. 

##### OBS: Utilize como exemplo o passeio por nível. 

##### Dica: Utilize uma pilha como estrutura auxiliar para percorrer a árvore. 

 

#### 6ª Questão: Considere uma árvore binária de busca que permite valores repetidos. Implemente um método (função não recursiva) para contar quantas vezes um determinado item aparece na árvore. Esta função recebe como parâmetro o valor procurado e retorna quantas vezes ele aparece na árvore. 