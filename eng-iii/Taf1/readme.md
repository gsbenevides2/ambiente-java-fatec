## 1ª Tarefa: Realizar os exercícos de Interface

#### Instruções
Realizar os exercícos de Interface que se encontram na aula 2.

#### Exercicios
1 - Crie uma classe abstrata, chamada Conexao. 
Esta classe deve ter os seguintes atributos, do tipo propriedade:
- status do tipo String
Esta classe deve ter os seguintes métodos:
- conectar
- desconectar
Nestes métodos apenas o corpo, isso sem código dentro. Esta classe deve ter também os seguintes métodos abstratos:
- alterar
- excluir
- incluir

2 - Crie uma interface chamada Cadastros Esta interface deve ter os seguintes métodos:
```java
public String getStatus();
public int getCodigo();
public void setCodigo(int codigo);
public String getNome();
public void setNome(String nome);
```
3 - Crie uma interface chamada Enderecos
Esta interface deve ter os seguintes métodos: 
- public String getStatus();
- public String getEndereco();
- public void setEndereco(String endereco);
- public String getCep();
- public void setCep(String cep);
- public String getCidade();
- public void setCidade(String cidade);
- public String getEstado();
-  public void setEstado(String estado);

4- Crie uma classe chamada Funcionarios
- Esta classe deve estender a classe Conexaoe implementar as interfaces Cadastros e Enderecos
- Os métodos desta classe devem ter apenas o corpo, isto sem código dentro. 