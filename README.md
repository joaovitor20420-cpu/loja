<div align="center">
  <img src="https://via.placeholder.com/800x200.png?text=Suburbio+Store" alt="Loja E-commerce Banner">
  
  # 🛒 Suburbio Store - Plataforma de E-commerce

  *Uma solução completa de comércio eletrônico desenvolvida com Java, Spring Boot e arquitetura MVC.*
  
  <p align="center">
    <a href="#-sobre-o-projeto">Sobre</a> •
    <a href="#-tecnologias-e-ferramentas">Tecnologias</a> •
    <a href="#%EF%B8%8F-arquitetura-e-padrões">Arquitetura</a> •
    <a href="#-funcionalidades-em-destaque">Funcionalidades</a> •
    <a href="#-como-executar-localmente">Como Executar</a> •
    <a href="#-contato">Contato</a>
  </p>

  ![Status Concluído](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
  ![Licença MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
</div>

---

## 📖 Sobre o Projeto

Este projeto é uma **plataforma completa de E-commerce** desenvolvida do zero para demonstrar habilidades avançadas no ecossistema Java. A aplicação foi projetada para resolver problemas reais de lojas virtuais, dividindo-se em duas áreas principais:

1. **Storefront (Área do Cliente):** Interface amigável e intuitiva para navegação de produtos, carrinho de compras e checkout.
2. **Admin Dashboard (Painel Administrativo):** Um robusto sistema de gestão (CRM/ERP simplificado) protegido sob a rota `/admin`, que permite controle total sobre o inventário, pedidos e usuários.

> **💡 Foco para Recrutadores:** O código foi construído prezando pelas melhores práticas de engenharia de software, incluindo **Design Patterns**, **Separação de Responsabilidades (MVC)**, renderização do lado do servidor (SSR) otimizada para SEO, Autenticação Segura (Google OIDC) e uma interface de usuário rica com responsividade.

## 🛠️ Tecnologias e Ferramentas

As ferramentas foram escolhidas a dedo, refletindo o que há de mais moderno e demandado no mercado corporativo atual:

### ⚙️ Back-end
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-4479A1?style=for-the-badge&logo=database&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

### 🎨 Front-end
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Font Awesome](https://img.shields.io/badge/Font_Awesome-339AF0?style=for-the-badge&logo=fontawesome&logoColor=white)

---

## 🏗️ Arquitetura e Padrões

O projeto adota de forma estrita a arquitetura **MVC (Model-View-Controller)**, garantindo um código limpo, testável e de fácil manutenção:
- **Models (Entities):** Mapeamento Objeto-Relacional (ORM) estruturado com Hibernate/JPA, explorando recursos de validação e Enums (`@Enumerated(EnumType.STRING)`, `@Column(unique=true)`).
- **Controllers:** Orquestração de requisições HTTP, tratamento de validações e integração com a camada de serviços. Agrupamento seguro de rotas sob `/admin`.
- **Views (Thymeleaf):** Renderização de páginas dinâmicas no servidor, favorecendo tempo de resposta e segurança de dados críticos.
- **Security (OIDC/OAuth2):** Serviço customizado (`CustomOidcUserService`) para integrar o login do Google ao banco de dados relacional e promover administradores com base no e-mail.

---

## 📁 Estrutura de Pastas (Padrão MVC)

A organização do código foi cuidadosamente estruturada para facilitar a manutenção e a escalabilidade, separando claramente as responsabilidades (Model, View e Controller):

```text
📦 loja
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java/com/example/loja
 ┃ ┃ ┃ ┣ 📂 config
 ┃ ┃ ┃ ┃ ┣ 📜 AdminSeeder.java          <-- ⚙️ CONFIG (Injeção da Chave Mestra / Admin)
 ┃ ┃ ┃ ┃ ┣ 📜 SecurityConfig.java       <-- ⚙️ CONFIG (Segurança de Rotas e OAuth2)
 ┃ ┃ ┃ ┃ ┣ 📜 SwaggerConfig.java        <-- ⚙️ CONFIG (Documentação OpenAPI)
 ┃ ┃ ┃ ┃ ┗ 📜 WebConfig.java            <-- ⚙️ CONFIG (Recursos Estáticos / Uploads)
 ┃ ┃ ┃ ┣ 📂 controllers
 ┃ ┃ ┃ ┃ ┣ 📜 AdmimController.java      <-- 🟢 CONTROLLER (Página Raiz do Admin)
 ┃ ┃ ┃ ┃ ┣ 📜 CheckoutController.java   <-- 🟢 CONTROLLER (Checkout)
 ┃ ┃ ┃ ┃ ┣ 📜 DashboarController.java   <-- 🟢 CONTROLLER (Dashboard /admin)
 ┃ ┃ ┃ ┃ ┣ 📜 HomeController.java       <-- 🟢 CONTROLLER (Página Inicial)
 ┃ ┃ ┃ ┃ ┣ 📜 OrderSuccessController.java <-- 🟢 CONTROLLER (Confirmação)
 ┃ ┃ ┃ ┃ ┣ 📜 OrdersController.java     <-- 🟢 CONTROLLER (Pedidos /admin)
 ┃ ┃ ┃ ┃ ┣ 📜 ProductController.java    <-- 🟢 CONTROLLER (Produtos /admin)
 ┃ ┃ ┃ ┃ ┣ 📜 SignInController.java     <-- 🟢 CONTROLLER (Login)
 ┃ ┃ ┃ ┃ ┣ 📜 SignUpController.java     <-- 🟢 CONTROLLER (Cadastro)
 ┃ ┃ ┃ ┃ ┗ 📜 UsersController.java      <-- 🟢 CONTROLLER (Usuários /admin)
 ┃ ┃ ┃ ┣ 📂 models
 ┃ ┃ ┃ ┃ ┣ 📜 Category.java             <-- 🔵 MODEL (Enum de Categorias)
 ┃ ┃ ┃ ┃ ┣ 📜 Product.java              <-- 🔵 MODEL (Entidade JPA)
 ┃ ┃ ┃ ┃ ┗ 📜 User.java                 <-- 🔵 MODEL (Entidade JPA)
 ┃ ┃ ┃ ┣ 📂 repositories
 ┃ ┃ ┃ ┃ ┣ 📜 ProductRepository.java    <-- 🔵 REPOSITORY (Acesso Produtos)
 ┃ ┃ ┃ ┃ ┗ 📜 UserRepository.java       <-- 🔵 REPOSITORY (Acesso Usuários)
 ┃ ┃ ┃ ┣ 📂 security
 ┃ ┃ ┃ ┃ ┣ 📜 CustomOidcUserService.java<-- 🔐 SECURITY (Integração Google OIDC DB)
 ┃ ┃ ┃ ┃ ┣ 📜 CustomUserDetails.java    <-- 🔐 SECURITY (Detalhes do Usuário Logado)
 ┃ ┃ ┃ ┃ ┗ 📜 CustomUserDetailsService.java <-- 🔐 SECURITY (Login Manual)
 ┃ ┃ ┃ ┣ 📂 services
 ┃ ┃ ┃ ┃ ┗ 📜 ProductService.java       <-- 🟠 SERVICE (Regras de Negócio e Uploads)
 ┃ ┃ ┃ ┗ 📜 LojaApplication.java        <-- Setup Inicial
 ┃ ┃ ┃
 ┃ ┃ ┣ 📂 resources
 ┃ ┃ ┃ ┣ 📂 static                    <-- Arquivos Estáticos (CSS e JS)
 ┃ ┃ ┃ ┃ ┣ 📂 css                    
 ┃ ┃ ┃ ┃ ┗ 📂 js                     
 ┃ ┃ ┃ ┣ 📂 templates                 <-- 🟡 VIEWS (Páginas Thymeleaf)
 ┃ ┃ ┃ ┃ ┣ 📜 index.html             <-- 🟡 VIEW (Catálogo da Loja)
 ┃ ┃ ┃ ┃ ┣ 📜 admin.html             <-- 🟡 VIEW (Raiz do Painel Administrativo)
 ┃ ┃ ┃ ┃ ┣ 📜 dashboard.html         <-- 🟡 VIEW (Admin - Dashboard)
 ┃ ┃ ┃ ┃ ┣ 📜 product.html           <-- 🟡 VIEW (Admin - Gestão de Produtos)
 ┃ ┃ ┃ ┃ ┣ 📜 orders.html            <-- 🟡 VIEW (Admin - Pedidos)
 ┃ ┃ ┃ ┃ ┣ 📜 users.html             <-- 🟡 VIEW (Admin - Usuários)
 ┃ ┃ ┃ ┃ ┣ 📜 checkout.html          <-- 🟡 VIEW (Tela de Compra)
 ┃ ┃ ┃ ┃ ┣ 📜 order-success.html     <-- 🟡 VIEW (Confirmação de Pedido)
 ┃ ┃ ┃ ┃ ┣ 📜 signin.html            <-- 🟡 VIEW (Login)
 ┃ ┃ ┃ ┃ ┗ 📜 signup.html            <-- 🟡 VIEW (Cadastro)
 ┃ ┃ ┃ ┗ 📜 application.properties    <-- Configurações
 ┣ 📜 pom.xml                         <-- Gerenciador de Dependências (Maven)
 ┗ 📜 README.md                       <-- Documentação do Projeto
```

---

## ✨ Funcionalidades em Destaque

### 🛍️ Storefront (Experiência do Usuário)
- **Catálogo Dinâmico:** Navegação fluida com filtros categóricos (Eletrônicos, Vestuário, etc.).
- **Gestão de Carrinho:** Adição, edição de quantidade e remoção de itens com atualização intuitiva.
- **Tema Personalizado:** Suporte nativo completo a **Dark Mode / Light Mode** na interface visual.
- **Mobile-First:** Design completamente responsivo e agradável para dispositivos móveis, tablets e web.

### 🏠 Página Inicial (`index.html`)
- Hero section com chamada para ação e título dinâmico via Thymeleaf
- Listagem de produtos em grid responsivo com imagens servidas do banco
- Filtro visual de produtos por categoria (botões categóricos)
- Menu de navegação e dropdown de perfil integrado com o Spring Security

### 🔐 Autenticação (`signin.html` / `signup.html`)
- Tela de **Login** com validação de senha, "Lembrar de mim" e "Esqueceu a senha?"
- Tela de **Cadastro** com campos de nome, e-mail, senha e verificação de e-mails duplicados
- **Login social com Google (OIDC):** Sincronização automática com o banco de dados e atribuição dinâmica de perfis (User/Admin).
- Requisitos de senha exibidos em tempo real

### 💳 Checkout e Confirmação (`checkout.html` / `order-success.html`)
- Resumo do pedido com detalhes do cliente, total de itens e valor
- Método de pagamento via PIX com QR Code
- Tela de sucesso com confirmação visual e número do pedido

### 📊 Dashboard Administrativo (Gestão em `/admin`)
- **Blindagem Completa:** Todas as rotas restritas via `hasAuthority('ROLE_ADMIN')` no `SecurityConfig`.
- **CRUD Completo de Produtos:** ✅ Totalmente funcional — Criar, Listar, Editar e Excluir produtos com persistência no banco de dados H2 via Spring Data JPA.
  - **Create:** Formulário dinâmico para cadastro de novos produtos.
  - **Upload de Imagens:** Suporte a upload de arquivos de imagem (`MultipartFile`), com salvamento em diretório local (`uploads/`).
  - **Read:** Listagem em tabela com busca e filtro por categoria.
  - **Update:** Edição inline de produtos.
  - **Delete:** Exclusão com confirmação do navegador.
- **Categorias Dinâmicas:** Enum `Category` com nomes em inglês e descrições em pt-BR.
- **Controle de Usuários e Pedidos:** Listagens robustas com métricas integradas na visão de Dashboard.

### 🎨 Interface & UX
- Design moderno e luxuoso (foco Streetwear)
- Ícones **Font Awesome 6.4** em toda a aplicação
- Alternância de tema claro/escuro nativa
- 4 arquivos CSS especializados: `styles.css`, `admin.css`, `auth.css`, `order-success.css`

---

## 🗺️ Mapa de Rotas Atualizado

| Rota | Controller | Acesso | Descrição |
| :--- | :--- | :--- | :--- |
| `GET /` | `HomeController` | Público | Vitrine da loja com catálogo de produtos |
| `GET /signin` | `SignInController` | Público | Tela de login (Manual e Google OAuth2) |
| `GET /signup` | `SignUpController` | Público | Tela de cadastro |
| `GET /checkout` | `CheckoutController` | Público | Finalizar compra |
| `GET /order-success` | `OrderSuccessController`| Público | Pedido confirmado |
| `GET /admin` | `AdmimController` | **`ADMIN`** | Página raiz do painel administrativo |
| `GET /admin/dashboard` | `DashboarController` | **`ADMIN`** | Dashboard com métricas globais |
| `GET /admin/products` | `ProductController` | **`ADMIN`** | CRUD de produtos |
| `POST /admin/products/save` | `ProductController` | **`ADMIN`** | Salvar/atualizar produto com imagem |
| `GET /admin/orders` | `OrdersController` | **`ADMIN`** | Gestão de pedidos efetuados |
| `GET /admin/users` | `UsersController` | **`ADMIN`** | Gestão da base de clientes |

---

## 🚀 Como Executar Localmente

Siga o passo a passo abaixo para rodar a aplicação em seu ambiente:

### 1. Pré-requisitos
- **Java 21** (ou superior) instalado e configurado no seu PATH.
- Git instalado.

### 2. Passo a Passo

```bash
# Clone este repositório
git clone https://github.com/joaovitor20420/loja.git

# Acesse o diretório do projeto
cd loja

# Execute a aplicação via Maven Wrapper (sem necessidade de instalar o Maven globalmente)

# 💻 No Windows:
.\mvnw.cmd spring-boot:run

# 🐧/🍏 No Linux/Mac:
./mvnw spring-boot:run
```

### 3. Acessando a Aplicação
Após alguns segundos, o servidor Tomcat embutido iniciará. Acesse:

| Ambiente | URL |
| :--- | :--- |
| **Loja Virtual (Público)** | [http://localhost:8080/](http://localhost:8080/) |
| **Painel Admin** | [http://localhost:8080/admin/dashboard](http://localhost:8080/admin/dashboard) |
| **📚 Documentação da API (Swagger)** | [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) |
| **Console H2 (Banco)** | [http://localhost:8080/h2-console](http://localhost:8080/h2-console) |

> **Acesso ao Banco H2 (Persistente):**  
> **JDBC URL:** `jdbc:h2:file:./database/ecommerce-db` | **User:** `sa` | **Password:** *(deixe em branco)*

---

## 📸 Demonstração Visual

*(Sugestão: Substitua os placeholders abaixo pelas capturas de tela reais do seu projeto para impressionar quem visita seu repositório)*

<table>
  <tr>
    <td align="center"><strong>Visão da Loja Virtual</strong></td>
    <td align="center"><strong>Painel Administrativo</strong></td>
  </tr>
  <tr>
    <td><img src="https://via.placeholder.com/450x280.png?text=Insira+Print+da+Loja+Aqui" alt="Loja"></td>
    <td><img src="https://via.placeholder.com/450x280.png?text=Insira+Print+do+Admin+Aqui" alt="Admin Dashboard"></td>
  </tr>
</table>

---

## 📞 Contato

Gostou da forma como desenvolvo? Estou disponível para novas oportunidades, sinta-se à vontade para me contatar:

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joaovitor/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/joaovitor20420)
[![E-mail](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:joaovitor20420@gmail.com)

---
<p align="center">
  <i>Desenvolvido com foco na qualidade e melhores práticas de Engenharia de Software.</i>
</p>
