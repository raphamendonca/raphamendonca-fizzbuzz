package com.github.raphamendonca.raphamendoncafizzbuzz;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
		StringBuffer output = new StringBuffer();

		Boolean isFizzBuzzed = Boolean.TRUE;
		if (number % 3 == 0) {
			output.append("Fizz");
			isFizzBuzzed = Boolean.FALSE;
		}
		if (number % 5 == 0) {
			output.append("Buzz");
			isFizzBuzzed = Boolean.FALSE;
		}
		if (isFizzBuzzed) {
			output.append(number);
		}
		return output.toString();
	}
	
}
