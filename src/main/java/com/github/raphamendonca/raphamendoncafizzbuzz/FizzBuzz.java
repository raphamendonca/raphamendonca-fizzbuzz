package com.github.raphamendonca.raphamendoncafizzbuzz;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;

@ApiModel
public class FizzBuzz {

	@NotNull
	@Pattern(regexp = "^[0-9]*$")
	private int number;

	public FizzBuzz(Integer number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public String getValue() {
		StringBuilder output = new StringBuilder();
		
		Boolean isFizzBuzzed = Boolean.TRUE;
		if (number % 3 == 0) {
			output.append("Fizz");
			isFizzBuzzed = Boolean.FALSE;
		}
		if (number % 5 == 0) {
			output.append("Buzz");
			isFizzBuzzed = Boolean.FALSE;
		}
		if (Boolean.TRUE.equals(isFizzBuzzed)) {
			output.append(number);
		}
		
		return output.toString();
	}
	
}
