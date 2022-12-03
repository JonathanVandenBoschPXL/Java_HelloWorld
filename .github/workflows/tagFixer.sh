#!/bin/bash

# OLDVER=$1
# SUFFIX='-pre'
# PREFIX='v'

# REGEX="[v].*(-pre)[0123456789]*"

# if [[ "$OLDVER" =~ $REGEX ]]; then
#     echo "Valid pre-release tag found."
#     perl -pe 's/(\d+)(?!.*\d+)/$1+1/e' <<< "$OLDVER"
    
# else
#     echo "No pre-release tag found!"
# fi
# echo "end"


for version in $1; do
    echo -n "$version => ";
    [[ "$version" =~ (.*[^0-9])([0-9]+)$ ]] && version="${BASH_REMATCH[1]}$((${BASH_REMATCH[2]} + 1))";
    echo "$version"
    echo "TAGNAME=$version" >> $GITHUB_OUTPUT;
    echo $GITHUB_OUTPUT
done