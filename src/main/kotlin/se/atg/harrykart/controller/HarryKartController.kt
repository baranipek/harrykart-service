package se.atg.harrykart.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.atg.harrykart.exception.XmlFormatException
import se.atg.harrykart.model.response.RaceResultDto
import se.atg.harrykart.service.HarryKartService
import se.atg.harrykart.utility.HarryKartUtility

@RestController
@RequestMapping("/kotlin/api")
class HarryKartController(private val service: HarryKartService) {

    @PostMapping(
        value = ["/play"],
        consumes = [MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun playHarryKart(@RequestBody inputXml: String): List<RaceResultDto> {
        try {
            return service.getRaceResults(HarryKartUtility.mapXmlFileToDto(inputXml))
        } catch (exception: Exception) {
            throw XmlFormatException(HttpStatus.BAD_REQUEST, "An error occurred while processing the request")
        }
    }
}