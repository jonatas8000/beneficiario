package br.com.beneficiario.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.beneficiario.dto.CadastroAtualizaDocumentoDTO;
import br.com.beneficiario.dto.DocumentoDTO;
import br.com.beneficiario.entity.Documento;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
	
	List<Documento> dtoToEntity(List<CadastroAtualizaDocumentoDTO> listDocumentoDTO);

	
	List<DocumentoDTO> entityToDto(List<Documento> listDocumento);
}
