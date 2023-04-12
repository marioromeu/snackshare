package br.com.itads.snackshare.gateway.braspag.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.itads.snackshare.gateway.braspag.model.Customer;
import br.com.itads.snackshare.gateway.braspag.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * 
	{
	   "MerchantOrderId": "2017051002",
	   "Customer": {
	      "Name": "Nome do Comprador",
	      "Identity": "12345678909",
	      "IdentityType": "CPF",
	      "Email": "comprador@braspag.com.br",
	      "Birthdate": "1991-01-02",
	      "Address": {
	         "Street": "Alameda Xingu",
	         "Number": "512",
	         "Complement": "27 andar",
	         "ZipCode": "12345987",
	         "City": "São Paulo",
	         "State": "SP",
	         "Country": "BRA",
	         "District": "Alphaville"
	      },
	      "DeliveryAddress": {
	         "Street": "Alameda Xingu",
	         "Number": "512",
	         "Complement": "27 andar",
	         "ZipCode": "12345987",
	         "City": "São Paulo",
	         "State": "SP",
	         "Country": "BRA",
	         "District": "Alphaville"
	   },
	   "Payment": {
	      "ServiceTaxAmount": 0,
	      "Installments": 1,
	      "Interest": "ByMerchant",
	      "Capture": true,
	      "Authenticate": false,
	      "Recurrent": false,
	      "DoSplit":false,
	      "CreditCard": {
	         "CardNumber": "455187******0181",
	         "Holder": "Nome do Portador",
	         "ExpirationDate": "12/2021",
	         "SaveCard": false,
	         "Brand": "Visa"
	         "Alias": "",
	         "CardOnFile":{
	            "Usage": "Used",
	            "Reason":"Unscheduled"
	         }
	      },
	      "Credentials": {
	         "Code": "9999999",
	         "Key": "D8888888",
	         "Password": "LOJA9999999",
	         "Username": "#Braspag2018@NOMEDALOJA#"
	      },
	        "ProofOfSale": "20170510053219433",
	        "AcquirerTransactionId": "0510053219433",
	        "AuthorizationCode": "936403",
	        "SoftDescriptor": "Mensagem",
	        "VelocityAnalysis": {
	           "Id": "c374099e-c474-4916-9f5c-f2598fec2925",
	           "ResultMessage": "Accept",
	           "Score": 0
	        },
	        "PaymentId": "c374099e-c474-4916-9f5c-f2598fec2925",
	        "Type": "CreditCard",
	        "Amount": 10000,
	        "ReceivedDate": "2017-05-10 17:32:19",
	        "CapturedAmount": 10000,
	        "CapturedDate": "2017-05-10 17:32:19",
	        "Currency": "BRL",
	        "Country": "BRA",
	        "Provider": "Simulado",
	        "ExtraDataCollection": [{
	            "Name": "NomeDoCampo",
	            "Value": "ValorDoCampo"
	        }],
	        "ReasonCode": 0,
	        "ReasonMessage": "Successful",
	        "Payment.MerchantAdviceCode":"1",
	        "Status": 2,
	        "ProviderReturnCode": "6",
	        "ProviderReturnMessage": "Operation Successful",
	        "Links": [{
	                "Method": "GET",
	                "Rel": "self",
	                "Href": "https://apiquerysandbox.braspag.com.br/v2/sales/c374099e-c474-4916-9f5c-f2598fec2925"
	            },
	            {
	                "Method": "PUT",
	                "Rel": "void",
	                "Href": "https://apisandbox.braspag.com.br/v2/sales/c374099e-c474-4916-9f5c-f2598fec2925/void"
	            }
	        ]
	    }
	}
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrasPagResponseDTO {

	/**
	 * 
	 */
	private String merchantOrderId;

	/**
	 * 
	 */
	private Customer customer;
	
	/**
	 * 
	 */
	private Payment payment;	
	
}
