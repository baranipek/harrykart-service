package se.atg.harrykart.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandlerAdvice {

    @ExceptionHandler(XmlFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleXmlFormatException(ex: XmlFormatException): ResponseEntity<ErrorResponse> {
        val errorResponse = ex.message?.let { ErrorResponse(HttpStatus.BAD_REQUEST.value(), it) }
        return ResponseEntity.badRequest().body(errorResponse)
    }
}

data class ErrorResponse(val status: Int, val message: String)

