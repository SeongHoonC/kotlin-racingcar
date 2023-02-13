package domain

class Car(
    private val generator: NumberGenerator,
    val name: String,
    startDistance: Int = 0
) {
    var distance = startDistance
        private set

    init {
        validateCarName()
    }

    private fun validateCarName() {
        require(name.length in NAME_LOWER_LENGTH..NAME_UPPER_LENGTH) { ERROR_NAME_LENGTH }
        name.forEach { require(it.isLowerCase()) { ERROR_NAME } }
    }

    fun race() {
        val number = generator.generate()
        if (checkGo(number)) go()
    }

    private fun checkGo(number: Int): Boolean {
        if (number >= RANGE_LOWER_INCLUSIVE)
            return true
        return false
    }

    private fun go() {
        distance++
    }

    companion object {
        private const val NAME_LOWER_LENGTH = 1
        private const val NAME_UPPER_LENGTH = 5

        private const val RANGE_LOWER_INCLUSIVE = 4

        const val ERROR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다."
        const val ERROR_NAME = "자동차 이름은 공백이 없는 영문 소문자여야 합니다."
    }
}
