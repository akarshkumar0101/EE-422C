# Assignment 2 Grading Script

This script will automatically test your program with a couple sample test
cases. You have to run this script before submitting to Canvas. The script
will catch small mistakes and anything that will prevent us from grading your
program.

To run the script copy the `sample_grading_script.zip` file and your
`Project2_EID.zip` file to kamek.ece.utexas.edu
```console
student@local:~$ scp sample_grading_script.zip username@kamek.ece.utexas.edu:.
student@local:~$ scp Project2_EID.zip username@kamek.ece.utexas.edu:.
```
Make sure you have an EE422C directory. At this point you most likely also
already have a `grading` directory from a previous assignment. Make sure to
delete this before unziping the new grading script. Move `Project2_EID.zip`
into the `grading` directory and then make a copy in the `submissions`
directory. The grading script deletes `Project2_EID.zip` every time you run the
grading script.
```console
student@kamek:~$ rm -r EE422C/grading
student@kamek:~$ unzip sample_grading_script.zip -d EE422C
student@kamek:~$ rm sample_grading_script.zip
student@kamek:~$ mv Project2_EID.zip EE422C/grading
student@kamek:~$ cd EE422C/grading
student@kamek:~/EE422C/grading$ cp Project2_EID.zip submissions
```
After your `Project2_EID.zip` is in the `submissions` directory, run the grading
script by doing the following.
```console
student@kamek:~/EE422C/grading$ ./grade.sh
```
The grading script will begin to grade all the zip files found in the
`submissions` directory. The `submissions` directory starts out with several
dummy zip files which will be most of the results you see as the script grades.
One of the results will be yours. It will most likely be hard to find it among
the other results so instead look at the files created.

Once the script has finished, you can open the `brief_results.csv` file.
Easiest way is to run the following command but you can also copy the file from
kamek to your local computer and open it in Excel, Numbers, etc.
```console
student@kamek:~/EE422C/grading$ cat brief_results.csv
```
This will display something like this.
```
"submission_name", "passed_tests", "total_tests"
"Project2_compileerrorEID", "0", "0"
"Project2_myeid", "1", "4"
"Project2_runtimeerrorEID", "0", "4"
"Project2_EID", "4", "4"
```
If `Project2_EID` has a grade of 4 then you are good to submit your program
on Canvas. Note that getting that score here has no indication on whether you
will get full credit.

If `Project2_EID` has anything else listed next to it then you will need to
fix your program before submitting. To understand what went wrong with your
program you will need to look at the detailed feedback provided for your
program.

Unzip the `Project2_EID.zip` file found under the `detailed_feedback` directory.
You will see a file named `output_diff.txt`, if you don't that means your
code did not compile or had another fatal error (Such as using
`System.exit()`). 
