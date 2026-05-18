<div align="center">
  <img src="https://via.placeholder.com/800x200.png?text=E-commerce+Platform" alt="Loja E-commerce Banner">
  
  # 🛒 Plataforma de E-commerce (Loja)

  *Uma solução completa de comércio eletrônico desenvolvida com Java, Spring Boot e arquitetura MVC.*
  
  <p align="center">
    <a href="#-sobre-o-projeto">Sobre</a> •
    <a href="#-tecnologias-e-ferramentas">Tecnologias</a> •
    <a href="#%EF%B8%8F-arquitetura-e-padrões">Arquitetura</a> •
    <a href="#-funcionalidades-em-destaque">Funcionalidades</a> •
    <a href="#-como-executar-localmente">Como Executar</a> •
    <a href="#-contato">Contato</a>
  </p>

  ![Status Em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-green?style=for-the-badge)
  ![Licença MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
</div>

---

## 📖 Sobre o Projeto

Este projeto é uma **plataforma completa de E-commerce** desenvolvida do zero para demonstrar habilidades avançadas no ecossistema Java. A aplicação foi projetada para resolver problemas reais de lojas virtuais, dividindo-se em duas áreas principais:

1. **Storefront (Área do Cliente):** Interface amigável e intuitiva para navegação de produtos, carrinho de compras e checkout.
2. **Admin Dashboard (Painel Administrativo):** Um robusto sistema de gestão (CRM/ERP simplificado) que permite controle total sobre o inventário, pedidos e usuários.

> **💡 Foco para Recrutadores:** O código foi construído prezando pelas melhores práticas de engenharia de software, incluindo **Design Patterns**, **Separação de Responsabilidades (MVC)**, renderização do lado do servidor (SSR) otimizada para SEO e uma interface de usuário rica com responsividade.

## 🛠️ Tecnologias e Ferramentas

As ferramentas foram escolhidas a dedo, refletindo o que há de mais moderno e demandado no mercado corporativo atual:

### ⚙️ Back-end
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
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
- **Models (Entities):** Mapeamento Objeto-Relacional (ORM) estruturado com Hibernate/JPA.
- **Controllers:** Orquestração de requisições HTTP, tratamento de validações e integração com a camada de serviços.
- **Views (Thymeleaf):** Renderização de páginas dinâmicas no servidor, favorecendo tempo de resposta e segurança de dados críticos.

---

## 📁 Estrutura de Pastas (Padrão MVC)

A organização do código foi cuidadosamente estruturada para facilitar a manutenção e a escalabilidade, separando claramente as responsabilidades (Model, View e Controller):

```text
📦 loja
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java/com/example/loja
 ┃ ┃ ┃ ┣ 📜 Product.java              <-- 🔵 MODEL (Entidade JPA - Produto)
 ┃ ┃ ┃ ┣ 📜 Category.java             <-- 🔵 MODEL (Enum de Categorias EN/pt-BR)
 ┃ ┃ ┃ ┣ 📜 ProductRepository.java    <-- 🔵 REPOSITORY (Acesso ao Banco de Dados)
 ┃ ┃ ┃ ┣ 📜 ProductController.java    <-- 🟢 CONTROLLER (CRUD de Produtos)
 ┃ ┃ ┃ ┣ 📜 HomeController.java       <-- 🟢 CONTROLLER (Página Inicial)
 ┃ ┃ ┃ ┣ 📜 AdmimController.java      <-- 🟢 CONTROLLER (Painel Admin)
 ┃ ┃ ┃ ┣ 📜 DashboarController.java   <-- 🟢 CONTROLLER (Dashboard)
 ┃ ┃ ┃ ┣ 📜 UsersController.java      <-- 🟢 CONTROLLER (Usuários)
 ┃ ┃ ┃ ┣ 📜 OrdersController.java     <-- 🟢 CONTROLLER (Pedidos)
 ┃ ┃ ┃ ┣ 📜 CheckoutController.java   <-- 🟢 CONTROLLER (Checkout)
 ┃ ┃ ┃ ┣ 📜 OrderSuccessController.java <-- 🟢 CONTROLLER (Confirmação de Pedido)
 ┃ ┃ ┃ ┣ 📜 SignInController.java      <-- 🟢 CONTROLLER (Login)
 ┃ ┃ ┃ ┣ 📜 SignUpController.java      <-- 🟢 CONTROLLER (Cadastro)
 ┃ ┃ ┃ ┣ 📜 WebConfig.java             <-- ⚙️ CONFIG (Recursos Estáticos / Uploads)
 ┃ ┃ ┃ ┗ 📜 LojaApplication.java      <-- Setup Inicial (Spring Boot Application)
 ┃ ┃ ┃
 ┃ ┃ ┣ 📂 resources
 ┃ ┃ ┃ ┣ 📂 static                    <-- Arquivos Estáticos (CSS e JS)
 ┃ ┃ ┃ ┃ ┣ 📂 css                    <-- Estilos da Aplicação
 ┃ ┃ ┃ ┃ ┗ 📂 js                     <-- Scripts JavaScript
 ┃ ┃ ┃ ┣ 📂 templates                 <-- 🟡 VIEWS (Páginas Thymeleaf)
 ┃ ┃ ┃ ┃ ┣ 📜 index.html             <-- 🟡 VIEW (Catálogo da Loja)
 ┃ ┃ ┃ ┃ ┣ 📜 product.html           <-- 🟡 VIEW (Gestão de Produtos - CRUD)
 ┃ ┃ ┃ ┃ ┣ 📜 admin.html             <-- 🟡 VIEW (Painel Administrativo)
 ┃ ┃ ┃ ┃ ┣ 📜 dashboard.html         <-- 🟡 VIEW (Dashboard Admin)
 ┃ ┃ ┃ ┃ ┣ 📜 users.html             <-- 🟡 VIEW (Gestão de Usuários)
 ┃ ┃ ┃ ┃ ┣ 📜 orders.html            <-- 🟡 VIEW (Gestão de Pedidos)
 ┃ ┃ ┃ ┃ ┣ 📜 checkout.html          <-- 🟡 VIEW (Tela de Compra)
 ┃ ┃ ┃ ┃ ┣ 📜 order-success.html     <-- 🟡 VIEW (Confirmação de Pedido)
 ┃ ┃ ┃ ┃ ┣ 📜 signin.html            <-- 🟡 VIEW (Login)
 ┃ ┃ ┃ ┃ ┗ 📜 signup.html            <-- 🟡 VIEW (Cadastro)
 ┃ ┃ ┃ ┗ 📜 application.properties    <-- Configurações (Conexão do Banco H2)
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
- Listagem de produtos em grid responsivo com ícones por categoria
- Filtro visual de produtos por categoria (botões categóricos)
- Botões de "Adicionar ao Carrinho" e "Ver Detalhes" por produto
- Menu de navegação com links para Home, Produtos e Meus Pedidos
- Dropdown de perfil com opções de Login, Cadastro, Área Administrativa e Logout
- Seção de carrinho de compras com resumo, tabela de itens e mensagem de carrinho vazio

### 🔐 Autenticação (`signin.html` / `signup.html`)
- Tela de **Login** com validação de senha, toggle de visibilidade, "Lembrar de mim" e "Esqueceu a senha?"
- Tela de **Cadastro** com campos de nome, sobrenome, e-mail, telefone, senha e confirmação
- Requisitos de senha exibidos em tempo real (8+ caracteres, maiúscula, número, caractere especial)
- Login social com Google e Facebook (layout preparado)
- Aceite de Termos de Uso, Política de Privacidade e opção de newsletter
- Painel decorativo lateral com destaques da loja

### 💳 Checkout e Confirmação (`checkout.html` / `order-success.html`)
- Resumo do pedido com detalhes do cliente, total de itens e valor
- Método de pagamento via PIX com QR Code
- Tabela de itens do pedido com preço unitário, quantidade e subtotal
- Tela de sucesso com confirmação visual, número do pedido e próximos passos

### 📊 Dashboard Administrativo (Gestão)
- **CRUD Completo de Produtos:** ✅ Totalmente funcional — Criar, Listar, Editar e Excluir produtos com persistência no banco de dados H2 via Spring Data JPA.
  - **Create:** Formulário dinâmico para cadastro de novos produtos (nome, categoria, preço, status, quantidade e descrição).
  - **Upload de Imagens:** Suporte a upload de arquivos de imagem (`MultipartFile`), com salvamento em diretório local (`uploads/`) e pré-visualização dinâmica.
  - **Read:** Listagem em tabela com todos os produtos cadastrados, com busca e filtro por categoria.
  - **Update:** Edição inline — ao clicar em "Editar", o formulário é preenchido automaticamente com os dados do produto selecionado.
  - **Delete:** Exclusão com confirmação do navegador para evitar remoções acidentais.
- **Categorias Dinâmicas:** Enum `Category` com nomes em inglês e descrições em pt-BR, carregadas automaticamente nos selects via `Category.values()`.
- **Controle de Usuários:** Formulário de cadastro/edição, tabela com listagem, filtro por status (Ativo, Inativo, Bloqueado, Suspenso) e confirmação de exclusão.
- **Gestão de Pedidos:** Tabela com ID, cliente, total de itens, valor, status, método de pagamento e data. Filtro por status (Pendente, Confirmado, Pago, Enviado, Entregue, Cancelado).
- **Métricas e Dashboards:** Cards informativos (Total de Produtos, Usuários, Pedidos, Receita), lista de pedidos recentes e ranking de produtos mais vendidos.
- **Sidebar de Navegação:** Menu lateral com links ativos para Dashboard, Produtos, Pedidos e Usuários.

### 🎨 Interface & UX
- Design moderno com tipografia **Plus Jakarta Sans** (Google Fonts)
- Ícones **Font Awesome 6.4** em toda a aplicação
- Alternância de tema **claro/escuro** com toggle persistente
- Layout responsivo com grid CSS
- 4 arquivos CSS especializados: `styles.css`, `admin.css`, `auth.css`, `order-success.css`
- 3 arquivos JS especializados: `main.js`, `admin.js`, `auth.js`

---

## 🗺️ Mapa de Rotas

| Rota | Controller | Página | Descrição |
| :--- | :--- | :--- | :--- |
| `GET /` | `HomeController` | `index.html` | Vitrine da loja com catálogo de produtos |
| `GET /product` | `ProductController` | `product.html` | CRUD de produtos (admin) |
| `POST /product/save` | `ProductController` | — | Salvar/atualizar produto |
| `GET /product/edit/{id}` | `ProductController` | `product.html` | Editar produto existente |
| `GET /product/delete/{id}` | `ProductController` | — | Excluir produto |
| `GET /admin` | `AdmimController` | `admin.html` | Painel administrativo completo |
| `GET /dashboard` | `DashboarController` | `dashboard.html` | Dashboard com métricas |
| `GET /orders` | `OrdersController` | `orders.html` | Gestão de pedidos |
| `GET /users` | `UsersController` | `users.html` | Gestão de usuários |
| `GET /signin` | `SignInController` | `signin.html` | Tela de login |
| `GET /signup` | `SignUpController` | `signup.html` | Tela de cadastro |
| `GET /checkout` | `CheckoutController` | `checkout.html` | Finalizar compra |
| `GET /order-success` | `OrderSuccessController` | `order-success.html` | Pedido confirmado |

---

## 🚀 Como Executar Localmente

Siga o passo a passo abaixo para rodar a aplicação em seu ambiente:

### 1. Pré-requisitos
- **Java 21** (ou superior) instalado e configurado no seu PATH.
- Git instalado.

### 2. Passo a Passo

```bash
# Clone este repositório
git clone https://github.com/seu-usuario/seu-repositorio-loja.git

# Acesse o diretório do projeto
cd loja

# Execute a aplicação via Maven Wrapper (sem necessidade de instalar o Maven globalmente)

# 💻 No Windows:
mvnw.cmd spring-boot:run

# 🐧/🍏 No Linux/Mac:
./mvnw spring-boot:run
```

### 3. Acessando a Aplicação
Após alguns segundos, o servidor Tomcat embutido iniciará. Acesse:

| Ambiente | URL |
| :--- | :--- |
| **Loja Virtual (Público)** | [http://localhost:8080/](http://localhost:8080/) |
| **Painel Admin** | [http://localhost:8080/admin](http://localhost:8080/admin) |
| **Console H2 (Banco)** | [http://localhost:8080/h2-console](http://localhost:8080/h2-console) |

> **Acesso ao Banco H2 (Em Memória):**  
> **JDBC URL:** `jdbc:h2:mem:ecommerce-db` | **User:** `sa` | **Password:** *(deixe em branco)*

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

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/seu-perfil/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/seu-usuario)
[![E-mail](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:seu-email@gmail.com)

---
<p align="center">
  <i>Desenvolvido com foco na qualidade e melhores práticas de Engenharia de Software.</i>
</p>
