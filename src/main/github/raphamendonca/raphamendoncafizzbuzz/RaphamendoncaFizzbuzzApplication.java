package com.github.raphamendonca.raphamendoncafizzbuzz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaphamendoncaFizzbuzzApplicationTests {

	private MockMvc mock;
	private FizzBuzzTest fizzBuzzTest;

	@InjectMocks
	private FizzBuzzController fizzBuzzController;

	@Before
	public void setudp() throws Exception {
		mock = MockMvcBuilders.standaloneSetup(fizzBuzzController).build();
		fizzBuzzTest = new FizzBuzzTest();
	}

	class FizzBuzzTest {
		public int number;
		public String value;
	}

	@Test
	public void test_list_fizz_buzz() throws Exception {
		mock.perform(get("/fizzBuzz/")).andExpect(status().isOk());
	}

	@Test
	public void test_check_error_fizz_buzz() throws Exception {
		mock.perform(get("/fizzBuzz/B")).andExpect(status().isBadRequest());
	}

	@Test
	public void test_check_number() throws Exception {
		mock.perform(get("/fizzBuzz/1")).andExpect(status().isOk());
	}

	@Test
	public void test_check_fizz() throws Exception {
		fizzBuzzTest.number = 3;
		fizzBuzzTest.value = "Fizz";

		mock.perform(get("/fizzBuzz/3")).andExpect(status().isOk());
	}

	@Test
	public void test_check_buzz() throws Exception {
		fizzBuzzTest.number = 5;
		fizzBuzzTest.value = "Buzz";

		mock.perform(get("/fizzBuzz/5")).andExpect(status().isOk());
	}

	@Test
	public void test_check_fizzBuzz() throws Exception {
		fizzBuzzTest.number = 15;
		fizzBuzzTest.value = "FizzBuzz";
		
		mock.perform(get("/fizzBuzz/15"))
			.andExpect(status().isOk());
	}

}
