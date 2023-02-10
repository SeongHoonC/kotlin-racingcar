package domain

class CarsFactory(private val names: List<String>) {

    init {
        validateCarCount()
        validateCarUniqueness()
    }

    fun makeCars(numberGenerator: RandomNumberGenerator): List<Car> {
        return names.map { name -> Car(numberGenerator, name) }
    }

    private fun validateCarCount() {
        require(names.size in 2..20) { ERROR_CAR_COUNT }
    }

    private fun validateCarUniqueness() {
        require(names.size == names.toSet().size) { ERROR_CAR_UNIQUENESS }
    }

    companion object {
        const val ERROR_CAR_COUNT = "자동차 개수는 2대 이상 20대 이하여야 합니다."
        const val ERROR_CAR_UNIQUENESS = "자동차 이름은 중복되면 안 됩니다."
    }
}
