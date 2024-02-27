package br.com.beneficiario.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.beneficiario.dto.AtualizaBeneficiarioDTO;
import br.com.beneficiario.dto.BeneficiarioDTO;
import br.com.beneficiario.dto.CadastroBeneficiarioDTO;
import br.com.beneficiario.entity.Beneficiario;


@Mapper(componentModel = "spring")
public interface BeneficiarioMapper {
	
	

	Beneficiario dtoToEntity(CadastroBeneficiarioDTO beneficiarioDTO);
	
	Beneficiario dtoToEntity(AtualizaBeneficiarioDTO beneficiarioDTO);
	
	
	BeneficiarioDTO entityToDto(Beneficiario beneficiario);
	
	List<BeneficiarioDTO> entityToDto(List<Beneficiario> listBeneficiario);
	
	

}
