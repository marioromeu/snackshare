package br.com.itads.snackshare.gateway.brcode.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public class BRCodeService extends PaymentsMethod {

	/**
	 * 
	 */
	@Value("${snackshare.payments.pix.receiver.name}")
	private String name;
	
	/**
	 * 
	 */
	@Value("${snackshare.payments.pix.receiver.city}")
	private String city;
	
	/**
	 * 
	 */
	@Value("${snackshare.payments.pix.receiver.pix-key}")
	private String pixKey;

	/**
	 * 
	 */
	@Value("${snackshare.payments.brcode.url.service}")
	private String url;	
	
	/**
	 * 
	 */
	public BRCodeService() {
		init(url);
	}
	
	/**
	 * 
	 */
	@Override
	public String generatePaymentsLink(Double value) {	
		//TODO colocar o preço
		return url+"?nome="+name+"&cidade="+city+"&saida=qr&chave="+pixKey;
	}

	/**
	 * 
	 */
	@Override
	public RefundsResponse sendPaymentsOrder(RefundsDTO dto) {
		
		Map<String, Object> qrCodeMap = new HashMap<String, Object>();
		
		for (Map.Entry<String, ResponseDTO> entry : dto.getSharedValue().entrySet()) {
			String key = entry.getKey();
			ResponseDTO val = entry.getValue();

			String urlToQrCode = generatePaymentsLink(val.getSharedValueByOwner());
			
			ResponseEntity<Object> qrCode = template.getForEntity(urlToQrCode, Object.class);

			qrCodeMap.put(key, qrCode);
			
		}

		RefundsResponse response = 
				RefundsResponse.builder()
							.qrCodeMap(qrCodeMap)
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
