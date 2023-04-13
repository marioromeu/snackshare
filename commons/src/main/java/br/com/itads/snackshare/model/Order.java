package br.com.itads.snackshare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	/**
	 * 
	 */
	private Map<String, Item> itemMap;
	
	/**
	 * 
	 */
	private List<Item> itemList;
	
//	/**
//	 * 
//	 * @return
//	 */
//	public List<Item> getItemList() {
//		itemList = new ArrayList<>();
//		for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
//			String key = entry.getKey();
//			Item val = entry.getValue();
//			itemList.add(val);
//		}
//		return itemList;
//	}
		
}
