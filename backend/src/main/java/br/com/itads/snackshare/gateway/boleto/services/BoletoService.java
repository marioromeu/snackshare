package br.com.itads.snackshare.gateway.boleto.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.itads.snackshare.constants.SnackConstants;
import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;
import br.com.itads.snackshare.gateway.boleto.builder.BoletoBuilder;
import br.com.itads.snackshare.gateway.boleto.dto.BoletoDTO;
import br.com.itads.snackshare.model.Owner;
import br.com.itads.snackshare.services.interfaces.UserServiceInterface;
import br.com.itads.snackshare.util.FileUtils;

/**
 * @author marioromeu
 * @email mario.romeu@gmail.com
 */
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
		// TODO Auto-generated method stub
		return null;
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
			
			File boletoOutput = null;
			
			Owner owner = userService.getOwnerByKey(key);
			
			BoletoDTO boletoDto = 
					BoletoDTO.builder()
							 .owner(owner)
							 .valueByOwner(val.getSharedValueByOwner())
							 .build();
			
			GeradorDeBoleto gerador = BoletoBuilder.generateGeradorDeBoleto(boletoDto);
			
			try {

		        // Para gerar um boleto em PNG  
		        gerador.geraPNG(UUID.randomUUID()+".png");  

		        // Para gerar um array de bytes a partir de um PNG  
		        byte[] bPNG = gerador.geraPNG();				
			
		        boletoOutput = FileUtils.byteArrayConverterToQrCodeImage(
		        		bPNG,
						UUID.randomUUID().toString(),
						SnackConstants.PNG
				);

			}catch (Exception e) {
				
				e.printStackTrace();

			}

			boletoMap.put(key, boletoOutput);
			
		}

		RefundsResponse response = 
				RefundsResponse.builder()
							.qrCodeMap(boletoMap)
							.build();

		return response;		

	}

	/**
	 * 
	 */
	@Override
	public Object authenticate(Object dto) {
		// TODO Auto-generated method stub
		return null;
	}
  
}  

