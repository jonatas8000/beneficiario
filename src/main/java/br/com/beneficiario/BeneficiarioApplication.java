package br.com.beneficiario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger beneficiarioApi", version = "1", description = "API desenvolvida para cadastro,atualização,consulta e exclusão de beneficiário"))
public class BeneficiarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioApplication.class, args);
	}

}
