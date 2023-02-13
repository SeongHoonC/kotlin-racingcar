package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val numberGenerator = TestNumberGenerator(listOf())

    @Test
    fun `자동차는 4 이상 값이 세 번 나오면 세 칸 전진한다`() {
        val generator = TestNumberGenerator(listOf(2, 4, 3, 9, 5, 0))
        val name = "pobi"
        val car = Car(generator, name)
        val distances = listOf(0, 1, 1, 2, 3, 3)
        distances.map { distance ->
            car.race()
            assertThat(car.distance).isEqualTo(distance)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "woni", "jun"])
    fun `자동차 이름은 1글자 이상 5글자 이하의 영문 소문자로 되어 있다`(input: String) {
        Assertions.assertDoesNotThrow { Car(numberGenerator, input, 0) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["Pobi", " jun", "po bi", "   "])
    fun `자동차 이름은 영문 소문자를 제외한 공백이나 대문자로 지을 수 없다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { Car(numberGenerator, input, 0) }
        assertThat(exception.message).isEqualTo(Car.ERROR_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["woniii", ""])
    fun `자동차 이름은 글자가 없거나 6글자 이상일 수 없다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { Car(numberGenerator, input, 0) }
        assertThat(exception.message).isEqualTo(Car.ERROR_NAME_LENGTH)
    }

    class TestNumberGenerator(numbers: List<Int>) : NumberGenerator {
        private val numbers = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}
