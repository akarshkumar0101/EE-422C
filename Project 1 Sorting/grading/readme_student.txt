#Assignment 1 Grading Script

This script will automatically test your program with a couple sample test
cases. You have to run this script before submitting to Canvas. The script
will catch small mistakes and anything that will prevent us from grading your
program.

To run the script copy the `sample_grading_script.zip` file and your
`SortTools.java` file to kamek.ece.utexas.edu
```
scp sample_grading_script.zip username@kamek.ece.utexas.edu:.
scp SortTools.java username@kamek.ece.utexas.edu:.
```
Make sure you have an EE422C directory. Unzip the sample grading script. Move
`SortTools.java` into the `grading`directory and then make a copy in the
`submissions` directory. The grading script deletes `SortTools.java` every time
you run the grading script.
```
unzip sample_grading_script.zip -d EE422C
rm sample_grading_script.zip
mv SortTools.java EE422C/grading
cd EE422C/grading
cp SortTools.java submissions
```
After your `SortTools.java` is in the `submissions` directory, run the grading
script by doing the following.
```
./grade.sh
```
The grading script will begin to grade all the Java files found in the
`submissions` directory. The `submissions` directory starts out with a dummy
Java file which will be one of the results you see as the script grades. The
other result will be your program.

Once the script has finished, you can open the `brief_results.csv` file.
Easiest way is to run the following command but you can also copy the file from
kamek to your local computer and open it in Excel, Numbers, etc.
```
cat brief_results.csv
```
This will display something like this.
```
"submission_name", "grade", "comment"
('"sample_submission", ', 2, ', ""')
('"SortTools.java", ', 5, ', ""')
```
If `SortTools.java` has a grade of 5 then you are good to submit your program
on Canvas. Note that getting that score here has no indication on whether you
will get full credit.

If `SortTools.java` has anything else listed next to it then you will need to
fix your program before submitting. To understand what went wrong with your
program you will need to look at the detailed feedback provided for your
program.

Unzip the `SortTools.zip` file found under the `detailed_feedback` directory.
You will see a file named `maven_run_report.xml`, if you don't that means your
code did not compile or had another fatal error (Such as using
`System.exit()`). 

The `maven_run_report.xml` is a bit tough to understand. An explanation is
given below but if you are having difficulty post on Piazza or go to office
hours. We are actively working on making the feedback easier to understand.

In the `maven_run_report.xml` file you should see the following lines towards
the end of the file. If either of them has a line beneath them saying failure
then that test case is the problem. Underneath failure there should be
information such as the exception thrown and the stack trace. Or it will state
what your output was compared to what we expected.
```xml
<testcase classname="assignment1.SampleTest" name="testFindFoundFull" time="0.005"/>
<testcase classname="assignment1.SampleTest" name="testInsertGeneralPartialEnd" time="0.008">
```

