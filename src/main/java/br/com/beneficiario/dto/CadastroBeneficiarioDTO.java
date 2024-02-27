package br.com.beneficiario.dto;

import java.time.LocalDate;
import java.util.List;

public class CadastroBeneficiarioDTO {
	
    private String nome;
	
	private String telefone;
	
	
	private LocalDate dataNascimento;
	
	private List<CadastroAtualizaDocumentoDTO> listDocumentoDTO;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<CadastroAtualizaDocumentoDTO> getListDocumentoDTO() {
		return listDocumentoDTO;
	}

	public void setListDocumentoDTO(List<CadastroAtualizaDocumentoDTO> listDocumentoDTO) {
		this.listDocumentoDTO = listDocumentoDTO;
	}

	

	
	
	

}
