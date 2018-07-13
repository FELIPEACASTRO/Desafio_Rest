package br.com.desafio.springrestdatah2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.springrestdatah2.model.Boleto;
import br.com.desafio.springrestdatah2.repository.BoletoRepository;

@RestController
@RequestMapping("/rest")
public class BoletoController {

	@Autowired
	private BoletoRepository boletoRepo;
	
	/*
	 * Listar todos os Boletos
	 */
	@RequestMapping(value = "/bankslips/list", method = RequestMethod.GET)
	public List<Boleto> findAll(){
		return boletoRepo.findAll();
	}

	/*
	 * Mostrar Detalhes do Boleto
	 */
	@RequestMapping(value = "/bankslips/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable final Long id){
		Boleto boleto = boletoRepo.findOne(id);
		if( boleto == null ){
			String msg = "{\"message\":\"Boleto with id " + id + " not found.\"}";
			return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Boleto>(boleto,HttpStatus.OK);
		}
	}
	
	/*
	 * Insere informações de Boleto
	 */
	@RequestMapping(value = "/bankslips", method = RequestMethod.POST)
	public ResponseEntity<Boleto> create(@RequestBody final Boleto boleto){
		boletoRepo.save(boleto);
		return new ResponseEntity<Boleto>(boletoRepo.findById(boleto.getId()),HttpStatus.CREATED);
			
	}
	
	/*
	 * Altera Informações de Boleto
	 */
	@RequestMapping(value = "/bankslips/{id}/pay", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Boleto boleto) {
		Boleto boletoData = boletoRepo.findOne(id);
        if (boletoData == null) {
        	String msg = "{\"message\":\"Boleto with id " + id + " not found.\"}";
            return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
        }
        boletoData.setStatus(boleto.getStatus());

        boletoRepo.save(boletoData);
        return new ResponseEntity<Boleto>(boletoData, HttpStatus.OK);
    }
	
	/*
	 * Excluir Boleto
	 */
	@RequestMapping(value = "/bankslips/{id}/cancel", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        Boleto boleto = boletoRepo.findOne(id);
        if (boleto == null) {
        	String msg = "{\"message\":\"Boleto with id " + id + " not found.\"}";
            return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
        }
        boletoRepo.delete(id);
        return new ResponseEntity<Boleto>(HttpStatus.NO_CONTENT);
    }
}
