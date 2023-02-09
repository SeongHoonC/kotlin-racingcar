package view

import dto.CarMetadataDTO
import dto.WinnersDTO

class OutputView {
    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(carMetadataDTO: CarMetadataDTO) {
        println("${carMetadataDTO.getName()} : ${"-".repeat(carMetadataDTO.getDistance())}")
    }

    fun printWinners(winnersDTO: WinnersDTO) {
        val winners = winnersDTO.getWinners()
        winners.joinToString { ", " }
    }

    companion object {
        const val EXECUTION_RESULT = "실행 결과"
        const val FINAL_WINNER = "최종 우승자: "
    }
}
