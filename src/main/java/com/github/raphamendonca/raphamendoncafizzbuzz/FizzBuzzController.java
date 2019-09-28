package com.github.raphamendonca.raphamendoncafizzbuzz;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("fizzBuzz")
@RestController
public class FizzBuzzController {

	@GetMapping
	List<FizzBuzz> listAllFizzBuzz() {
		return generateFizzBuzz();
	}
	
	@Valid
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{number}")
	List<FizzBuzz> checkFizzBuzz(@PathVariable("number") List<Integer> numbers) {
		List<FizzBuzz> fizzBuzzList = new ArrayList<FizzBuzz>();

		for (Integer number : numbers) {
			fizzBuzzList.add(new FizzBuzz(number));
		}
		return fizzBuzzList;
	}

	private List<FizzBuzz> generateFizzBuzz() {
		List<FizzBuzz> fizzBuzzList = new ArrayList<FizzBuzz>();

		for (int number = 1; number <= 100; number++) {
			fizzBuzzList.add(new FizzBuzz(number));
		}
		return fizzBuzzList;
	}

}
