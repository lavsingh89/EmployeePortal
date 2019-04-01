package com.employeeportal.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employeeportal.model.Employee;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { EmployeeController.class })
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void init() {
	MockitoAnnotations.initMocks(this);
	mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void createEmployeeTest() throws Exception {
	String json = getEmployeeMockData();
	MvcResult result = mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json))
		.andReturn();
	String content = result.getResponse().getContentAsString();
	assertNotNull(content);

    }

    @Test
    public void createEmployeeWithNullData() throws Exception {
	MvcResult result = mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(""))
		.andReturn();
	String content = result.getResponse().getContentAsString();
	assertEquals("", content);
    }

    private String getEmployeeMockData() {
	Employee employee = new Employee();
	employee.setEmployeeId(1);
	employee.setFirstName("firstname");
	employee.setLastName("lastname");
	employee.setDepartment("Engineer");
	employee.setGender("male");
	Gson gson = new Gson();
	return gson.toJson(employee);
    }

    @Test
    public void getTest() {
	List<Employee> data = employeeController.getSortedEmployees();
	assertTrue(data.isEmpty());
    }
    
}
