package com.libraryApp;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class trial {
	public static void main(String[] args) {

		Date date = Date.from(LocalDate.now().plusDays(14).atStartOfDay().toInstant(ZoneOffset.UTC));
		System.out.println(date);
	}
}
