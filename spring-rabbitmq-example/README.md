```shell
# 도커로 띄울 경우 rabbitmq_management가 비활성화 되어 있으면 관리자 페이지 접속 불가능함
docker exec -it rabbitmq-stream rabbitmq-plugins enable rabbitmq_management
```

