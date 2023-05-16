package se.atg.harrykart.service

import HarryKartRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import se.atg.harrykart.model.RaceResult
import se.atg.harrykart.model.response.RaceResultDto

@Service
class HarryKartService {
    @Value("\${distance}")
    private var trackLength: Double = 0.0

    fun getRaceResults(harryKartRequest: HarryKartRequest): List<RaceResultDto> {
        val raceResults = iterateRaceResults(harryKartRequest)

        raceResults.removeIf { raceResult -> !raceResult.isCompleted }
        return raceResults.sortedWith(compareBy { it.averageSpeedTime }).mapIndexed { index, raceResult ->
            raceResult.copy(
                position = index + 1
            )
        }
            .take(3).map { RaceResultDto(it.horse, it.position) }


    }

    private fun iterateRaceResults(harryKartRequest: HarryKartRequest): ArrayList<RaceResult> {
        val raceResults = ArrayList<RaceResult>()

        harryKartRequest.startList.participants.forEach { p ->
            val raceResult = RaceResult(p.name, 0, trackLength / p.baseSpeed, true)

            harryKartRequest.powerUps.loops.forEach { loop ->
                loop.lanes.filter { lane -> lane.number == p.lane }
                    .forEach { lane ->
                        val loopSpeed = p.baseSpeed + lane.value
                        if (loopSpeed <= 0) {
                            raceResult.isCompleted = false
                        } else {
                            p.baseSpeed += lane.value
                            raceResult.averageSpeedTime += trackLength / p.baseSpeed
                        }
                    }
            }

            raceResults.add(raceResult)
        }
        return raceResults
    }
}