#!/bin/sh
# replace placeholder value in JS bundle with environment specific values
sed -i "s#PLACEHOLDER_API_URL#${API_URL}#g" /usr/share/nginx/html/main.*.js
exec "$@"