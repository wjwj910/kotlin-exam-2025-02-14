import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertContains

class AppTest {
    @Test
    @DisplayName("명언 작성")
    fun t1() {
        val result = TestRunner.run(
            """
            등록
            나의 죽음을 적들에게 알리지 말라.
            충무공 이순신
        """
        )
        assertContains(result, "명언 : ")
        assertContains(result, "작가 : ")
        assertContains(result, "1번 명언이 등록되었습니다.")
    }

    @Test
    fun `명언 목록`() {
        val result = TestRunner.run(
            """
            등록
            나의 죽음을 적들에게 알리지 말라.
            충무공 이순신
            등록
            천재는 99%의 노력과 1%의 영감이다.
            에디슨
            목록
        """
        )
        assertContains(result, "1 / 충무공 이순신 / 나의 죽음을 적들에게 알리지 말라.")
        assertContains(result, "2 / 에디슨 / 천재는 99%의 노력과 1%의 영감이다.")
    }
}