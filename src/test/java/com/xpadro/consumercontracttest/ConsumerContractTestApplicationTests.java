package com.xpadro.consumercontracttest;

import com.xpadro.consumercontracttest.domain.CityServiceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.xpadro:testing-webapp:0.0.1-SNAPSHOT:stubs:8100"},
		stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerContractTestApplicationTests {
	private static final String SERVICE_URL = "http://localhost:8100/cities/Barcelona";

	@Test
	public void getPersonFromServiceContract() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<CityServiceResponse> result = restTemplate.getForEntity(SERVICE_URL, CityServiceResponse.class);

		assertNotNull(result.getBody());
		assertThat(result.getBody().getCityName(), equalTo("Barcelona"));
	}

}
