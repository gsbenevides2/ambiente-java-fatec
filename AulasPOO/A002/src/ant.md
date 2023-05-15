# Anotações

 - Aumento de legibilidade traz menos desempenho.
 - E um aumento em desempenho traz menos legebilidade.
 - Em geral no mercado prioriza-se a legibilidade.

# Encapsulamento

 - Criação de métodos get e set para controlar os acessos aos atributos. Protegendo-os contra alterações e acessos indevidos.
 - Utilização do modificador de acesso private em atributos para que os mesmos não possam ser acessados fora da classe.
 - Métodos setter(set): métodos que alteram, definam os valores em atributos.
 - Métodos getter(get): métodos que retornam os valores e somente os valores dos atributos.
 - Uma forma de impedir que outras classes saibam como aquela classe armazena internamente seus atributos. (Redução de Acoplamento!)

## Acoplamento
 - O quanto uma parte do sistema conhece da outras partes.
 - Utiliza-se encapsulamento para reduzir o acoplamento.
 - Teria do Ovo:
   - A gema do ovo, centro são os atributos.
   - A clara do ovo, parte externa são os métodos.
   - A comunicação entre objetos sempre é feita com os métodos, nunca uma classe acessa o atributo de outra classe.
   - Uma célula idependente das outras.