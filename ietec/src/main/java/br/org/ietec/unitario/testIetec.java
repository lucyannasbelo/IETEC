package br.org.ietec.unitario;

public class testIetec {
	    public static String diaSemana(int dia) {
	        final int DIAS_NA_SEMANA = 7;
	        final String[] diasDaSemana = { "", "Domingo", "Segunda", "Terca",
	                "Quarta", "Quinta", "Sexta", "Sabado" };

	        if (dia < 1 || dia > DIAS_NA_SEMANA) {
	           return ("O dia da semana deve estar entre 1 e "
	                    + DIAS_NA_SEMANA);
	        }
	        else
	        {
	        return(diasDaSemana[dia]);
	        }
	    }
}
