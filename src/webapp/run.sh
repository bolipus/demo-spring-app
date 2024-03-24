npm run build
rm -fr ../main/resources/static/*
cp -r ./dist/* ../main/resources/static/
cp ./dist/index.html ../main/resources/templates/
