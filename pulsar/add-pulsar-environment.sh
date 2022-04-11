#!/bin/bash

CSRF_TOKEN=$(curl http://localhost:7750/pulsar-manager/csrf-token)
curl \
   -H 'X-XSRF-TOKEN: $CSRF_TOKEN' \
   -H 'Cookie: XSRF-TOKEN=$CSRF_TOKEN;' \
   -H "Content-Type: application/json" \
   -X PUT http://localhost:7750/pulsar-manager/users/superuser \
   -d '{"name": "admin", "password": "apachepulsar", "description": "test", "email": "username@test.org"}'

exit

curl 'http://localhost:9527/pulsar-manager/environments/environment' \
  -X 'PUT' \
  -H 'Accept: application/json, text/plain, */*' \
  -H 'Accept-Language: pl-PL,pl;q=0.9,en-US;q=0.8,en;q=0.7' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Cookie: XSRF-TOKEN=769c6c84-6749-4136-8549-f84f03aad140; 769c6c84-6749-4136-8549-f84f03aad140=769c6c84-6749-4136-8549-f84f03aad140; JSESSIONID=EB10372EFFB83E36E1FE7236F8E37C66; Admin-Token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjU0MzFhNzgzYjRjNDcxOWZiYTczMmI4ZGM3MDJkNWY4ODZiNWUyYzI5ZGM5MjQ4YmY3ODc5OTM4ZjIxNGMyNTgxNjQ5NjQ4NzU3OTA4IiwiZXhwIjoxNjQ3OTQ1NzkwfQ.sKmJ5FN2dFQj8uYhbfszyEtpNKkxR6nBBDhOnVeo-qQ; username=admin; tenant=admin; sidebarStatus=1' \
  -H 'Origin: http://localhost:9527' \
  -H 'Referer: http://localhost:9527/' \
  -H 'Sec-Fetch-Dest: empty' \
  -H 'Sec-Fetch-Mode: cors' \
  -H 'Sec-Fetch-Site: same-origin' \
  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36' \
  -H 'X-XSRF-TOKEN: 769c6c84-6749-4136-8549-f84f03aad140' \
  -H 'environment: undefined' \
  -H 'sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "macOS"' \
  -H 'tenant: admin' \
  -H 'token: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjU0MzFhNzgzYjRjNDcxOWZiYTczMmI4ZGM3MDJkNWY4ODZiNWUyYzI5ZGM5MjQ4YmY3ODc5OTM4ZjIxNGMyNTgxNjQ5NjQ4NzU3OTA4IiwiZXhwIjoxNjQ3OTQ1NzkwfQ.sKmJ5FN2dFQj8uYhbfszyEtpNKkxR6nBBDhOnVeo-qQ' \
  -H 'username: admin' \
  --data-raw '{"name":"pulsar","broker":"http://pulsar:8080"}' \
  --compressed