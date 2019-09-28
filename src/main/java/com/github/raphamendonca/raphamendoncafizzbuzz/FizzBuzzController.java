package com.github.raphamendonca.raphamendoncafizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@GetMapping(value = "/")
	public List<FizzBuzz> listAllFizzBuzz() {
		return validateFizzBuzz(IntStream.range(0, 100).boxed().collect(Collectors.toList()));
	}

	@ApiOperation(value = "Check if a given number is Fizz, Buzz or FizzBuzz")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{number}")
	public List<FizzBuzz> checkFizzBuzz(
			@ApiParam(value = "Number to be FizzBuzz check")
			@NotEmpty(message = "The informed values must be a list of integers") 
			@PathVariable("number") 
			List<Integer> numbers) {
		return validateFizzBuzz(numbers);
	}

	private List<FizzBuzz> validateFizzBuzz(List<Integer> numbers) {
		List<FizzBuzz> fizzBuzzList = new ArrayList<>();
		numbers.stream().forEach(number -> fizzBuzzList.add(new FizzBuzz(number)));
		return fizzBuzzList;	
	}

	@ExceptionHandler
	public String numberFormatHandler(NumberFormatException ex) {
		return "It was informed a invalid parameter type";
	}

	@ExceptionHandler
	public String npeHandler(NullPointerException ex) {
		return "The list of parameteres, must not have and empty/null item";
	}

}
