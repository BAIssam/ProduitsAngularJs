//Module angular qu'on va appeler MyApp
var app=angular.module("MyApp",['ui.router','ngMessages']);

//Cette config se charge au démarrage de l'application avant le controller
app.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state('home', {
		url:'/home',
		templateUrl:'views/home.html',
		controller:'HomeController'
	});
	
	$stateProvider.state('chercher', {
		url:'/chercher',
		templateUrl:'views/chercher.html',
		controller:'MyController'
	});
	
	$stateProvider.state('newProduit', {
		url:'/newProduit',
		templateUrl:'views/newProduit.html',
		controller:'NewProduitController'
	});
});

app.controller("HomeController", function(){
	
});

app.controller("NewProduitController", function($scope, $http){
	//produit = un objet vide {} ou avec des valeurs pas défaut
	$scope.produit={designation:"",prix:0.0,quantite:0};
	$scope.mode=0;
	$scope.listCategorie=[];
	$scope.selectedCateg=null;
	$scope.listCountry=[];
	$scope.listState=[];
	
	$scope.saveProduit = function(){
		//$http.post("http://localhost:8080/produits",$scope.produit,$scope.produit.categorie)
		$http.post("http://localhost:8080/produits/categ/" + $scope.selectedCateg ,$scope.produit)
		.then(function(response){
			$scope.produit=response.data;
			$scope.mode=1;
		}
		,function(error){
			console.log(error);
		}
		);
	}
	
	$scope.chargerCategories = function(){			
		$http.get("http://localhost:8080/categories")
		.then(function(response){
			$scope.listCategorie = response.data;
		}
		,function(error){
			console.log(error);
		}
		);
	}
	
	$scope.getSelectedCateg = function(item){
		$scope.selectedCateg=item.id;
		//console.log(item.id);
	}
	
	$scope.modeForm = function(){
		//pour ne pas afficher le formulaire avec les anciennes valeurs
		//Il faut initialiser produit par un objet vide {}
		//ou mettre des valeurs par défaut
		$scope.produit={designation:"",prix:0.0,quantite:0};
		$scope.mode=0;
	}
	
	$scope.chargerCountry = function(){
		$http.get("http://localhost:8080/pays")
		.then(function(response){
			$scope.listCountry = response.data;
		}
		,function(error){
			console.log(error);
		}
		);
	}
	
	$scope.chargerState = function(item){
		$http.get("http://localhost:8080/state/country/" + item.id)
		.then(
		function(response){
			$scope.listState = response.data;
		}
		,function(error){
			console.log(error);
		}
		);
	}
});

//Controller, on va lui passer comme paramaètre une fonction javaScript
//Angular nous fournit des service
//Dans cette fonction, on va injecter le service scope (C'est le model qui va stocker les données)
//le service http pour envoyer des requêtes au serveur
app.controller("MyController", function($scope, $http){
	
	$scope.pageProduits=[];
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=4;
	$scope.pages=[];
	
	$scope.chercherProduits = function(){
		
		$http.get("http://localhost:8080/chercherProduits?mc="+$scope.motCle+
				"&page="+$scope.pageCourante+"&size="+$scope.size)
		.then(function(response){
			$scope.pageProduits=response.data;
			$scope.pages= new Array(response.data.totalPages);
		}
		,function(error){
			console.log(error);
		}
		);	
	}
	
	//Associer cette fonction au bouton chercher
	$scope.getProduits = function(){
		//Après chaque clique de bouton on va revenir sur la page 0
		$scope.pageCourante=0;
		$scope.chercherProduits();
	}
	
	$scope.goToPage = function(p){
		$scope.pageCourante=p;
		$scope.chercherProduits();
	}
	
	
});