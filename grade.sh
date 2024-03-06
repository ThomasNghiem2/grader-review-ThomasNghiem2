CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission &> clone.txt
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

cp student-submission/*java grading-area
if [ $? -ne 0 ]
then 
    echo "File not found"
    echo "Score: 0"
    exit
fi

cp TestListExamples.java grading-area
cp -r lib grading-area

cd grading-area

if ! [ -f ListExamples.java ]
then 
    echo "Missing ListExamples.java in student submission"
    echo "Score: 0"
    exit
fi 

javac -cp $CPATH *.java &> compile.txt 
if [ $? -ne 0 ]
then 
    echo "Compilation Error"
    echo "Score: 0"
    exit
else 
    echo "Successful compilation"
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples &> error.txt
grep "OK" error.txt

if [ $? -ne 0 ]
then
    echo "Testing Error"
    echo "Score: 0"
    exit
fi

