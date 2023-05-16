package se.atg.harrykart.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import se.atg.harrykart.utility.HarryKartUtility

@SpringBootTest
@AutoConfigureMockMvc
class HarryKartControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testPlayHarryKartCase0() {
        val xmlRequestBody = HarryKartUtility.readXmlFileAsString("input_0.xml")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/kotlin/api/play")
                .contentType(MediaType.APPLICATION_XML)
                .content(xmlRequestBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].position").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].horse").value("TIMETOBELUCKY"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[2].position").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$[2].horse").value("CARGO DOOR"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].position").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].horse").value("HERCULES BOKO"))

    }

    @Test
    fun testPlayHarryKartCase1() {
        val xmlRequestBody = HarryKartUtility.readXmlFileAsString("input_1.xml")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/kotlin/api/play")
                .contentType(MediaType.APPLICATION_XML)
                .content(xmlRequestBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].position").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].horse").value("WAIKIKI SILVIO"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[2].position").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].horse").value("TIMETOBELUCKY"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].position").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$[2].horse").value("HERCULES BOKO"))

    }

    @Test
    fun testPlayHarryKartCase2() {
        val xmlRequestBody = HarryKartUtility.readXmlFileAsString("input_2.xml")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/kotlin/api/play")
                .contentType(MediaType.APPLICATION_XML)
                .content(xmlRequestBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].position").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].horse").value("HERCULES BOKO"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].position").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].horse").value("TIMETOBELUCKY"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[2].position").value(3))
            .andExpect(MockMvcResultMatchers.jsonPath("$[2].horse").value("WAIKIKI SILVIO"))

    }

    @Test
    fun testPlayHarryKartWithWrongXml() {
        val xmlRequestBody = HarryKartUtility.readXmlFileAsString("wrongFormat.xml")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/kotlin/api/play")
                .contentType(MediaType.APPLICATION_XML)
                .content(xmlRequestBody)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)

    }
}
