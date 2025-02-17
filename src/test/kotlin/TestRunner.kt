import com.App
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

object TestRunner {
    private val originalIn: InputStream = System.`in`
    private val originalOut: PrintStream = System.out

    fun run(input: String): String {
        val formattedInput = input
            .trimIndent()
            .plus("\n종료")

        // use : close()를 자동으로 호출함
        return ByteArrayOutputStream().use { outputStream ->
            PrintStream(outputStream).use { printStream ->
                try {
                    System.setIn(
                        ByteArrayInputStream(
                            formattedInput.toByteArray()
                        )
                    )

                    System.setOut(printStream)

                    App().run()
                } finally { // 무조건 실행되게 함(skip 될 가능성 x)
                    System.setIn(originalIn)   // 실행이 안되면 readLine()이 안됨
                    System.setOut(originalOut) // 실행이 안되면 println()이 안됨
                }
            }

            outputStream
                .toString()
                .trim()
                .replace("\r\n", "\n")
        }
    }
}