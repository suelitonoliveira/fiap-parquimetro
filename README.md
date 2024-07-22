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
- **GitActions:** Deploy automatizado integrando azure com git Actions

## 🚀 Iniciar

- É necessário ter um java 17 instalado e configurado na maquina e uma IDE para rodar o projeto localmente.
- Também é importante ter o docker instalado na maquina para poder rodar o docker-compose e criar um conteiner do postgres
- 
  <h2>📖 Executando Dcoker Compose</h2>
  Deve ser executado do arquivo docker-compose dentro da pasta fiap-parquimetro\src\main\resources\docker
- comando docker-compose up -d

<h2>📖 Conexão com o banco do Azure</h2>
SPRING_DATASOURCE_URL:jdbc:postgresql://fiap-pos-db.postgres.database.azure.com:5432/postgres
SPRING_DATASOURCE_USERNAME=posfiapcontainer  
SPRING_DATASOURCE_PASSWORD=Po@12345678

## 📖 Documentação-API

foi realizado a hospedagem no azure segue link do swagger:
//link local
http://localhost:8080/fiap-parquimetro/swagger-ui/index.html#/

- Segue o link do miro aonde mostramos todo os fluxos https://miro.com/app/board/uXjVKRr033s=/
- Collection postman: https://universal-crater-6079.postman.co/workspace/fiap~63b45161-f5be-4f39-8e20-86f482f27767/collection/13186621-a87c061a-dd3b-400c-90f7-17ed9dd6674d?action=share&creator=13186621
- swagger:https://fiap-pos-parquimetro.azurewebsites.net/fiap-parquimetro/swagger-ui/index.html#/


## 🤝 Integrantes

- ELIANE PEIXOTO

- PAULA CRISTINA NASCIMENTO GOMES

- VITOR MARTINS AVELINO DE CARVALHO

- VALTER NETTO

- SUELITON DE OLIVEIRA 

