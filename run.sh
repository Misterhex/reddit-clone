# build frontend and copy to static folder of spring boot then run

cd frontend
npm install
rm -rf ./dist
export NODE_ENV=production && npm run build
cd ..
rm -rf ./backend/src/main/resources/public/
mkdir -p ./backend/src/main/resources/public/
mv ./frontend/dist/* ./backend/src/main/resources/public/
cd ./backend
mvn spring-boot:run
