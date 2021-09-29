package com.training.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.training.bean.Product;

public class PersonItemProcessor implements ItemProcessor<Product, Product> {

  private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public Product process(final Product product) throws Exception {
	  
	  log.info("Started processing the csv file..");
//    final String firstName = person.getCustId().toUpperCase();
//    final String lastName = person.getMobileNo().toUpperCase();
//
//    final Person transformedPerson = new Person(firstName, lastName);
//
//    log.info("Converting (" + person + ") into (" + transformedPerson + ")");

    return product;
  }

}