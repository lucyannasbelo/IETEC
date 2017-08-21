package br.org.ietec.unitario;

import static org.junit.Assert.*;

import org.junit.Test;

import br.org.ietec.unitario.testIetec;

public class TesteU {

	@Test
	public void testeEquivalencia() {
		int diaValido = 2;
		int diaInvalido = 9;
		assertTrue("Dia válido está ok", testIetec.diaSemana(diaValido).equals("Terca"));
		assertTrue("Dia inválido está ok", testIetec.diaSemana(diaInvalido).equals("O dia da semana deve estar entre 1 e 7"));
	}
	
	@Test
	public void testeValorLimite() {
		int diaInvalidoInicial = 0;
		int diaValidoInicial = 1;
		int diaValidoFinal = 7;
		int diaInvalidoFinal = 8;
		assertTrue("Dia válido está ok", testIetec.diaSemana(diaValidoInicial).equals("Domingo"));
		assertTrue("Dia inválido está ok", testIetec.diaSemana(diaInvalidoInicial).equals("O dia da semana deve estar entre 1 e 7"));
		assertTrue("Dia válido está ok", testIetec.diaSemana(diaValidoFinal).equals("Sabado"));
		assertTrue("Dia inválido está ok", testIetec.diaSemana(diaInvalidoFinal).equals("O dia da semana deve estar entre 1 e 7"));
	}

}
