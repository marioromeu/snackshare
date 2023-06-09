package br.com.itads.snackshare.gateway.boleto.builder;

import java.util.Calendar;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.Itau;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.itads.snackshare.gateway.boleto.dto.BoletoDTO;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public class BoletoBuilder {

	/**
	 * 
	 */
	private BoletoBuilder() {
		
	}
	
	/**
	 * nossoNumeroECodDocumento
	 * @return
	 */
	public static GeradorDeBoleto generateGeradorDeBoleto(BoletoDTO dto) {

		Calendar date = Calendar.getInstance();

		Datas datas = Datas.novasDatas()
				.comDocumento(date)
				.comProcessamento(date);
		date.add(Calendar.DAY_OF_MONTH, 10);
		datas.comVencimento(date);

		Endereco enderecoBeneficiario = Endereco.novoEndereco()
				.comLogradouro("Av. Beira Mar, 000")  
				.comBairro("Ribeira")
				.comCep("00000-000")
				.comCidade("Salvador")
				.comUf("BA");

		//Quem emite o boleto
       Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                .comNomeBeneficiario("Mario Romeu")  
                .comAgencia("0000").comDigitoAgencia("0")  
                .comCodigoBeneficiario("00000")  
                .comDigitoCodigoBeneficiario("0")  
                .comNumeroConvenio("0000000")  
                .comCarteira("18")  
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("0000000")
       			.comDigitoNossoNumero("0");

		Endereco enderecoPagador = Endereco.novoEndereco()
				.comLogradouro(dto.getOwner().getHomeAddress().getStreetAdress())  
				.comBairro(dto.getOwner().getHomeAddress().getNeighborhood())  
				.comCep(dto.getOwner().getHomeAddress().getZipCode())  
				.comCidade(dto.getOwner().getHomeAddress().getCity())  
				.comUf(dto.getOwner().getHomeAddress().getState());  

		//Quem paga o boleto
		Pagador pagador = Pagador.novoPagador()  
				.comNome(dto.getOwner().getName())  
				.comDocumento(dto.getOwner().getDocument())
				.comEndereco(enderecoPagador);

		Banco banco = new Itau();  

		Boleto boleto = Boleto.novoBoleto()  
				.comBanco(banco)  
				.comDatas(datas)  
				.comBeneficiario(beneficiario)  
				.comPagador(pagador)  
				.comValorBoleto(dto.getValueByOwner())  
				.comNumeroDoDocumento("1234")  
				.comInstrucoes("Pagar a comida")  
				.comLocaisDePagamento("Internet");  

		return new GeradorDeBoleto(boleto);

	}

}
