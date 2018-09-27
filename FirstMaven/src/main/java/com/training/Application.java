package com.training;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.training.module.App;

public class Application {

	public static void main(String[] args) {
		Gson obj = new Gson();
		BasicConfigurator.configure();
		Logger log = Logger.getRootLogger();
		Movie diamond = new Movie(101,"Diamond");
		String jsonRep = obj.toJson(diamond);
		
		log.info(jsonRep);
		
		Movie movie = obj.fromJson(jsonRep, Movie.class);
		
		log.info(movie.toString());

		log.info(App.getGreet());
		
	}

}
