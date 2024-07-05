<h1 align="center">🌟 SISTEMA DE PARQUÍMETRO  🌟</h1>

<h2>📋 SUMÁRIO</h2>

- [🔍 Visão Geral](#-VisãoGeral)
- [🏛️ Arquitetura ](#-Arquitetura )
- [🚀 Para startar o projeto](#-Iniciar)
- [📖 Documentação-API](#-Documentação-API)
- [🤝 Integrantes](#-Integrantes)

## 🔍 VisãoGeral
<p>
Projeto apresentado como requisito para conclusão da fase 02 do curso Arquitetura e desenvolvimento em Java, da Faculdade Fiap. 
O objetivo é de criar uma api para um "Sistema de parquímetro", com isso permitir o gerenciamento desse equipamento de uma maneira mais otimizada.
</p>

## 🏛️ Arquitetura

Em java 17 juntamente com o framework  spring boot entre outros citados nesse durante o projeto onde foi implementado toda a lógica de negócio, utilizamos alguns padrões de projeto como:


- **MVC :** onde o projeto é dividido em três camadas: a camada de interação do usuário (view), a camada de manipulação dos dados (model) e a camada de controle (controller).

- **Repository:** para abstrair a camada de acesso ao banco de dados.

- **DTO (Data Transfer Object)** padrão voltado para transferência de dados entre camadas de aplicação.

- **Padrão Mapper:** para transformar DTO´s em entidades e vice-versa.
- **Flyway:** Esse framework é muito utilizado para versionamento e gerenciamento de banco de dados.
- **Lombok:** Que é uma biblioteca que permite deixar o código mais limpo reduzindo o boilerplate por meio de anotações.
- **Banco de Dados Postgres:** Para vacilitar os testes em qualquer ambiente optamos por utilizar um banco de dados em memória
- **Docker:** Para rodar o banco de dados em conteiner.
- **Swagger:** Para documentação do sistema
- **Azure:** Como servidor cloud para deploy da aplicação

## 🚀 Iniciar

- É necessário ter um java 17 instalado e configurado na maquina e uma IDE para rodar o projeto localmente.
- Também é importante ter o docker instalado na maquina para poder rodar o docker-compose e criar um conteiner do postgres
- 
  <h2>📖 Executando Dcoker Compose</h2>
  Deve ser executado do arquivo docker-compose dentro da pasta fiap-parquimetro\src\main\resources\docker
- comando docker-compose up -d

<h2>📖 Conexão com o banco</h2>
spring.flyway.url=jdbc:postgresql://localhost:5432/parquimetroBD    
spring.flyway.user=postgres   
spring.flyway.password=123456

## 📖 Documentação-API

foi realizado a hospedagem no azure segue link do swagger:

- Segue o link do miro aonde mostramos todo os fluxos https://miro.com/app/board/uXjVKRr033s=/
- Collection postman:


## 🤝 Integrantes

- ELIANE PEIXOTO

- PAULA CRISTINA NASCIMENTO GOMES

- VITOR MARTINS AVELINO DE CARVALHO

- VALTER NETTO

- SUELITON DE OLIVEIRA 
