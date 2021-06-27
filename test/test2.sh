#!/bin/bash

N=1000
START=$(date +%s.%N)
xargs -I % -P 1 curl -w '\n' "http://localhost:8000/start" < <(printf '%s\n' {1..1000})
END=$(date +%s.%N)
DIFF=$(echo "($END - $START)/$N" | bc -l)
echo "Average time: $DIFF"


