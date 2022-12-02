#!/bin/bash
curl -L -X GET 'https://api.github.com/repos/JonathanVandenBoschPXL/Java_HelloWorld/tags' -H 'Authorization: Bearer ${{ secrets.GITHUB_TOKEN }}'