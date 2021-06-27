#!/bin/bash

N=1000
START=$(date +%s.%N)
xargs -I 200 -P 1 curl -LI http://localhost:8081/info -o /dev/null -w '%{http_code}\n' -s < <(printf '%s\n' {1..1000})
END=$(date +%s.%N)
DIFF=$(echo "($END - $START)/$N" | bc -l)
echo "Average time: $DIFF"


