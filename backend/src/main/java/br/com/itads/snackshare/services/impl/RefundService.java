package br.com.itads.snackshare.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.PaymentsMethod;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Service
public class RefundService {

	/**
	 * 
	 */
	@Autowired
	@Qualifier("BRCodeService")
	private PaymentsMethod method1;

	/**
	 * 
	 */
	@Autowired
	@Qualifier("BoletoService")
	private PaymentsMethod method2;
	
	/**
	 * 
	 * Amostra de capacidades de uso de interfaces para abstrair a 
	 * implementacao do meio de pagamento, de forma a reduzir impactos
	 * a cada novo meio de pagamento incorporado à solução, desde que 
	 * respeita a interface PaymentsMethos. 
	 * 
	 * @param method
	 * @return
	 */
	public RefundsResponse generateRefundLink(RefundsDTO dto) {

		/**
		 * Implementacao de meio de pagamento via qrcode PIX
		 */
		RefundsResponse refundsResponse = generateRefundLinkForPixBRCode(dto);
		
		/**
		 * Implementacao de meio de pagamento via boleto bancario
		 */
		RefundsResponse refundsResponseTemp = generateRefundLinkForBoleto(dto);
		
		/**
		 * Uniao dos dois resultados
		 */
		refundsResponse.setBarCodeMap( refundsResponseTemp.getBarCodeMap());
		
		
		return refundsResponse;

	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public RefundsResponse generateRefundLinkForPixBRCode(RefundsDTO dto) {

		/**
		 * Implementacao de meio de pagamento via qrcode PIX
		 */
		RefundsResponse refundsResponse = method1.sendPaymentsOrder(dto);
		
		
		return refundsResponse;

	}
	
	/**
	 * 
	 * @param method
	 * @return
	 */
	public RefundsResponse generateRefundLinkForBoleto(RefundsDTO dto) {

		/**
		 * Implementacao de meio de pagamento via qrcode PIX
		 */
		RefundsResponse refundsResponse = method2.sendPaymentsOrder(dto);
		
		return refundsResponse;

	}	
	
}
