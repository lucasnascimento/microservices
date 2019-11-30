# Workshop Microserviços com kubernets #

Este repositório contém um exemplo de uma aplicação em microserviço. A aplicação contém 3 projetos, sendo um deles utilizando o graphql como pi gatewai. Os outros dois, um deles em kotlin e o outro em Java. Ambos usam o SpringBoot. Para executar os comandos abaixo deve-se, antes, instalar o minikube localmente no computador:
	- https://kubernetes.io/docs/tasks/tools/install-minikube/

## Kubernets ##

	Inicia minikube: 
		minikube start -p microservico --insecure-registry local-registry:5000 --memory 4096 --cpus 4

	Inclui credenciais docker: 
		kubectl create secret docker-registry local-registry --docker-server=local-registry:5000 --docker-username=cubas --docker-password=138cubas265

	Inclui um deployment
		kubectl create deployment ecommerce-deployment --image=cubas/ecommerce:latest
		kubectl create deployment stock-deployment --image=cubas/stock:latest
		kubectl create deployment graphql-deployment --image=cubas/graphql:latest

	Expoe o servico
		kubectl expose deployment ecommerce-deployment --type=NodePort --port=8082 --target-port=8082
		kubectl expose deployment graphql-deployment --type=NodePort --port=8083 --target-port=8083
		kubectl expose deployment stock-deployment --type=NodePort --port=8081 --target-port=8081

	Verifica a URL do servico
		minikube -p microservico service ecommerce-deployment --url
		minikube -p microservico service graphql-deployment --url
		minikube -p microservico service stock-deployment --url

	--------------------------------------------------
## Rabbit ##
		Install Helm 
			curl https://raw.githubusercontent.com/kubernetes/helm/master/scripts/get > get_helm.sh
			chmod 700 get_helm.sh
			./get_helm.sh

			helm init --service-account default --client-only

		Install Rabbit
			helm install stable/rabbitmq

			To Access the RabbitMQ AMQP port:

	    		kubectl port-forward --namespace default svc/falling-grasshopper-rabbitmq 5672:5672
	   	 		echo "URL : amqp://127.0.0.1:5672/"

			To Access the RabbitMQ Management interface:

	    		kubectl port-forward --namespace default svc/falling-grasshopper-rabbitmq 15672:15672
	    		echo "URL : http://127.0.0.1:15672/"

## SpringBoot ##

		kubectl apply -f kubernets/stock.yaml
		kubectl apply -f kubernetsecommerce.yaml
		kubectl apply -f kubernets/graphql.yaml

## Extras: ##
		Log
			kubectl logs -f --tail=20 <pod name>

		Lista os servicos
			minikube -p microservico service list

		Detalhe do servico		
			kubectl describe services/ecommerce-deployment

		Traz o ip do minikube
			minikube -p microservico ip