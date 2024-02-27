package br.com.beneficiario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beneficiario.dto.AtualizaBeneficiarioDTO;
import br.com.beneficiario.dto.BeneficiarioDTO;
import br.com.beneficiario.dto.CadastroBeneficiarioDTO;
import br.com.beneficiario.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/beneficiario", produces = {"application/json"})
@Tag(name = "beneficiario-api")
public class BeneficiarioController {
	
	@Autowired
	private BeneficiarioService beneficiarioService;
	
	@Operation(summary = "Realiza cadastro de beneficiário", method = "POST")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado beneficiário"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar beneficiário"),
    })
	@PostMapping
	public ResponseEntity<BeneficiarioDTO>  cadastrar(@RequestBody CadastroBeneficiarioDTO beneficiarioDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioService.cadastrar(beneficiarioDTO));
	}
	
	@Operation(summary = "Busca de beneficiários", method = "GET")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busca feita com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar beneficiários"),
    })
	@GetMapping
	public ResponseEntity<List<BeneficiarioDTO>>  buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.buscarTodos());
	}
	
	@Operation(summary = "Realiza atualização de beneficiário", method = "PUT")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado beneficiário"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar beneficiário"),
    })
	@PutMapping
	public ResponseEntity<BeneficiarioDTO>  atualizar(@RequestBody AtualizaBeneficiarioDTO beneficiarioDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.atualizar(beneficiarioDTO));
	}

	@Operation(summary = "Realiza exclusão de beneficiário", method = "DELETE")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Excluído beneficiário"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao excluir beneficiário"),
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>  excluir(@PathVariable Long id) {
		beneficiarioService.excluir(id);
		return  new ResponseEntity<>(HttpStatus.OK); 
	}

}
