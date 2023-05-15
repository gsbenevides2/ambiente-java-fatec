# Anotações

## TDD - Test-Driven Development

- Testes trazem uma melhor qualidade para o código.
- Sem testes fica emum ciclo de correção é bug.
- Testes para quando fazer algum tipo de mundaça você poder se certificar que nada quebrou no código.

## Tipos de Teste:
- Teste Unitário: O teste que testa uma unidade isolado do código. Um teste que testa somente uma classe. 
- Teste de Integração: Testei as unidade e quer ver como elas funcionam em conjunto. Como se integram.
- Teste de Aceitação/End to End: Simula o uso do sistema na interface gráfica.
- Teste de Carga/Estresse: Como o sistema se comporta com muitos usuários.

## Qual a sequencia tradicional de se testar uma aplicação?
- Primeiro codificar e depois testar.
- TDD inverte a lógica: Primeiro criar o teste e depois codificar.
- O TDD diz:
  - 1º Escreve o teste.
  - 2º Escreve o código para o teste passar.
  - 3º Refatorar o código. Altera a estrutura do seu código sem quebrar o que funciona.

## Vantagens
- Ao usar TDD você foca no uso (Tende a ser mais simples)
  - E amplia a visão sobre caminhos 
  - Ao fazer o teste antes você garante que está criando uma cobertura mínima de testes.

## Bibliotecas de Teste
- Java: JUnit
- Python: PyUnit, PyTest
- JavaScript: Jest
- C#: nUnit
### Bibliotecas de Duple de teste
-  Uma biblioteca que subistitui classes originais por classes duble para evitar.
  - Envio de emails
- Quero isolar a classe a ser testada
- O Mock é esse obtejo falso. Mas tem varios outros tipos e dependendo do comportamento tem nomes diferentes.

## Tipos de Projetos em Java
- Especifico para a IDE. Estrutura especifica para a IDE;
- Maven: Projeto como estrutura de pastas pre definida e com uma ferramenta que gerencia a execução e dependencias.
  - Arquivo pom.xml
- Gradle: A mesma coisa que o Maven mas com uma ferramenta diferente.

## Ver a lib do JUnit