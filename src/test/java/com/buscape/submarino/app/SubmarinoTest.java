package com.buscape.submarino.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubmarinoTest {

	@InjectMocks
	private Submarino submarino;
	
	@Test
	public void submarinoTesteValido() {
		// GIVEN
		String entrada = "LMRDDMMUU";
		String saidaEsperada = "-1 2 0 NORTE";
		
		// WHEN
		String retorno = submarino.caulculaCoordenada(entrada);

		// THEN
		assertThat(retorno, notNullValue());
		assertThat(retorno, Matchers.is(Matchers.equalToIgnoringCase(saidaEsperada)));
	}
	
	@Test(expected = RuntimeException.class)
	public void submarinoTesteInvalido() {
		// GIVEN
		String entrada = "0000000";
		
		// WHEN
		submarino.caulculaCoordenada(entrada);
	}
	
	
	
}
