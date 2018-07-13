package br.com.desafio.springrestdatah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.desafio.springrestdatah2.model.Boleto;

@Component
public interface BoletoRepository extends JpaRepository<Boleto, Long>{

	public Boleto findById(Long id);
	
}
