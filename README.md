# Overview

(NOTE: This file was written largely using this program)

I created this simple program in an effort to learn the Kotlin programming language.

A created a simple text editing program. It is an ed-style line editor. It uses commands such as insert, delete, and append to manipulate a text buffer.

I decided to create this software in order to learn about basic string manipulation, input handling, and file operations in Kotlin.

[Software Demo Video](https://youtu.be/yNft1I6cQR8)

# Commands
`print [start_line [end_line]]`

	Prints the selected range or entire buffer with line number information.

`insert [line_number]`

	Inserts a line at the specified line or the beginning of the buffer.

`append`

	Appends a line to the end of the buffer.

`delete <start_line> [end_line]`

	Deletes the specified line or range of lines.

`change <start_line> [end_line]`

	First deletes the specified line or range, and then inserts a new line at that location.

`write [file_name]`

	Writes the contents of the buffer to the specified file.
	If no file is specified, it will prompt for one.
	If the file already exists, it will ask for confirmation to overwrite it.

`load <file_name>`

	Loads the specified file into the buffer.
	If the buffer is not empty, it will prompt for confirmation to erase the buffers contents.
	
# Development Environment

I created this software using JetBrains' IntelliJ IDEA to set up, write, and debug this project.

I used basic Kotlin here with no external libraries.

# Useful Websites

- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

# Future Work

- Better error handling for command arguments
- Better error handling for writing out of bounds in the buffer
- The ability to select and move lines through the buffer
