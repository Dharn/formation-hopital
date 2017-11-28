(function() {
	var app = angular.module("medecin", []);

	app
			.directive(
					"medecin",
					function() {
						return {
							restrict : 'E',
							templateUrl : "medecin.html",
							controller : function($http) {
								var self = this;
								self.medecins = [];
								self.medecin = null;

								self.ajout = true;

								self.conventions = [];

								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/medecins'
									}).then(function success(response) {
										self.medecins = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.medecinForm.$setPristine();
									self.medecin = {};
									self.ajout = true;
									self.conventions();
								};

								self.edit = function(convention, code) {
									self.ajout = false;
									self.medecinForm.$setPristine();
									$http(
											{
												method : 'GET',
												url : 'api/medecins/'
											}).then(function success(response) {
										self.medecin = response.data;
										self.conventions();
									}, function error(response) {

									});
								};

								self.save = function() {
									if (self.ajout) {
										$http({
											method : 'POST',
											url : 'api/medecins/',
											data : self.medecin
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/medecins/',
											data : self.medecin
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
												url : 'api/medecins/'
											}).then(function success(response) {
										self.list();
									}, function error(response) {

									});

								};

								self.cancel = function() {
									self.medecin = null;
								};

								self.listTypes = function() {
									$http({
										method : 'GET',
										url : 'api/conventions'
									}).then(function success(response) {
										self.conventions = response.data;
									}, function error(response) {

									});
								};

								self.list();
								self.listTypes();
							},
							controllerAs : "medecinCtrl"
						};
					});
})();