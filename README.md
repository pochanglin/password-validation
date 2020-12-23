# password-validation

When the server is running you can try to access the API
```
curl -X POST -H "Content-Type: application/json" \
    -d '{"password": "123"}' \
    http://localhost:8080/password/validate
```