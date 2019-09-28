package com.github.raphamendonca.raphamendoncafizzbuzz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

	@InjectMocks
	private FizzBuzzController fizzBuzzController;
	
	@Before
	public void setup() throws Exception {
		mock = MockMvcBuilders.standaloneSetup(fizzBuzzController).build();
	}

//	class FizzBuzzTest {
//		public int number;
//		public String value;
//	}

	@Test
	public void test_list_fizz_buzz() throws Exception {
		mock.perform(get("/fizzBuzz/"))
		.andExpect(status().isOk());
		
	}

	@Test
	public void test_check_error_fizz_buzz() throws Exception {
		mock.perform(get("/fizzBuzz/B")).andExpect(status().isBadRequest());
	}

	@Test
	public void test_check_number() throws Exception {
		mock.perform(get("/fizzBuzz/1"))
		.andExpect(status().isOk())
		.andExpect(content().json("[{\"number\":1,\"value\":\"1\"}]"));
	}

	@Test
	public void test_check_fizz() throws Exception {
		mock.perform(get("/fizzBuzz/3"))
		.andExpect(status().isOk())
		.andExpect(content().json("[{\"number\":3,\"value\":\"Fizz\"}]"));
	}

	@Test
	public void test_check_buzz() throws Exception {
		mock.perform(get("/fizzBuzz/5"))
		.andExpect(status().isOk())
		.andExpect(content().json("[{\"number\":5,\"value\":\"Buzz\"}]"));
	}

	@Test
	public void test_check_fizzBuzz() throws Exception {
		mock.perform(get("/fizzBuzz/15"))
		.andExpect(status().isOk())
		.andExpect(content().json("[{\"number\":15,\"value\":\"FizzBuzz\"}]"));;
	}
	
	@Test
	public void test_check_list() throws Exception {
		mock.perform(get("/fizzBuzz/15,11,5,7,3"))
		.andExpect(status().isOk())
		.andExpect(content(
				).json("[{\"number\":15,\"value\":\"FizzBuzz\"},"
					  + "{\"number\":11,\"value\":\"11\"},"
					  + "{\"number\":5,\"value\":\"Buzz\"},"
					  + "{\"number\":7,\"value\":\"7\"},"
					  + "{\"number\":3,\"value\":\"Fizz\"}]"));
	}

	@Test
	public void test_fizz() throws Exception {
		assertTrue("Fizz".equals(new FizzBuzz(3).getValue()));
		assertTrue("Fizz".equals(new FizzBuzz(9).getValue()));
		assertFalse("Fizz".equals(new FizzBuzz(5).getValue()));
		assertFalse("Fizz".equals(new FizzBuzz(15).getValue()));
		assertFalse("Fizz".equals(new FizzBuzz(13).getValue()));
	}

	@Test
	public void test_buzz() throws Exception {
		assertTrue("Buzz".equals(new FizzBuzz(5).getValue()));
		assertTrue("Buzz".equals(new FizzBuzz(25).getValue()));
		assertFalse("Buzz".equals(new FizzBuzz(3).getValue()));
		assertFalse("Buzz".equals(new FizzBuzz(15).getValue()));
		assertFalse("Buzz".equals(new FizzBuzz(13).getValue()));
	}

	@Test
	public void test_fizzBuzz() throws Exception {
		assertTrue("FizzBuzz".equals(new FizzBuzz(15).getValue()));
		assertTrue("FizzBuzz".equals(new FizzBuzz(75).getValue()));
		assertFalse("FizzBuzz".equals(new FizzBuzz(3).getValue()));
		assertFalse("FizzBuzz".equals(new FizzBuzz(5).getValue()));
		assertFalse("FizzBuzz".equals(new FizzBuzz(13).getValue()));
	}

	@Test
	public void test_number() throws Exception {
		assertTrue("1".equals(new FizzBuzz(1).getValue()));
		assertTrue("7".equals(new FizzBuzz(7).getValue()));
		assertFalse("3".equals(new FizzBuzz(3).getValue()));
		assertFalse("5".equals(new FizzBuzz(5).getValue()));
		assertFalse("7".equals(new FizzBuzz(15).getValue()));
	}
}
