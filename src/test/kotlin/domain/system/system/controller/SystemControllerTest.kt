package domain.system.system.controller

import TestRunner
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

class SystemControllerTest {
    @Test
    fun `종료`() {
        val result = TestRunner.run("")

        assertThat(result).contains("프로그램을 종료합니다.")
    }
}