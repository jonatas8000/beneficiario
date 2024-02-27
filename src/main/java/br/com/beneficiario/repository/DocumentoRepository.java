package br.com.beneficiario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.beneficiario.entity.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
	
	
	List<Documento> findByBeneficiario_id(Long idBeneficiario);

}
