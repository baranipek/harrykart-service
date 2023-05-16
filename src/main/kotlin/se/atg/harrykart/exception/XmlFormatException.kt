package se.atg.harrykart.exception

import org.springframework.http.HttpStatus

class XmlFormatException(val status: HttpStatus, message: String) : RuntimeException(message)
