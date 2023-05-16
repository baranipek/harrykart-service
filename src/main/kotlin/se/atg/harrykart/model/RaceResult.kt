package se.atg.harrykart.model

data class RaceResult(
    var horse: String?,
    var position: Int,
    var averageSpeedTime: Double = 0.0,
    var isCompleted: Boolean = false
) {

    constructor( horse: String) : this( horse, 0,0.0, false)

}