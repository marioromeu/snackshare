package br.com.itads.snackshare.gateway.braspag.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
	
	/**
	 * 
	 */
	private Integer qrCodeExpiration;
	
	/**
	 * 
	 */
    private String serviceTaxAmount;

	/**
	 * 
	 */
    private String provider;
	
	/**
	 * 
	 */    
    private String type;
	
	/**
	 * 
	 */    
    private Double amount;
	
	/**
	 * 
	 */    
    private String currency;
	
	/**
	 * 
	 */    
    private String country;
	
	/**
	 * 
	 */    
    private Integer installments;
	
	/**
	 * 
	 */    
    private String interest;
	
	/**
	 * 
	 */    
    private Boolean capture;
	
	/**
	 * 
	 */    
    private Boolean authenticate;
	
	/**
	 * 
	 */    
    private Boolean recurrent;
	
	/**
	 * 
	 */    
    private String softDescriptor;
	
	/**
	 * 
	 */    
    private Boolean doSplit;

	/**
	 * 
	 */
	private CreditCard creditCard;

	/**
	 * 
	 */
	private Credentials credentials;
	
	/**
	 * 
	 */
	private List<ExtraDataCollection> extraDataCollection;
	
	/**
	 * 
	 */    
    private String proofOfSale;

    /**
	 * 
	 */    
    private String acquirerTransactionId;


    /**
	 * 
	 */    
    private String authorizationCode;
    
    /**
 	 * 
 	 */    
     private String paymentId;

     /**
 	 * 
 	 */    
     private String receivedDate;

     /**
 	 * 
 	 */    
     private String capturedAmount;

     /**
 	 * 
 	 */    
     private String capturedDate;
     
     /**
 	 * 
 	 */    
     private String reasonCode;

     /**
 	 * 
 	 */    
     private String reasonMessage;

     /**
 	 * 
 	 */    
     private String merchantAdviceCode;

     /**
 	 * 
 	 */    
     private String status;

     /**
 	 * 
 	 */    
     private String providerReturnCode;

     /**
 	 * 
 	 */    
     private String providerReturnMessage;

}
