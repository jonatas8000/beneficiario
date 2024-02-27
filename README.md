# Beneficiario

# Tecnologias
Java 17, spring-boot, spring-data-jpa, banco de dados h2, mapper struct

# Camadas
entity, mapper, dto, service, repository, controller

# Explicando a aplicação
Foi criado um api rest com Spring boot para cadastro, atualização, consulta e exclusão de beneficiário. Foi criado duas controllers uma para beneficiário e outra para documento para receber as requests. Na camada service fica as regras de negócios. A camada de repository é responsável por persistência e consulta o banco de dados. Os DTOs são para não expor as entidades, então as requests e responses serão enviado e retornado um DTO, o mapper tem a responsabilidade de converter DTO em entidade e entidade para DTO.

# Como executar a aplicação
Após fazer git clone, executar mvn clean e depois mvn install, então subi aplicação e acessar a seguinte url "http://localhost:8080/swagger-ui/index.html" então já será possível fazer request para os endpoints.
