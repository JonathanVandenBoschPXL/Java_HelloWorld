FROM nginx:1.17.1-alpine
COPY ./frontend/nginx.conf /etc/nginx/nginx.conf
COPY ./frontend/dist/template-frontend-h4-databinding-lab /usr/share/nginx/html
EXPOSE 4200
