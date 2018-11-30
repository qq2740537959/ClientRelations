package com.znsd.client.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {
	@Override
	public Date convert(String text) {
		Date date = null;
		try {
			if (text.indexOf("-") > 0) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				ParsePosition pos = new ParsePosition(0);
				date = new java.sql.Date(format.parse(text, pos).getTime());
			} else {
				DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				date = new java.sql.Date(format.parse(text).getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
