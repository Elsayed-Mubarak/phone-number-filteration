#From Node.js Image
FROM node:13.12.0-alpine as build-step

RUN mkdir /app
WORKDIR /app
COPY package.json yarn.lock /app/

RUN yarn install
COPY . /app
RUN yarn run build

EXPOSE 3000

#From nginx Image to Serve Static Files.
FROM nginx:1.17.1-alpine
COPY --from=build-step /app/build /usr/share/nginx/html