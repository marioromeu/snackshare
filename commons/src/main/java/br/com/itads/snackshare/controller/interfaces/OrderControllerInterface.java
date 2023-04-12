package br.com.itads.snackshare.controller.interfaces;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.itads.snackshare.controller.requests.RefundsRequest;
import br.com.itads.snackshare.controller.requests.SnackRequest;
import br.com.itads.snackshare.controller.responses.RefundsResponse;
import br.com.itads.snackshare.controller.responses.SnackResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface OrderControllerInterface extends BaseUrlInterface {

	/**
	 * 
	 * @param header
	 * @param body
	 * @return
	 */
	@Operation(summary = "Receives a request from FrontEnd", description = "", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))),

			@ApiResponse(responseCode = "504", description = "Gateway Timeout", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SnackResponse.class))) }
	)	
	@PostMapping(value = "/order", produces = { "application/json" }, consumes = {"application/json" })
	ResponseEntity<SnackResponse> processOrder(
			@RequestHeader(value = "header", required = true) MultiValueMap<String, String> header,
			@Parameter(in = ParameterIn.DEFAULT, description = "Request Body", required = true, schema = @Schema()) 
			@Valid 
			@RequestBody SnackRequest body);

	/**
	 * 
	 * @param header
	 * @param body
	 * @return
	 */
	@Operation(summary = "Delivery a Payment Method (QRCode for example) for each member of sharing group", description = "", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))),

			@ApiResponse(responseCode = "504", description = "Gateway Timeout", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RefundsResponse.class))) }
	)	
	@PostMapping(value = "/refunds", produces = { "application/json" }, consumes = {"application/json" })	
	ResponseEntity<RefundsResponse> getRefundMethod(
			@RequestHeader(value = "header", required = true) MultiValueMap<String, String> header,			
			@Parameter(in = ParameterIn.DEFAULT, description = "Request Body", required = true, schema = @Schema()) 
			@Valid 
			@RequestBody RefundsRequest body);	
	
}
