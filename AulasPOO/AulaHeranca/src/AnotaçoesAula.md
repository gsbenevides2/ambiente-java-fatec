# Herança (Genralização/Especialização)

1. Em primeira instância: é uma forma de reuso e modificação de comportamento.

Anot: 
1. Abstrair coisas em comuns em uma classe(generalizar) e essa classe através de herança, herdar o que é comum em classes especialistas.

```
[Comum]^[Especialista1]
[Comum]^[Especialista2]
```

2. Herança é uma relação de "é um" entre classes.
3. A herança é uma forma de reuso de código.
4. A herança é uma forma de reuso de comportamento.
5. Subclasse/Derivada ou Pai/Mãe é uma classe que herda de outra classe.
6. Superclasse/Base ou Filho é a classe que é herdada por outra classe.
7. A criação de uma subclasse é chamada de especialização.
8. A criação de uma superclasse é chamada de generalização.
9. A primeira linha em um método construtor de uma subclasse é chamar o construtor da superclasse. Através da palavra reservada super 
10. A construção(construtor) é de cima para baixo.
11. Herança simples é quando uma classe herda de somente uma classe. E no Java, a herança é sempre simples.
12. Em Java todos os objetos herdam de Object.

## Sobrescrita de métodos
- A sobrescrita de métodos é a possibilidade de uma subclasse reescrever um método de sua superclasse.
- A execução  de métodos envolve procura-los a partir do tipo do objeto onde são invocados e, se não encontrados, eles são procurados na superclasse...
- Não confundir com a sobrecarga de métodos, que é a possibilidade de uma classe ter vários métodos com o mesmo nome, mas com assinaturas diferentes.
- A anotação @Override é opcional, mas é uma boa prática de programação. Ele serve para avisar o compilador que o método está sendo sobrescrito. Se o método não for sobrescrito corretamente, o compilador irá gerar um erro.
- A sobrescrita de métodos é de baixo para cima.
