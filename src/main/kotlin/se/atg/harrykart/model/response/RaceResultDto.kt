package se.atg.harrykart.model.response

data class RaceResultDto(
    var horse: String?,
    var position: Int
) {

    constructor( horse: String) : this( horse, 0)

}