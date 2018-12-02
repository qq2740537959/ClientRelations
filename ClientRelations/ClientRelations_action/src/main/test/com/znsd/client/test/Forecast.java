package com.znsd.client.test;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

public class Forecast {

	@Test
	public void test() {
		double d =(double) (400-380)/380*100;
		DecimalFormat df = new DecimalFormat("#.##");  
		System.out.println(df.format(d));
	}

}
