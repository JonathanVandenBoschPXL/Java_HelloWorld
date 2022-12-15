FROM nginx:1.17.1-alpine
COPY ./frontend/Prisma/nginx.conf /etc/nginx/nginx.conf
COPY ./frontend/Prisma/dist/prisma /usr/share/nginx/html

COPY ./frontend/Prisma/API_URL_REPLACER.sh /usr/local/bin/API_URL_REPLACER.sh
RUN chmod +x /usr/local/bin/API_URL_REPLACER.sh
ENV API_URL http://10.128.9.3:7000/api
ENTRYPOINT [ "API_URL_REPLACER.sh" ]

EXPOSE 4200

CMD ["nginx", "-g", "daemon off;"]



