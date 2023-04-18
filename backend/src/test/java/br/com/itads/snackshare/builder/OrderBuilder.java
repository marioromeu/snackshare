package br.com.itads.snackshare.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.com.itads.snackshare.controller.requests.SnackRequest;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.model.Item;
import br.com.itads.snackshare.model.Order;

/**
 * 
 * @author marioromeu
 * @email  mario.romeu@gmail.com
 *
 */
public class OrderBuilder {

	/**
	 * 
	 * @return
	 */
	public static final SnackRequest buildEmptySnackRequest() {
			
		Order order = OrderBuilder.buildEmptyOrder();
		
		SnackRequest snackRequest = 
				SnackRequest.builder()
							.order(order)
							.build();
		
		return snackRequest;
		
	}
	

	/**
	 * 
	 * @return
	 */
	public static final SnackResponse buildEmptySnackResponse(Order order) {
		
		List<Item> itemList = new ArrayList<Item>();
		
		for (Map.Entry<String, Item> entry : order.getItemMap().entrySet()) {
			itemList.add(entry.getValue());
			
		}
		
		ResponseDTO responseDTO =
				ResponseDTO.builder()
						   .itensList(itemList)
						   .sharedValueByOwner(0d)
						   .build();
		
		Map<String, ResponseDTO> sharedValue = new HashMap<String, ResponseDTO>();
		sharedValue.put(null, responseDTO);
		
		SnackResponse snackResponse = 
				SnackResponse.builder()
							.sharedValue(null)
							.build();
		
		return snackResponse;
		
	}	

	/**
	 * 
	 * @return
	 */
	public static final SnackRequest buildNormalSnackRequest() {

		Order order = OrderBuilder.buildNormalOrder();
		
		SnackRequest snackRequest = 
				SnackRequest.builder()
							.order(order)
							.build();
		
		return snackRequest;
		
	}	
	
	/**
	 * 
	 * @return
	 */
	public static final SnackResponse buildNormalSnackResponse() {

		SnackResponse snackResponse = 
				SnackResponse.builder()
							.sharedValue(null)
							.build();
		
		return snackResponse;
		
	}	

	/**
	 * 
	 * @return
	 */
	public static final Order buildEmptyOrder() {

		Map<String, Item> itemMap = new HashMap<String, Item>();
				
		Order order =
				Order.builder()
					 .itemMap(itemMap)
					 .build();
		
		return order;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static final Order buildNormalOrder() {

		Map<String, Item> itemMap = buildItemMap();
				
		Order order =
				Order.builder()
					 .itemMap(itemMap)
					 .build();
		
		return order;
		
	}		
	
	/**
	 * 
	 */
	public static final Map<String, Item> buildItemMap() {
		
		Map<String, Item> itemMap = new HashMap<String, Item>();

		String idItem1 = UUID.randomUUID().toString();
		Item item1 = 
				Item.builder()
					.id(idItem1)
					.name("Macarrão")
					.ownerEmail("mario.romeu@gmail.com")
					.signal(-1)//desconto de valor
					.value(20d)
					.build();
		itemMap.put(idItem1, item1);

		String idItem2 = UUID.randomUUID().toString();
		Item item2 = 
				Item.builder()
					.id(idItem2)
					.name("chocolate")
					.ownerEmail("beth.soares@gmail.com")
					.signal(-1)//desconto de valor
					.value(10d)
					.build();		
		itemMap.put(idItem2, item2);
		
		String idItem3 = UUID.randomUUID().toString(); 
		Item item3 = 
				Item.builder()
					.id(idItem3)
					.name("frete")
					.ownerEmail(null)
					.signal(-1)//desconto de valor
					.value(10d)
					.build();
		itemMap.put(idItem3, item3);
		
		String idItem4 = UUID.randomUUID().toString(); 
		Item item4 = 
				Item.builder()
					.id(idItem4)
					.name("cupon")
					.ownerEmail(null)
					.signal(1)//bônus de valor
					.value(8d)
					.build();
		itemMap.put(idItem4, item4);
		
		return itemMap;
		
	}

	/**
	 * 
	 * @return
	 */
	public static final List<Item> buildItemList() {
		
		Map<String, Item> itemMap = buildItemMap();
		
		List<Item> itemList = new ArrayList<Item>();
		
		for (Map.Entry<String, Item> entry : itemMap.entrySet()) {			
			Item item = entry.getValue();
			itemList.add(item);
		}
		
		return itemList;
	}
	
}
