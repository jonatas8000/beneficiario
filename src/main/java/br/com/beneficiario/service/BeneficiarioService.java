package br.com.beneficiario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.beneficiario.dto.AtualizaBeneficiarioDTO;
import br.com.beneficiario.dto.BeneficiarioDTO;
import br.com.beneficiario.dto.CadastroAtualizaDocumentoDTO;
import br.com.beneficiario.dto.CadastroBeneficiarioDTO;
import br.com.beneficiario.entity.Beneficiario;
import br.com.beneficiario.entity.Documento;
import br.com.beneficiario.exception.BeneficiarioNaoEncontradoException;
import br.com.beneficiario.mapper.BeneficiarioMapper;
import br.com.beneficiario.mapper.DocumentoMapper;
import br.com.beneficiario.repository.BeneficiarioRepository;


@Service
@Transactional
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository; 
	
	@Autowired
	private BeneficiarioMapper beneficiarioMapper;
	
	@Autowired
	private DocumentoMapper documentoMapper;
	
	@Autowired
	private DocumentoService documentoService;
	
	public BeneficiarioDTO cadastrar(CadastroBeneficiarioDTO beneficiarioDTO) {
		Beneficiario beneficiario = beneficiarioMapper.dtoToEntity(beneficiarioDTO);
		return this.save(this.toBeneficiario(beneficiario,beneficiarioDTO.getListDocumentoDTO()));
	}

	public List<BeneficiarioDTO> buscarTodos(){
		 return beneficiarioRepository.findAll().stream().map(e->this.toBeneficiarioDTO(e)).toList();
		 
	}
	
	public BeneficiarioDTO atualizar(AtualizaBeneficiarioDTO beneficiarioDTO){
		Beneficiario beneficiario= this.buscarPorId(beneficiarioDTO.getId());
		documentoService.excluir(beneficiario.getListDocumento());
		
		Beneficiario beneficiarioAtualizado = beneficiarioMapper.dtoToEntity(beneficiarioDTO);
		beneficiarioAtualizado.setDataInclusao(beneficiario.getDataInclusao());
		
		
		return this.save(this.toBeneficiario(beneficiarioAtualizado,beneficiarioDTO.getListDocumentoDTO()));
	}
	
	public void excluir(Long id) {
		beneficiarioRepository.delete(this.buscarPorId(id));
	}
	
	private Beneficiario buscarPorId(Long id) {
		return beneficiarioRepository.findById(id).
				orElseThrow(()-> new BeneficiarioNaoEncontradoException("Beneficiario não encontrado"));
	}
	
	private BeneficiarioDTO save(Beneficiario beneficiario) {
		Beneficiario beneficiarioSalvo =beneficiarioRepository.save(beneficiario);
		beneficiarioRepository.flush();
		
		return this.toBeneficiarioDTO(beneficiarioSalvo);
	}
	
	private BeneficiarioDTO toBeneficiarioDTO(Beneficiario beneficiario) {
		BeneficiarioDTO beneficiarioDTO=beneficiarioMapper.entityToDto(beneficiario);
		beneficiarioDTO.setListDocumentoDTO(documentoMapper.entityToDto(beneficiario.getListDocumento()));
		
		return beneficiarioDTO;
	}
	
	private  Beneficiario toBeneficiario(Beneficiario beneficiario, List<CadastroAtualizaDocumentoDTO> listDocumentoDTO) {
		List<Documento> listDocumento = documentoMapper.dtoToEntity(listDocumentoDTO);
		listDocumento.stream().forEach(e->e.setBeneficiario(beneficiario));
		beneficiario.setListDocumento(listDocumento);
		
		return beneficiario;
	}
}
