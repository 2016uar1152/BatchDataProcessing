package com.training.batch;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.training.bean.Product;

public class ProductItemProcessor implements ItemProcessor<Product, Product> {

	private static final Logger log = LoggerFactory.getLogger(ProductItemProcessor.class);
	public static long processCounter;

	@Override
	public Product process(final Product product) throws Exception {

		log.info("Started processing "+ processCounter++ +" from csv file..");

		if(product.getUpc().length()==0)
		{	
			log.info("1"); return null;
		} else {}

		if(product.getArtistId().length()>0 && product.getArtistId().length()<=7)
		{	
			product.setArtistId("ING"+product.getArtistId());
		} else
		{ 
			log.info("5"); return null;
		}

		if(product.getOrgId().length()==0)
		{	
			log.info("1"); return null;
		} else {}

		if(product.getReleaseDate().length()==8) {
			String releaseDate= verifyInput(product.getReleaseDate());
			if(releaseDate!=null) {
				log.info(releaseDate);
				product.setReleaseDate(releaseDate);
			} else {
				log.info("1"); return null;
			}
		} else if(product.getReleaseDate().length()==0) {
			LocalDate today= LocalDate.now();
			String s="";
			for(String i: today.toString().split("-")) {
				s+=i;
			}
			product.setReleaseDate( s );
		} else
		{	
			log.info("4"); return null;
		}

		return product;

	}

//	private static final java.text.SimpleDateFormat sdf = 
//			new java.text.SimpleDateFormat("yyyyMMdd");
//
//	public static LocalDate verifyInput(String input) {
//		try {
//			LocalDate ret = sdf.parse(input.trim());
//			if (sdf.format(ret).equals(input.trim())) return ret;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public static String verifyInput(String input) {
		String yyyy="";String mm="";String dd="";
		yyyy+=input.substring(0, 4);
		mm+=input.substring(4, 6);
		dd+=input.substring(6, 8);
		try {
			LocalDate.parse(yyyy+"-"+mm+"-"+dd);
			return input;
		}catch(DateTimeParseException e) {
			return null;
		}
	}

}