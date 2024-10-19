import java.nio.file.Files
import kotlin.io.path.Path

fun main() {
    val buffer = Buffer()

    var running = true
    while (running) {
        print("> ")
        val input = readlnOrNull()?.trim()?.split(" ")

        if (input.isNullOrEmpty()) {
            continue
        }

        if (input[0] == "insert") {
            val lineNumber = if (input.size >= 2) input[1].toInt() else 1

            print(">> ")
            val text = readlnOrNull() ?: ""

            buffer.insertLine(lineNumber, text)
        } else if (input[0] == "print") {
            if (input.size == 1) {
                print(buffer.print())
            } else if (input.size == 2) {
                val line = input[1].toInt() ?: 0
                print(buffer.print(line))
            } else {
                val start = input[1].toInt() ?: 0
                val end = input[2].toInt() ?: 0
                print(buffer.print(start, end))
            }
        } else if (input[0] == "append") {
            print(">> ")
            val text = readlnOrNull() ?: ""

            buffer.append(text)
        } else if (input[0] == "delete") {
            if (input.size == 2) {
                val line = input[1].toInt() ?: 0
                buffer.deleteLine(line)
            } else {
                val start = input[1].toInt() ?: 0
                val end = input[2].toInt() ?: 0
                buffer.deleteRange(start, end)
            }
        } else if (input[0] == "change") {
            if (input.size == 2) {
                val line = input[1].toInt() ?: 0
                buffer.deleteLine(line)

                print(">> ")
                val replacement = readlnOrNull() ?: ""
                buffer.insertLine(line, replacement)
            } else {
                val start = input[1].toInt() ?: 0
                val end = input[2].toInt() ?: 0
                buffer.deleteRange(start, end)

                print(">> ")
                val replacement = readlnOrNull() ?: ""
                buffer.insertLine(start, replacement)
            }
        } else if (input[0] == "load") {
            if (!Files.exists(Path(input[1]))) {
                println("'${input[1]}' does not exist!")
                continue
            }

            if (!buffer.isEmpty()) {
                print("You will lose any unsaved changes. Proceed anyway? (y/N) ")
                val response = readlnOrNull()?.lowercase() ?: ""
                if (response != "yes" && response != "y") {
                    println("Aborting...")
                    continue
                }
            }

            println("Loading...")
            buffer.load(input[1])
        } else if (input[0] == "write") {
            val path: String
            if (input.size > 1) {
                path = input[1]
            } else {
                print("Write to: ")
                path = readlnOrNull() ?: ""
            }

            if (Files.exists(Path(path))) {
                print("This file already exists. Overwrite it? (y/N) ")
                val response = readlnOrNull()?.lowercase() ?: ""
                if (response != "yes" && response != "y") {
                    println("Aborting...")
                    continue
                }
            }

            println("Writing...")
            buffer.write(path)
        } else if (input[0] == "quit") {
            running = false
        }
    }
}
