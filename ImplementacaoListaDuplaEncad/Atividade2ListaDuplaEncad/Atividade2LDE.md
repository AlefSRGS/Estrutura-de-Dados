# Atividades de Estruturas de Dados 1 Listas duplamente encadeadas

## Atividade 2: Listas lineares duplamente encadeadas com descritor 

### **Questão única**: Você foi contratado para fazer um programa de controle de acesso ao prédio do escritório de consultoria Advogados S.A. O programa deve manter um cadastro de todas as pessoas que estão no prédio em um determinado momento. Seu programa deverá implementar o controle de acesso utilizando uma lista linear duplamente encadeada com descritor. A lista implementada deve ser não ordenada e sem repetidos e deverá ter as seguintes funcionalidades:
- **Cadastrar** uma pessoa quando ela entrar no prédio. O novo registro deve ser inserido no final do cadastro. O registro de uma pessoa contém seu nome e RG. Lembre-se que a lista não aceita repetido, ou seja, se a pessoa já está no prédio, não pode entrar novamente. 
- **Cancelar** o registro de uma pessoa que desistiu de entrar no prédio imediatamente após ser cadastrada. 
- **Exibir** os dados (nome e RG) de todas as pessoas que estão no prédio. 
- **Verificar**, dado o RG, se uma pessoa se encontra no prédio.
- Informar quantas pessoas estão no prédio em um dado momento. 
- **Remover** uma pessoa do cadastro quando ela sair do prédio. Para tal, deverá ser solicitado o RG da pessoa. 

O programa implementado deverá ter, obrigatoriamente, as seguintes classes: a classe Pessoa, a classe LDENode, a classe LDEPessoas e a classe da aplicação. Você é livre para implementar mais outras classes caso julgue necessário. 

A classe Pessoa deverá ter os seguintes atributos: nome (String) e RG (string). A classe Pessoa deve ser Comparable. O RG identifica unicamente uma pessoa, ou seja, não existem duas pessoas com o mesmo RG, portanto, deverá ser utilizado pelo método compareTo da classe Pessoa para comparar dois objetos da classe. 

**Lembrete**: Implemente um menu e um loop no programa principal (aplicação) para permitir que o usuário execute as funcionalidades implementadas quantas vezes desejar. 