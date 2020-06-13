package br.com.caelum.jdbc;

import java.util.Calendar;
import java.util.Date;

public class CalendarExemplo {
	
	public static void main(String[] args) {
		
		
		Date data = new Date();
		System.out.println("Date: " + data);
		
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("Calendar: " + calendar);
		
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, 45);
		
		System.out.println("Calendar +45 : " + calendar);
		
		Calendar horaVencimento = Calendar.getInstance();
		
		horaVencimento.add(Calendar.HOUR, 300);
		
		if (horaVencimento.before(Calendar.getInstance())) {
			// venceu
		} else {
			System.out.println("Não venceu");
			System.out.println("horaVencimento: " + horaVencimento);
		}
		
	}

}
