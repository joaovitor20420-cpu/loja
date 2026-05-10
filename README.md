# E-commerce Store (Loja)

Uma aplicação de E-commerce completa construída com Java, Spring Boot e Thymeleaf. Este projeto apresenta tanto a interface voltada para o cliente (storefront) quanto um painel administrativo completo (dashboard).

## 🚀 Tecnologias Utilizadas

### Back-end
- **Java 21**
- **Spring Boot 3.5.14**
- **Spring Web** (MVC)
- **Spring Data JPA** (Persistência)
- **H2 Database** (Banco de dados em memória)

### Front-end
- **Thymeleaf** (Template Engine)
- **HTML5 & CSS3** (Vanilla, CSS customizado responsivo)
- **JavaScript** (Vanilla)
- **FontAwesome** (Ícones)
- **Plus Jakarta Sans** (Google Fonts)

## 📋 Funcionalidades

### Área do Cliente (Storefront)
- **Catálogo de Produtos:** Listagem de produtos com filtros por categorias (Eletrônicos, Roupas, Casa e Jardim, etc).
- **Carrinho de Compras:** Adicionar, remover e visualizar itens no carrinho.
- **Checkout:** Finalização de compra intuitiva.
- **Autenticação:** Páginas de Login (Sign In) e Cadastro (Sign Up).
- **Modo Dark/Light:** Alternância de tema para melhor experiência do usuário.

### Painel Administrativo (Admin Dashboard)
- **Dashboard:** Visão geral com estatísticas de vendas, usuários e produtos.
- **Gestão de Produtos:** CRUD completo (Adicionar, Editar, Excluir, Listar).
- **Gestão de Usuários:** Controle de contas de usuários cadastrados e seus status (Ativo, Inativo, Bloqueado).
- **Gestão de Pedidos:** Acompanhamento de status de pedidos (Pendente, Pago, Enviado, Entregue).

## 🔧 Como Executar o Projeto

1. **Clone o repositório** (se aplicável):
   ```bash
   git clone <url-do-repositorio>
   cd loja
   ```

2. **Execute a aplicação utilizando o Maven Wrapper:**
   ```bash
   # No Windows:
   mvnw.cmd spring-boot:run

   # No Linux/Mac:
   ./mvnw spring-boot:run
   ```

3. **Acesse no Navegador:**
   - Página Inicial: [http://localhost:8080/](http://localhost:8080/)
   - Área Administrativa: [http://localhost:8080/admin](http://localhost:8080/admin)
   - Console do Banco H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 🗄️ Acesso ao Banco de Dados (H2 Console)

Durante o desenvolvimento, você pode visualizar e interagir com as tabelas do banco de dados em memória.
- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:ecommerce-db`
- **Username:** `sa`
- **Password:** *(deixe em branco)*

## 📂 Estrutura do Projeto

- `src/main/java/com/example/loja`: Contém as classes Java (Controllers, Entities, e Main Application).
- `src/main/resources/templates`: Contém as views em HTML integradas com Thymeleaf (`index.html`, `admin.html`, `checkout.html`, etc).
- `src/main/resources/static`: Contém os arquivos estáticos de estilização (`css/`) e scripts (`js/`).
- `src/main/resources/application.properties`: Configurações da aplicação e do banco de dados H2.

## 🤝 Contribuição

Sinta-se à vontade para realizar forks e enviar pull requests. Para grandes mudanças, por favor abra uma issue primeiro para discutirmos o que você gostaria de mudar.
