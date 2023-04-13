package br.com.itads.snackshare.gateway.brcode.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
@Service
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
	@Value("${snackshare.payments.pix.receiver.pix}")
	private String pix;

	/**
	 * 
	 */
	@Value("${snackshare.payments.brcode.url.service}")
	private String url;

	/**
	 * 
	 */
	private FileOutputStream outputStream;

	/**
	 * 
	 */
	@Override
	public String generatePaymentsLink(Double value) {	
		return url+"?nome="+name+"&cidade="+city+"&saida=qr&chave="+pix+"&valor="+value;
	}

	/**
	 * 
	 */
	@Override
	public RefundsResponse sendPaymentsOrder(RefundsDTO dto) {

		init(url);

		Map<String, Object> qrCodeMap = new HashMap<String, Object>();
		
		for (Map.Entry<String, ResponseDTO> entry : dto.getSharedValue().entrySet()) {
			String key = entry.getKey();
			ResponseDTO val = entry.getValue();

			String urlToQrCode = generatePaymentsLink(val.getSharedValueByOwner());
			
			File qrCode = null;
			
			try {
			
				byte[] byteArray = template.getForObject(urlToQrCode, byte[].class);
			
				qrCode = byteArrayConverterToQrCodeImage(byteArray);
			
			/**
			 * org.springframework.web.client.UnknownContentTypeException:
			 * Could not extract response: no suitable HttpMessageConverter found for response type [class java.lang.Object] 
			 * and content type [image/png]
			 */
			}catch (Exception e) {
				
				e.printStackTrace();

			}

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
	 * @param array
	 * @return
	 */
	private File byteArrayConverterToQrCodeImage(byte[] array) {

		File outputFile = null;
		
		try {
			
			outputFile = File.createTempFile("outputFile",".png");
			
			outputStream = new FileOutputStream(outputFile);

		    outputStream.write(array);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return outputFile;
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
