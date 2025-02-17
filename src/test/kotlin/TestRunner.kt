import com.App
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

object TestRunner {
    private val originalIn: InputStream = System.`in`

    private val originalOut: PrintStream = System.out

    fun run(input: String): String {
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)

        System.setIn(ByteArrayInputStream(("$input\n종료").trim().toByteArray()))
        System.setOut(printStream)

        App().run()

        val result = outputStream.toString().trim().replace(Regex("\\r\\n"), "\n")

        System.setIn(originalIn)
        System.setOut(originalOut)

        return result
    }
}