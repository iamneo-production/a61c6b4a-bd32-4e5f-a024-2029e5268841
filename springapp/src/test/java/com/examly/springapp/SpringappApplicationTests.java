package com.examly.springapp;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	@Transactional
    public void BE_Add_BankValut() throws Exception {
        String newBankValut = "{\"valutId\":\"VID01\",\"userId\":\"02\",\"accountNumber\":\"180035446877\",\"IFSC\":\"SBI001N009\",\"userName\":\"user1\",\"password\":\"User1@123\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/bank")
		.param("valutId","VID01")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newBankValut)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_BankValut() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/bank")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_BankValut() throws Exception {
        String newBankValut = "{\"valutId\":\"VID01\",\"userId\":\"02\",\"accountNumber\":\"180035446877\",\"IFSC\":\"SBI001N009\",\"userName\":\"user1\",\"password\":\"User@123\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/bank")
		.param("valutId","VID01")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newBankValut)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_User() throws Exception {
        String newUser = "{\"email\":\"user1@gmail.com\",\"password\":\"User@123\",\"username\":\"User1\",\"mobileNumber\":\"9876543210\",\"active\":\"true\",\"role\":\"admin\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/update")
		.param("email","user@gmail.com")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newUser)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
}
