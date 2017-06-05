# reddit-clone

### Docker cloud (hosted)
```
http://reddit-clone-bf84c083.602272e5.svc.dockerapp.io:8080
```

### pull from dockerhub
```
docker run -it --rm -p 8080:8080 misterhex/reddit-clone:latest
```

### build
```
docker build -t reddit-clone .
docker run -it --rm -p 8080:8080 reddit-clone
```
