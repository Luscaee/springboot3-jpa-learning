# Spring Boot 3 & JPA: API para Sistema de Pedidos

Este projeto é uma API RESTful quase completa desenvolvida com Spring Boot 3, modelando um sistema de e-commerce com entidades como Usuários, Produtos, Pedidos e Categorias. O foco principal é a implementação de um modelo de domínio complexo com relacionamentos JPA e a exposição de endpoints para manipulação desses dados.

Esta aplicação é um estudo prático e aprofundado dos conceitos de Spring Data JPA, Hibernate, relacionamentos entre entidades (`@OneToMany`, `@ManyToOne`, `@ManyToMany`), chaves primárias compostas e deploy em nuvem.

A aplicação foi implantada com sucesso na plataforma **Railway**, utilizando **Docker** para a conteinerização e **PostgreSQL** como banco de dados de produção.

## ✨ Modelo de Domínio

O projeto implementa um modelo de dados relacional robusto, incluindo:
* **Usuários (`User`):** Clientes que realizam pedidos.
* **Pedidos (`Order`):** Pedidos feitos por usuários, com status e itens associados.
* **Produtos (`Product`):** Itens que podem ser comprados.
* **Categorias (`Category`):** Categorias para organizar os produtos.
* **Itens de Pedido (`OrderItem`):** Representa a relação entre um Pedido e um Produto, incluindo quantidade e preço.
* **Pagamentos (`Payment`):** Associados a um Pedido.

## 🛠️ Tecnologias Utilizadas

* **Backend:**
    * [Java 21](https://www.oracle.com/java/technologies/javase/21-relnote-issues.html)
    * [Spring Boot 3](https://spring.io/projects/spring-boot)
    * [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
    * [Hibernate](https://hibernate.org/)
    * [Maven](https://maven.apache.org/)
* **Banco de Dados:**
    * [PostgreSQL](https://www.postgresql.org/)
* **Deploy:**
    * [Docker](https://www.docker.com/)
    * [Railway](https://railway.app/)
