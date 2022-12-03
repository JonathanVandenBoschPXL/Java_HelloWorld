#!/bin/bash

VER=$1
SUFFIX='-pre'
PREFIX='v'

REGEX="[v].*(-pre)[0123456789]*"

if [[ "$VER" =~ $REGEX ]]; then
    echo "Valid pre-release tag found."
    echo -n "$VER => ";
    [[ "$VER" =~ (.*[^0-9])([0-9]+)$ ]] && VER="${BASH_REMATCH[1]}$((${BASH_REMATCH[2]} + 1))";
    echo "$VER"
    echo "TAG_NAME=$VER" >> $GITHUB_OUTPUT;
    # perl -pe 's/(\d+)(?!.*\d+)/$1+1/e' <<< "$VER"
    
else
    echo "No pre-release tag found!"
    echo "Creating pre-release tag string..."
    [[ "$VER" =~ (.*[^0-9])([0-9]+)$ ]] && VER="${BASH_REMATCH[1]}$((${BASH_REMATCH[2]} + 1))";
    echo "TAG_NAME=$VER-pre1" >> $GITHUB_OUTPUT;
fi
echo "end"


# for version in $1; do
#     echo -n "$version => ";
#     [[ "$version" =~ (.*[^0-9])([0-9]+)$ ]] && version="${BASH_REMATCH[1]}$((${BASH_REMATCH[2]} + 1))";
#     echo "$version"
#     echo "TAG_NAME=$version" >> $GITHUB_OUTPUT;
#     echo $GITHUB_OUTPUT
# done