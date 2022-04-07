package com.gfl1987.wsmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodeParam(String text) { //metodo que define o padrao de decodificacao
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String textDate, Date defaultValue) { //metodo para converter a data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //formatacao da data 
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); //formatacao da hora
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}		
	}
}