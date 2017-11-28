(function() {
	var app = angular.module("disponibilite", []);

	app.directive("disponibilite", function() {
						return {
							restrict : 'E',
							templateUrl : "disponibilite.html",
							controller : function($http) {
								var self = this;
								self.disponibilites = [];
								self.disponibilite = null;

								self.ajout = true;

								self.list = function(idMedecin) {
									$http({
										method : 'GET',
										url : 'api/disponibilites/medecin=' + idMedecin
									}).then(function success(response) {
										self.disponibilites = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.disponibiliteForm.$setPristine();
									self.disponibilite = {};
									self.ajout = true;
									self.listdisponibilites();
								};

								self.edit = function(id) {
									self.ajout = false;
									self.disponibiliteForm.$setPristine();
									$http({
												method : 'GET',
												url : 'api/disponibilites/' + id
											}).then(function success(response) {
										self.disponibilite = response.data;
										self.listdisponibilites();
									}, function error(response) {

									});
								};

								self.save = function() {
									if (self.ajout) {
										$http({
											method : 'POST',
											url : 'api/disponibilites/',
											data : self.disponibilite
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/disponibilites/',
											data : self.disponibilite
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
												url : 'api/disponibilites/' + id
											}).then(function success(response) {
										self.list();
									}, function error(response) {

									});

								};

								self.cancel = function() {
									self.disponibilite = null;
								};

								self.list();
								self.listTypes();
							},
							controllerAs : "medecinDisponibiliteCtrl"
						};
					});
})();