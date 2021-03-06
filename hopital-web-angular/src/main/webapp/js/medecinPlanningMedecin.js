(function() {
	var app = angular.module("plannigMedecin", []);

	app
			.directive(
					"plannigMedecin",
					function() {
						return {
							restrict : 'E',
							templateUrl : "plannigMedecin.html",
							controller : function($http) {
								var self = this;
								self.disponibilites = [];
								self.disponibilite = null;

								self.ajout = true;

								self.medecins = [];
								
								self.medecinlist = [];

								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/disponibilites'
									}).then(function success(response) {
										self.disponibilites = response.data;
									}, function error(response) {

									});
								};
								
								self.medecinlist = function(idMedecin) {
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
									self.listMedecins();
								};

								self.edit = function(convention, code) {
									self.listdisponibilites();
								};

								self.edit = function(id) {
									self.ajout = false;
									self.disponibiliteForm.$setPristine();
									$http(
											{
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

								self.listMedecins = function() {
									$http(
											{
												method : 'GET',
												url : 'api/medecins/'
														+ (self.disponibilite.medecin ? self.disponibilite.medecin.id
														: '')
											}).then(function success(response) {
										self.medecins = response.data;
									}, function error(response) {

									});
								};

								self.list();
							},
							controllerAs : "disponibiliteCtrl"

						};
					});
})();