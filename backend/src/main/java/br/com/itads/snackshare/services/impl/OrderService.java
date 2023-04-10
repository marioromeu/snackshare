package br.com.itads.snackshare.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.itads.snackshare.constants.SnackConstants;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.dto.OrderDTO;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.model.Item;
import br.com.itads.snackshare.model.Order;
import br.com.itads.snackshare.services.interfaces.OrderServiceInterface;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 */
@Service
public class OrderService implements OrderServiceInterface {

	/**
	 * 
	 * @param dto
	 */
	public SnackResponse calculateSharedValueByOwner(OrderDTO dto) {
		
		SnackResponse response = SnackResponse.builder().build();

		Map<String, ResponseDTO> resultShared = separateItensByOwner(dto);
		
		Double totalValue = getTotalValueOfAllItens(resultShared);
		
		resultShared = applyDelivery(dto, resultShared, totalValue);
		
		resultShared = applyCupon(dto, resultShared, totalValue);
		
		response.setSharedValue(resultShared);
		
		return response;
		
	}
	

	/**
	 * 
	 * @param resultShared
	 * @return
	 */
	private Double getTotalValueOfAllItens(Map<String, ResponseDTO> resultShared) {

		Double totalValue = 0d;
		
		for (Map.Entry<String, ResponseDTO> entry : resultShared.entrySet()) {
			ResponseDTO val = entry.getValue();
			
			totalValue += val.getSharedValueByOwner();

		}
		
		return totalValue;
		
	}	
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	private Map<String, ResponseDTO> applyCupon(OrderDTO dto, Map<String, ResponseDTO> resultShared, Double totalValue) {
		
		applyExtraValue(dto, resultShared, totalValue, SnackConstants.CUPON);
		
		return resultShared;

	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	private Map<String, ResponseDTO> applyDelivery(OrderDTO dto, Map<String, ResponseDTO> resultShared, Double totalValue) {
		
		applyExtraValue(dto, resultShared, totalValue, SnackConstants.DELIVERY);
		
		return resultShared;
	}

	/**
	 * Apply an extra value (positive or negative) like (delivery or cupon of discount)
	 * 
	 * @param dto
	 * @param resultShared
	 * @param totalValue
	 * @param valueOfDelivery
	 */
	private void applyExtraValue(
			OrderDTO dto,
			Map<String, ResponseDTO> resultShared,
			Double totalValue,
			String valueType) {

		Double extraValue = 0d;
		
		for (Item item : dto.getOrder().getItemList()) {
			if (item.getName().equals(valueType)) {
				extraValue = (item.getValue() * item.getSignal());
			}
		}
		
		for (Map.Entry<String, ResponseDTO> entry : resultShared.entrySet()) {

			ResponseDTO val = entry.getValue();

			Double myBalance = val.getSharedValueByOwner();

			Double myPercent = myBalance / totalValue;

			val.setSharedValueByOwner( myBalance + (extraValue * myPercent) );

		}
	}

	/**
	 * 
	 * @return
	 */
	private Map<String, ResponseDTO> separateItensByOwner(OrderDTO dto) {
		
		Map<String, ResponseDTO> resultShared = new HashMap<String, ResponseDTO>();
		
		Order order = dto.getOrder();
				
		for (Item item : order.getItemList()) {
			
			if (item.getOwnerEmail() != null) {

				Double value = item.getValue();
				
				ResponseDTO dtoInternal = resultShared.get(item.getOwnerEmail()); 
				
				if (dtoInternal != null) {
	
					dtoInternal.getItensList().add(item);
					Double actualValue = dtoInternal.getSharedValueByOwner();
					dtoInternal.setSharedValueByOwner(actualValue + value );
					
				} else {
	
					ArrayList<Item> list = new ArrayList<Item>();
					list.add(item);
					
					dtoInternal = ResponseDTO.builder()
							.itensList(list)
							.sharedValueByOwner(item.getValue())
							.build();
				}
				
				resultShared.put(item.getOwnerEmail(), dtoInternal);
				
			} else {
				System.out.println("isso nao eh de ninguem.. ou eh frete ou eh cupom");
				System.out.println(item.toString());
			}

		}
		
		return resultShared;
		
	}
	
}
