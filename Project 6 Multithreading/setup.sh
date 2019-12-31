rm -rf ak39969/
rm -rf grading/

cp -r src/. ak39969/
zip -r ak39969.zip ak39969/

unzip sample_grading_script.zip

mv ak39969.zip grading/submissions/

