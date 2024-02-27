package br.com.beneficiario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beneficiario.dto.DocumentoDTO;
import br.com.beneficiario.entity.Documento;
import br.com.beneficiario.mapper.DocumentoMapper;
import br.com.beneficiario.repository.DocumentoRepository;

@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private DocumentoMapper documentoMapper;
	
	
	public List<DocumentoDTO> buscarPorBeneficiario(Long idBeneficiario){
		return documentoMapper.entityToDto(documentoRepository.findByBeneficiario_id(idBeneficiario));
	}
	
	public void excluir(List<Documento> lisDocumentos) {
		documentoRepository.deleteAll(lisDocumentos);
	}

}
