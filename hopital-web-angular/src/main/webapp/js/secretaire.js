(function() {
	var app = angular.module("secretaire", []);

	app
			.directive(
					"secretaire",
					function() {
						return {
							restrict : 'E',
							templateUrl : "secretaire.html",
							controller : function($http) {
								var self = this;
								self.secretaires = [];
								self.secretaire = null;

								self.ajout = true;
								
								self.medecins = [];

								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/secretaires'
									}).then(function success(response) {
										self.secretaires = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.secretaireForm.$setPristine();
									self.secretaire = {};
									self.ajout = true;
									self.listsecretaires();
								};

								self.edit = function(id) {
									self.ajout = false;
									self.secretaireForm.$setPristine();
									$http(
											{
												method : 'GET',
												url : 'api/secretaires/' + id
											}).then(function success(response) {
										self.secretaire = response.data;
										self.listsecretaires();
									}, function error(response) {

									});
								};

								self.save = function() {
									if (self.ajout) {
										$http({
											method : 'POST',
											url : 'api/secretaires/',
											data : self.secretaire
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/secretaires/',
											data : self.secretaire
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									}
								};

								self.remove = function(id) {
									$http(
											{
												method : 'DELETE',
												url : 'api/secretaires/' + id
											}).then(function success(response) {
										self.list();
									}, function error(response) {

									});

								};

								self.cancel = function() {
									self.secretaire = null;
								};

								self.listMedecins = function(id) {
									$http(
											{
												method : 'GET',
												url : 'api/secretaires/' + id + '/medecins/'
											}).then(function success(response) {
										self.medecins = response.data;
									}, function error(response) {

									});
								};

								self.list();
								self.listTypes();
							},
							controllerAs : "secretaireCtrl"
						};
					});
})();