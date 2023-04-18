package br.com.itads.snackshare.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.dto.RefundsDTO;
import br.com.itads.snackshare.dto.ResponseDTO;
import br.com.itads.snackshare.model.Item;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public class RefundsBuilder {

	/**
	 * 
	 * @return
	 */
	public static final RefundsDTO buildRefundsDTO() {
				
		ResponseDTO responseDTO = buildResponseDTO();
		
		Map<String, ResponseDTO> sharedValue = new HashMap<String, ResponseDTO>();
		
		sharedValue.put("mario.romeu@gmail.com", responseDTO);
		
		RefundsDTO refundsDTO = 
				RefundsDTO.builder()
						  .sharedValue(sharedValue)
						  .build();
		
		return refundsDTO;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static final ResponseDTO buildResponseDTO() {
		
		List<Item> itemlist = OrderBuilder.buildItemList();
		
		
		ResponseDTO responseDTO =
				ResponseDTO.builder()
						   .itensList(itemlist)
						   .sharedValueByOwner(0d)
						   .build();
		
		return responseDTO;		
		
	}	

	/**
	 * 
	 * @return
	 */
	public static final RefundsResponse buildRefundsResponse() {

		Map<String, Object> qrCodeMap = buildQrCodeMap();
		
		Map<String, Object> barCodeMap = buildBarCodeMap();
		
		RefundsResponse response = 
				RefundsResponse.builder()
							   .barCodeMap(barCodeMap)
							   .qrCodeMap(qrCodeMap)
							   .build();

		return response;
	
	}
	
	/**
	 * 
	 * @return
	 */
	public static final Map<String, Object> buildQrCodeMap() {

		String arrayOfByte = "iVBORw0KGgoAAAANSUhEUgAAAQAAAAEAAQMAAABmvDolAAAABlBMVEX///8AAABVwtN+AAACwUlEQVR42uyZMY7sLBCECxEQcgRuYl/MMh75YvgmfQRCAuT61e3R7L73v9xYGkLvl8BUV1f34nu+54EnkGTBzA2ZO3sKpbnm9Gt9ECBAOFiA2LEkCmZM4aiAHwkgFYivugDoCXOb4GrmPhhQMMUzbmlLPenrtxGBo851tYfuKVDf/nGACeZErl6yeAaG8g9F3QtokR11UsGkXaz0pnD8VZs3A3aclh4AT0+WNv3P6m4G7GVPTFhjf6uap7597OMAQFCfLfHFnbt0sPBo7kcPDwFYQoF+WVKHlwayzTzjhqEAuDpXxw2elFBCCayOfRwgSJuvW8SOLBQSjmf83GIEANrFHFnXSFK8BIYzHGq8DwIC1eeqqysyt0Rp1pp5/ljx/QBSA6aoCtlFdU3ytJ9mHwkAeFRYyFmSlh1cQyR/BHM7oFbcZntqL4AXlnDwqLnmOg4gobxvoXromsMmIG6fhvIIgEBDPOPL/nylyTa9M/AogECFfNiMQ3mraIobhgLIpjGH1csC0jztjKwDAUihqCGoa5FEejtt/oTFJwBBbJRUO15STx1Nc7Am82UcQJsaj+qoSaxbwGlOQ85PvxgA0OJzLJHcRWfeUBrMH/ZxgCANFnKyhQONB1d+5EAAknaxOlcgmzu0GcDMV/VPAqApN2oS0zypXc/cJPPXEHQ7kEhMsUANwQuuldfMT1MbAQhidmBjbtK4GHTCUcvYxgFUAG22VUGWJamq7WvmkwAdgtTl9Jew6mThaWH9s8m5H3jvQHSoyeKJxGIGsv61JLkVuLZJZsVkR9c5/RrE/lh53QyIOkQssGmRXtTEQvmthxEAUoH4qkgbus5lerXzj433I4ArP2jkpflJm7AiDwaUaEuP1G0w57XH20cCbMF9Oe9iVoyrX/xW1N3AVXpHXeN+BcZi/6ZZHwV8z/cMdf4LAAD//wybaE7aVmJ1AAAAAElFTkSuQmCC";
		
		Map<String, Object> qrCodeMap = new HashMap<String, Object>();

		qrCodeMap.put("mario.romeu@gmail.com", arrayOfByte.toCharArray());
		
		return qrCodeMap;

	}

	/**
	 * 
	 * @return
	 */
	public static final Map<String, Object> buildBarCodeMap() {

		String arrayOfByte = "iVBORw0KGgoAAAANSUhEUgAAAQAAAAEAAQMAAABmvDolAAAABlBMVEX///8AAABVwtN+AAACwUlEQVR42uyZMY7sLBCECxEQcgRuYl/MMh75YvgmfQRCAuT61e3R7L73v9xYGkLvl8BUV1f34nu+54EnkGTBzA2ZO3sKpbnm9Gt9ECBAOFiA2LEkCmZM4aiAHwkgFYivugDoCXOb4GrmPhhQMMUzbmlLPenrtxGBo851tYfuKVDf/nGACeZErl6yeAaG8g9F3QtokR11UsGkXaz0pnD8VZs3A3aclh4AT0+WNv3P6m4G7GVPTFhjf6uap7597OMAQFCfLfHFnbt0sPBo7kcPDwFYQoF+WVKHlwayzTzjhqEAuDpXxw2elFBCCayOfRwgSJuvW8SOLBQSjmf83GIEANrFHFnXSFK8BIYzHGq8DwIC1eeqqysyt0Rp1pp5/ljx/QBSA6aoCtlFdU3ytJ9mHwkAeFRYyFmSlh1cQyR/BHM7oFbcZntqL4AXlnDwqLnmOg4gobxvoXromsMmIG6fhvIIgEBDPOPL/nylyTa9M/AogECFfNiMQ3mraIobhgLIpjGH1csC0jztjKwDAUihqCGoa5FEejtt/oTFJwBBbJRUO15STx1Nc7Am82UcQJsaj+qoSaxbwGlOQ85PvxgA0OJzLJHcRWfeUBrMH/ZxgCANFnKyhQONB1d+5EAAknaxOlcgmzu0GcDMV/VPAqApN2oS0zypXc/cJPPXEHQ7kEhMsUANwQuuldfMT1MbAQhidmBjbtK4GHTCUcvYxgFUAG22VUGWJamq7WvmkwAdgtTl9Jew6mThaWH9s8m5H3jvQHSoyeKJxGIGsv61JLkVuLZJZsVkR9c5/RrE/lh53QyIOkQssGmRXtTEQvmthxEAUoH4qkgbus5lerXzj433I4ArP2jkpflJm7AiDwaUaEuP1G0w57XH20cCbMF9Oe9iVoyrX/xW1N3AVXpHXeN+BcZi/6ZZHwV8z/cMdf4LAAD//wybaE7aVmJ1AAAAAElFTkSuQmCC";
		
		Map<String, Object> barCodeMap = new HashMap<String, Object>();

		barCodeMap.put("mario.romeu@gmail.com", arrayOfByte.toCharArray());
		
		return barCodeMap;

	}	
	
	
	
}
