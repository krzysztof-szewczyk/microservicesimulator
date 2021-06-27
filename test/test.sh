#!/bin/bash
START=$(date +%s.%N)
N=1000
success=0
error=0
for (( i=1; i<=N; i++ ))
do
printf "$i-"
#curl "http://localhost:8081/info" -w "%{http_code}"
#curl "http://localhost:8000/start" -w "%{http_code}"
if [ $(curl -LI -X GET http://localhost:8000/start -o /dev/null -w '%{http_code}\n' -s) == "200" ]; then echo 200 && ((success=success+1)); else echo 'error' && ((error=error+1)); fi
#curl -LI -X GET http://localhost:8000/start -o /dev/null -w '%{http_code}\n' -s
done
END=$(date +%s.%N)
DIFF=$(echo "($END - $START)/$N" | bc -l)
echo "Average time: $DIFF"
echo "Successes: $success"
echo "Errors: $error"



