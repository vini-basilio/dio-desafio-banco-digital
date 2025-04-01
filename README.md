# Criando um Banco Digital com Java e Orientação a Objetos

Este projeto é uma evolução do desafio proposto [neste repositório](https://github.com/falvojr/lab-banco-digital-oo/tree/master), focado na aplicação de conceitos basícos de Java e Orientação a Objetos (OOP). A implementação original foi aprimorada com melhorias que incluem o uso de bibliotecas populares, tratamento de exceções e melhor organização do código.

## 🔥 Melhorias Implementadas

### ✅ Adição do Lombok

A biblioteca Lombok foi integrada para simplificar a criação de getters, setters, construtores e outros métodos repetitivos. Isso melhora significativamente a legibilidade e manutenção do código, especialmente em bases extensas.

### ✅ Tratamento de Exceções

Foi adicionado suporte a exceções de tempo de execução (Runtime Exceptions), melhorando a robustez do sistema. Este tratamento garante que erros sejam identificados e tratados de forma adequada, considerando diferentes camadas da aplicação.

### ✅ Validações de Regras de Negócio

Implementação de regras de negócio para garantir consistência nas operações:

- Saques não podem exceder o saldo disponível.
- Depósitos e transferências devem seguir fluxos esperados.

### ✅ Organização e Encapsulamento

- **Responsabilidades Claras:** Recursos como a geração de números de contas foram transferidos da classe `Conta` para a classe `Banco`. Dessa forma, a instituição controla a criação e gestão de contas.
- **Encapsulamento:** Apenas o `Banco` pode acessar e modificar as contas. Movimentações foram centralizadas dentro da classe `Banco`, que atua como um controlador principal.

## 📁 Estrutura do Projeto

```
📦 BancoDigital
├── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   └── 📂 banco
│   │   │       ├── Banco.java
│   │   │       ├── 📂 cliente
│   │   │       │   └── Cliente.java
│   │   │       ├── 📂 conta
│   │   │       │   ├── iConta.java
│   │   │       │   ├── ContaPoupanca.java
│   │   │       │   └── ContaCorrente.java
│   │   │       ├── ContaCorrente.java
│   │   │       ├── ContaPoupanca.java
│   │   │       └── 📂 utils
│   │   │           ├── CadastroClientes.java
│   │   │           ├── OperancoesBancarias.java
│   │   │           └── OperancoesEnum.java
├── 📜 README.md
└── 📜 pom.xml
```

## 🚀 Tecnologias e Ferramentas

- **Java** (versão 23 ou superior)
- **Maven** (para gerenciamento de dependências)
- **Lombok** (para reduzir código boilerplate)

## 💡 Como Executar

1. Clone o repositório:

```
git clone <URL_DO_SEU_REPOSITORIO>
```

2. Instale as dependências com Maven:

```
mvn install
```

3. Compile e execute a aplicação:

```
mvn clean compile exec:java
```

## 📚 Referências

- [Repositório Original](https://github.com/falvojr/lab-banco-digital-oo/tree/master)
- [Documentação do Lombok](https://projectlombok.org/)

---

Feito com 💙 por [Vinícius B.]
