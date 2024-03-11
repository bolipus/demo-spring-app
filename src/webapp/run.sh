ng build
rm -fr ../main/resources/static/*
cp -r ./dist/demo-client/* ../main/resources/static/
cp ./dist/demo-client/index.html ../main/resources/templates/
