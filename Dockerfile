# Estágio 1: Build (Compilação do código)
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copia os arquivos do Maven Wrapper primeiro para aproveitar o cache do Docker
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Dá permissão de execução para o mvnw (caso não tenha)
RUN chmod +x ./mvnw

# Copia o código-fonte
COPY src src

# Compila o projeto pulando os testes para ser mais rápido
RUN ./mvnw clean package -DskipTests

# Estágio 2: Execução (Imagem mais leve, apenas com o JRE)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o arquivo .jar gerado no estágio 1
COPY --from=build /app/target/*.jar app.jar

# Cria pastas para garantir que o banco H2 e as imagens tenham onde salvar
RUN mkdir database uploads

# Expõe a porta 8080 para acessarmos pelo navegador
EXPOSE 8080

# Comando que inicializa o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
