# Documentação de Arquitetura - Loja E-commerce

## 1. Visão Geral
Este documento descreve a arquitetura do projeto "Loja E-commerce", uma aplicação web monolítica desenvolvida com Java, Spring Boot e o padrão de design MVC (Model-View-Controller). A aplicação possui duas áreas principais: o Storefront (área pública do cliente) e o Admin Dashboard (painel administrativo).

## 2. Tecnologias Utilizadas
- **Linguagem:** Java 21
- **Framework Principal:** Spring Boot 3.5.14
- **Acesso a Dados:** Spring Data JPA / Hibernate
- **Banco de Dados (Dev/Test):** H2 Database (modo arquivo local)
- **Engine de Templates:** Thymeleaf
- **Front-end:** HTML5, CSS3, Vanilla JavaScript, FontAwesome 6
- **Gerenciador de Dependências:** Maven

## 3. Padrão Arquitetural: MVC (Model-View-Controller)
O projeto segue estritamente o padrão MVC para separação de responsabilidades:

### 3.1. Models (Camada de Domínio e Persistência)
Os modelos representam as entidades de negócios e são mapeados para tabelas de banco de dados usando anotações JPA (`@Entity`).
- `Product`: Entidade central contendo informações do produto (nome, descrição, preço, estoque, estado, imagem, categoria).
- `Category`: Enumeração que define as categorias de produtos disponíveis (Roupas, Eletrônicos, etc.) juntamente com ícones visuais para a UI.
- `ProductRepository`: Interface estendendo repositórios do Spring Data JPA (por inferência) para provisão de operações CRUD e buscas personalizadas, como `findByCategory`.

*Nota: Entidades adicionais (Usuários, Pedidos) estão planejadas, mas as rotas atuais de interface (Users, Orders) atuam como visões preparadas para futura integração.*

### 3.2. Controllers (Controladores)
Os controladores lidam com requisições HTTP, interagem com a camada de dados (Repositórios) e retornam a View apropriada processada pelo Thymeleaf.
- `ProductController`: Responsável pelo CRUD de Produtos, lógica de upload de imagens e filtragem por categorias.
- Controladores de Navegação (`HomeController`, `DashboardController`, `AdminController`, `CheckoutController`, `OrdersController`, `UsersController`, etc.): Atualmente gerenciam o roteamento e a injeção de atributos básicos no modelo visual (`Model`).

### 3.3. Views (Camada de Apresentação)
As visões são arquivos `.html` localizados em `src/main/resources/templates`, renderizados no lado do servidor via **Thymeleaf**.
- **Públicas:** `index.html`, `checkout.html`, `order-success.html`, `signin.html`, `signup.html`.
- **Administrativas:** `admin.html`, `dashboard.html`, `product.html`, `users.html`, `orders.html`.

A aplicação não utiliza frameworks CSS como Bootstrap ou Tailwind. Toda a estilização é feita através de arquivos CSS customizados em `src/main/resources/static/css`, focando em CSS Grid/Flexbox e suportando Dark/Light mode de forma nativa.

## 4. Fluxos de Dados
1. O usuário (cliente ou admin) faz uma requisição via navegador.
2. O `Controller` correspondente intercepta a requisição baseada na rota (`@GetMapping`, `@PostMapping`).
3. Se for uma requisição que exija dados (ex: listar produtos), o `Controller` chama o `Repository` injetado via `@Autowired`.
4. O `Repository` consulta o Banco de Dados H2.
5. Os dados são retornados ao `Controller`, que os anexa ao objeto `Model`.
6. O `Controller` retorna o nome do template Thymeleaf (`String`).
7. O Thymeleaf processa o HTML mesclando os dados do `Model` e envia o HTML final ao cliente.

## 5. Estratégia de Arquivos e Uploads
A aplicação suporta upload de imagens de produtos. O arquivo `WebConfig` é responsável por mapear o diretório raiz `./uploads/` para que as imagens sejam servidas estaticamente pelo Spring Boot. Quando um produto é salvo (`ProductController.saveProduct`), a imagem é copiada usando o pacote `java.nio.file` (NIO.2) para a pasta `uploads`.

## 6. Evolução e Próximos Passos (To-Do)
- Implementação de Entidades JPA para `User` (Usuários) e `Order` / `OrderItem` (Pedidos).
- Adição do Spring Security para proteger as rotas `/admin`, `/product` e as funcionalidades de `/checkout`.
- Migração do banco H2 para um SGBD relacional robusto (PostgreSQL/MySQL) para ambiente de produção, com gerenciamento de variáveis de ambiente.
