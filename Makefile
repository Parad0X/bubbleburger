all: build run

build:
	docker build -t server .

run:
	docker run -p 8080:8080 server
