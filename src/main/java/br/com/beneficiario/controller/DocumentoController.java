package br.com.beneficiario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.beneficiario.dto.DocumentoDTO;
import br.com.beneficiario.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/documento", produces = {"application/json"})
@Tag(name = "documento-api")
public class DocumentoController {

	@Autowired
	private DocumentoService documentoService;
	
	
	@Operation(summary = "Busca de documento por id de beneficiário", method = "GET")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busca feita com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar documentos"),
    })
	@GetMapping("/beneficiario/{idBeneficiario}")
	public ResponseEntity<List<DocumentoDTO>> buscarPorBeneficiario(@PathVariable Long idBeneficiario){
		return ResponseEntity.status(HttpStatus.OK).body(documentoService.buscarPorBeneficiario(idBeneficiario));
	}
}
