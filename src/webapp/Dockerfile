FROM node:18-alpine as builder
WORKDIR /app
COPY . .
RUN npm install && npm run build --production

FROM nginx:latest
COPY --from=builder /app/dist/* /usr/share/nginx/html/
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

