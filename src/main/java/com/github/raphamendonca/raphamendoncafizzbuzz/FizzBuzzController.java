package com.github.raphamendonca.raphamendoncafizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping("fizzBuzz")
@RestController
@Validated
public class FizzBuzzController {

	@ApiOperation(value = "Obtain the list of the FizzBuzz numbers between 1 and 100")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FizzBuzz> listAllFizzBuzz() {
		return validateFizzBuzz(IntStream.range(0, 100).boxed().collect(Collectors.toList()));
	}

	@ApiOperation(value = "Check if a given number is Fizz, Buzz or FizzBuzz")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{number}")
	public List<FizzBuzz> checkFizzBuzz(
			@ApiParam(value = "Number check FizzBuzz")	 	
			@PathVariable("number") 
			List<Integer> numbers) {
		return validateFizzBuzz(numbers);
	}

	private List<FizzBuzz> validateFizzBuzz(List<Integer> numbers) {
		List<FizzBuzz> fizzBuzzList = new ArrayList<>();
		numbers.stream().forEach(number -> fizzBuzzList.add(new FizzBuzz(number)));
		return fizzBuzzList;	
	}

}
