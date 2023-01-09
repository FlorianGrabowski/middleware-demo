FROM node:alpine3.16 as builder
MAINTAINER Florian Grabowski <https://github.com/FlorianGrabowski>

WORKDIR /app
COPY ./ .

RUN npm install
RUN npm run build --prod

FROM nginx:1.23.3-alpine as runner
MAINTAINER Florian Grabowski <https://github.com/FlorianGrabowski>

COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=builder /app/dist/finance-planner-ui /usr/share/nginx/html

RUN chgrp -R root /var/cache/nginx /var/run /var/log/nginx && \
    chmod -R 770 /var/cache/nginx /var/run /var/log/nginx

