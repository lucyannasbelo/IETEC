package br.org.ietec.funcional;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;


public class TesteFuncional {

	@Test
	public void LoginNaoExiste() {
		try{
			Telas.casoTesteLoginNaoExistente();

		}catch(TimeoutException t){
			Assert.fail();		
		}

	}
	
	@Test
	public void AtualizarCarrinho() {
		try{
			Telas.casoTesteAtualizarCarrinho();

		}catch(TimeoutException t){
			Assert.fail();		
		}

	}
	
	@Test
	public void PesquisarProdutoQueNaoExiste() {
		try{
			Telas.casoTestePesquisaDeProdutoQueNaoExiste();

		}catch(TimeoutException t){
			Assert.fail();		
		}

	}
}
