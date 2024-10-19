import java.io.File

class Buffer {
    private var lines = ArrayList<String>()
    private var path = ""

    val size get() = lines.size

    fun isEmpty(): Boolean {
        return lines.size == 0
    }

    fun load(path: String) {
        val newLines = ArrayList(File(path).readLines())
        lines = newLines
        this.path = path
    }

    fun write(path: String) {
        File(path).writeText("${lines.joinToString("\n")}\n")
        this.path = path
    }

    fun insertLine(line: Int, text: String) {
        lines.add(line - 1, text)
    }

    fun deleteLine(line: Int) {
        lines.removeAt(line - 1)
    }

    fun deleteRange(start: Int, end: Int) {
        for (i in (start - 1)..<end) {
            // We delete at the same spot every time because the list mutates
            lines.removeAt(start - 1)
        }
    }

    fun append(text: String) {
        lines.add(text)
    }

    fun print(): String {
        var result = ""
        for ((i, line) in lines.withIndex()) {
            result = "$result${i + 1} | $line\n"
        }
        return result
    }

    fun print(line: Int): String {
        return "$line | ${lines[line-1]}\n"
    }

    fun print(start: Int, end: Int): String {
        val lineRange = lines.slice((start - 1)..<end)
        var result = ""
        for ((i, line) in lineRange.withIndex()) {
            result = "$result${start + i} | $line\n"
        }
        return result
    }
}