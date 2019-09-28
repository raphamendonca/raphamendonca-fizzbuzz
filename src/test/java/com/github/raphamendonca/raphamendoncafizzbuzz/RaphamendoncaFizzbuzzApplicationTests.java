package com.github.raphamendonca.raphamendoncafizzbuzz;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaphamendoncaFizzbuzzApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void givenInvalidaInput_whenCheckFizzBuzzNumber_then400IsReceived() throws IOException {

		// Given
		HttpUriRequest request = new HttpGet("http://localhost:8080/fizzBuzz/" + "a");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertTrue(HttpStatus.BAD_REQUEST.equals(httpResponse.getStatusLine().getStatusCode()));
	}
}
