package com.github.springtestdbunit.sample.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.sample.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class PersonServiceTest2 {

	@Autowired
	private PersonService personService;

	@Test
	@DatabaseSetup("sampleData2.xlsx")
	public void testFind() throws Exception {
		List<Person> personList = this.personService.find("uca");
		assertEquals(1, personList.size());
		assertEquals("Luca", personList.get(0).getFirstName());
	}

	@Test
	@DatabaseSetup("sampleData2.xlsx")
	@ExpectedDatabase("expectedData2.xlsx")
	public void testRemove() throws Exception {
		this.personService.remove(1);
	}

}
