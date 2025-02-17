import com.App
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

object TestRunner {
    private val originalIn: InputStream = System.`in`

    private val originalOut: PrintStream = System.out

    fun run(input: String): String {
        // 표준 입력 리다이렉팅
        // [키보드 입력 => 문자열 입력] 변환
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)

        System.setIn(
            ByteArrayInputStream(
                ("$input\n종료")
                    .trim()
                    .toByteArray()
            )
        )
        // 표준 출력 리다이렉팅
        // [화면 출력 => 문자열 출력] 변환
        System.setOut(printStream)

        App().run()

        // 표준 출력 결과를 문자열로 변환
        // 윈도우와 Mac OS 개행 문자 차이로 인한 표준화
        val result = outputStream.toString().trim().replace(Regex("\\r\\n"), "\n")

        // 다시 표준 입출력으로 북구
        System.setIn(originalIn)
        System.setOut(originalOut)

        return result
    }
}