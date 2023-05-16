package se.atg.harrykart.service

import org.junit.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.util.ReflectionTestUtils
import se.atg.harrykart.utility.HarryKartUtility

@ComponentScan(basePackages = ["se.atg.harrykart.service"])
@SpringBootTest
internal class HarryKartServiceTest {

    @Autowired
    lateinit var harryKartService: HarryKartService

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ReflectionTestUtils.setField(harryKartService, "trackLength", 1000.0)
    }



    @Test
    fun shouldParseXmlAndReturnDataCaseOneAsExpected() {
        val input = HarryKartUtility.readXmlFile("input_0.xml")

        val actual = harryKartService.getResults(input)

        assertNotNull(actual)
        assertEquals(actual.size,3)
        assertEquals(actual[0].horse,"TIMETOBELUCKY")
        assertEquals(actual[0].position,1)
        assertEquals(actual[1].horse,"HERCULES BOKO")
        assertEquals(actual[1].position,2)
        assertEquals(actual[2].horse,"CARGO DOOR")
        assertEquals(actual[2].position,3)

    }

    @Test
    fun shouldParseXmlAndReturnDataCaseTwoAsExpected() {

        val input = HarryKartUtility.readXmlFile("input_2.xml")
        val actual = harryKartService.getResults(input)

        assertNotNull(actual)
        assertEquals(actual.size,3)
        assertEquals(actual[0].horse,"HERCULES BOKO")
        assertEquals(actual[0].position,1)
        assertEquals(actual[1].horse,"TIMETOBELUCKY")
        assertEquals(actual[1].position,2)
        assertEquals(actual[2].horse,"WAIKIKI SILVIO")
        assertEquals(actual[2].position,3)

    }


}