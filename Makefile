build:
	cd backend-apis && $(MAKE) build
	cd frontend-app && $(MAKE) build

run:
	docker-compose up

stop:
	docker-compose down
