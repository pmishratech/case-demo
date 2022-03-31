package com.cisco.code.demo;

import com.cisco.code.demo.model.Case;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CaseResourceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testCreateCase() throws Exception {

		// prepare
		Case mockCase = new Case();
		mockCase.setTitle("test");
		mockCase.setDescription("bla bla");
		mockCase.setSeverity(1);
		mockCase.setStatus(Case.Status.OPEN);


		// execute
		ResponseEntity<Case> responseEntity = restTemplate.postForEntity("/case/create", mockCase, Case.class);

		// collect Response
		int status = responseEntity.getStatusCodeValue();
		Case resultCase = responseEntity.getBody();

		// verify
		assertEquals(status, HttpStatus.CREATED.value());

		assertNotNull(resultCase);
		assertNotNull(resultCase.getCaseId());

	}

	@Test
	public void testGetCaseById() throws Exception {

		// prepare
		Case mockCase = new Case();
		mockCase.setTitle("test");
		mockCase.setDescription("bla bla");
		mockCase.setSeverity(1);
		mockCase.setStatus(Case.Status.OPEN);

		restTemplate.postForEntity("/case/create", mockCase, Case.class);
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("/cases/status/" + "{id}", Object.class, "OPEN");

		// collect response
		int status = responseEntity.getStatusCodeValue();

		// verify
		assertEquals(status, HttpStatus.OK.value());

	}

}
