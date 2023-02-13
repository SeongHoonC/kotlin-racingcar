package domain

class RaceTime(private val time: Int) {

    init {
        validateRange()
    }

    private fun validateRange() {
        require(time in LOWER_RACE_TIME..UPPER_RACE_TIME) { ERROR_NOT_IN_RANGE }
    }

    fun repeatTimes(func: () -> Unit) {
        repeat(time) {
            func()
        }
    }

    companion object {
        private const val LOWER_RACE_TIME = 1
        private const val UPPER_RACE_TIME = 10

        const val ERROR_NOT_IN_RANGE = "시도 횟수는 1이상 10 이하여야 합니다."
    }
}
