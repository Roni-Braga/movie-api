# Estágio 1: Configuração do ambiente de construção
FROM maven:3.8.4-openjdk-17 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /api

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências do Maven, mas não copia os arquivos do código-fonte ainda
RUN mvn dependency:go-offline

# Copia o restante do código-fonte para o diretório de trabalho
COPY src ./src

# Executa o comando Maven para compilar e construir o projeto
RUN mvn clean install -DskipTests

# Estágio 2: Configuração do ambiente de execução
FROM openjdk:17-jdk-slim AS runtime

# Define o diretório de trabalho dentro do contêiner
WORKDIR /api

# Copia o arquivo JAR construído a partir do estágio anterior para o diretório de trabalho
COPY --from=build api/target/api-0.0.1-SNAPSHOT.jar ./movie.jar

# Expor a porta 8080 para o tráfego externo
EXPOSE 8080

# Comando de entrada para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "movie.jar"]











