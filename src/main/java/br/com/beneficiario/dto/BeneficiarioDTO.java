package br.com.beneficiario.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BeneficiarioDTO {

    private Long id;
	
	private String nome;
	
	private String telefone;
	
	private LocalDate dataNascimento;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAlteracao;
	
	private List<DocumentoDTO> listDocumentoDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public List<DocumentoDTO> getListDocumentoDTO() {
		return listDocumentoDTO;
	}

	public void setListDocumentoDTO(List<DocumentoDTO> listDocumentoDTO) {
		this.listDocumentoDTO = listDocumentoDTO;
	}

	
	
	
	
}
