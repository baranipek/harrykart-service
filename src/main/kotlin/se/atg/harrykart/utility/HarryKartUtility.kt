package se.atg.harrykart.utility

import HarryKartRequest
import org.springframework.core.io.ClassPathResource
import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.xml.bind.JAXBContext

class HarryKartUtility {
    companion object {
        fun readXmlFile(path: String): HarryKartRequest {
            val resource = ClassPathResource(path)
            val inputStream: InputStream = resource.inputStream

            val jaxbContext = JAXBContext.newInstance(HarryKartRequest::class.java)
            val unMarshaller = jaxbContext.createUnmarshaller()

            return unMarshaller.unmarshal(inputStream) as HarryKartRequest
        }

        fun readXmlFileAsString(path: String): String {
            val resource = ClassPathResource(path)
            val inputStream: InputStream = resource.inputStream

            return inputStream.bufferedReader().use { it.readText() }
        }

        fun mapXmlFileToDto(input: String): HarryKartRequest {
            val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
            val jaxbContext = JAXBContext.newInstance(HarryKartRequest::class.java)

            val unMarshaller = jaxbContext.createUnmarshaller()
            return unMarshaller.unmarshal(inputStream) as HarryKartRequest
        }
    }
}