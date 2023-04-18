package br.com.itads.snackshare.tests.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.itads.snackshare.builder.RefundsBuilder;
import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.gateway.boleto.services.BoletoService;
import br.com.itads.snackshare.gateway.qrcode.services.BRCodeService;
import br.com.itads.snackshare.services.impl.RefundService;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@ExtendWith(SpringExtension.class)
public class RefundsServiceTest {

	/**
	 * 
	 */
	@InjectMocks
	RefundService service;

	/**
	 * 
	 */
	@Mock
	@Qualifier("BRCodeService")
	BRCodeService method1;

	/**
	 * 
	 */
	@Mock
	@Qualifier("BoletoService")
	BoletoService method2;	

	/**
	 * 
	 */
	@Test
	void whenProcessingPaymentMethodGeneratePixBrCode() {

		RefundsDTO dto = RefundsBuilder.buildRefundsDTO();

		RefundsResponse response = 
				RefundsResponse.builder()
							   .barCodeMap(null)
							   .qrCodeMap(null)
							   .build();
		
		when(service.generateRefundLinkForPixBRCode(dto)).thenReturn(response);
		
		assertDoesNotThrow(() -> service.generateRefundLinkForPixBRCode(dto) );

	}

	/**
	 * 
	 */
	@Test
	void whenProcessingPaymentMethodGenerateBoleto() {

		RefundsDTO dto = RefundsBuilder.buildRefundsDTO();

		assertDoesNotThrow(() -> service.generateRefundLinkForBoleto(dto) );

	}

	/**
	 * 
	 */
	@Test
	void whenProcessingPaymentMethodGenerateBoletoANDPixBrCode() {

		RefundsResponse refundsResponse = RefundsBuilder.buildRefundsResponse();  
		
		when(method1.sendPaymentsOrder(any())).thenReturn(refundsResponse);
		when(method2.sendPaymentsOrder(any())).thenReturn(refundsResponse);
		
		RefundsDTO dto = RefundsBuilder.buildRefundsDTO();

		assertDoesNotThrow(() -> service.generateRefundLink(dto) );

	}
	
}
