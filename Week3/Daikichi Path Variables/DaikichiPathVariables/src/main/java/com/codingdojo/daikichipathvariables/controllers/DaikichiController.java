package com.codingdojo.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // create new controller called DaikichiController and annotate it as a REST controller
@RequestMapping("/daikichi")
public class DaikichiController {

	
	@RequestMapping("")
	// Create an http GET request to localhost:8080/daikichi to display text: "welcome"
	public String daikichi() {
		return "Welcome!";
	}
	
	
	@RequestMapping("/today")
	public String today() {
		// Create http GET request to localhost:8080/daikichi/today to display text: 
		// "Today you will have luck in all your endeavors!"
		return "Today you will have luck in all your endeavors!";
	}

	@RequestMapping("/tomorrow") 
	public String tomorrow() {
		// Create http GET request to localhost:8080/daikichi/tomorrow to display text:
		// "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!"
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}	
		
	@RequestMapping("/travel/{destination}")
	public String travel(@PathVariable String destination) {
		return "Congratulations! You will soon travel to " + destination;
	}
	
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable int number) {
		
		if(number % 2 == 0) {
		return "<h1 style = color:blue>You will take a grand journey in the near future, but be weary of tempting offers</h1>";
		} 
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		// If the number is even, display text that says 'You will take a grand journey in the near future, but be weary of tempting offers'. 
		// If it is odd, display text that says "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."
		}
	}
}

