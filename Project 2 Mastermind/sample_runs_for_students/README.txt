Suggested use of these sample runs
__________________________________

These are some sample runs of the program provided to you.  You can use them as test cases.  These are entirely separate from the sample grading script and its test cases.  Using these sample runs is optional.


1. Make a separate test_run directory for each test.
2. Download the provide input.txt and expected_output.txt files into each test_run directory.
3. Under each test_run directory, make a source code directory called assignment2.
4. Into each source code directory, copy your source files and the corresponding instructor-provided SecretCodeGenerator and the GameConfiguration files.

For each test run:
5. Go to the assignment2 directory, and compile the java files.
6. Go back up to the test_run directory, and run
		`java assignment2.Driver < input.txt > output.txt`
		OR
		`java assignment2.Driver 1 < input.txt > output.txt` (for the two_game_history_ta_test)
7. Compare each output.txt to the corresponding expected_output.txt.  When comparing the output with the provided golden output, ignore blank line differences. For example, the Unix command 'diff -B' may be used, like `diff -B expected_output.txt output.txt`.
