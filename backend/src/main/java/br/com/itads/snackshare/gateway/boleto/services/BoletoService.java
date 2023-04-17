package br.com.itads.snackshare.gateway.boleto.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;
import br.com.itads.snackshare.gateway.boleto.builder.BoletoBuilder;
import br.com.itads.snackshare.gateway.boleto.dto.BoletoDTO;
import br.com.itads.snackshare.model.Owner;
import br.com.itads.snackshare.services.interfaces.UserServiceInterface;

/**
 * @author marioromeu
 * @email mario.romeu@gmail.com
 */
@Service("BoletoService")
public class BoletoService extends PaymentsMethod {

	/**
	 * 
	 */
	@Autowired
	private UserServiceInterface userService;
	
	/**
	 * 
	 */
	@Override
	public String generatePaymentsLink(Double value) {
		throw new NotImplementedException();
	}

	/**
	 * 
	 */
	@Override
	public RefundsResponse sendPaymentsOrder(RefundsDTO dto) {

		Map<String, Object> boletoMap = new HashMap<String, Object>();
		
		for (Map.Entry<String, ResponseDTO> entry : dto.getSharedValue().entrySet()) {
			String key = entry.getKey();
			ResponseDTO val = entry.getValue();
			
			Owner owner = userService.getOwnerByKey(key);
			
			BoletoDTO boletoDto = 
					BoletoDTO.builder()
							 .owner(owner)
							 .valueByOwner(val.getSharedValueByOwner())
							 .build();
			
			GeradorDeBoleto gerador = BoletoBuilder.generateGeradorDeBoleto(boletoDto);
			
			byte[] bPNG = null;
			
			try {

		        // Para gerar um boleto em PNG  
		        gerador.geraPNG(UUID.randomUUID()+".png");  

		        // Para gerar um array de bytes a partir de um PNG  
		        bPNG = gerador.geraPNG();				

			}catch (Exception e) {
				
				e.printStackTrace();

			}

			//boletoMap.put(key, boletoOutput);
			boletoMap.put(key, bPNG);
			
		}

		RefundsResponse response = 
				RefundsResponse.builder()
							.barCodeMap(boletoMap)
							.build();

		return response;		

	}

	/**
	 * 
	 */
	@Override
	public Object authenticate(Object dto) {
		throw new NotImplementedException();
	}
  
}  

