(function() {
	var app = angular.module("disponibilite", []);

	app
			.directive(
					"disponibilite",
					function() {
						return {
							restrict : 'E',
							templateUrl : "disponibilite.html",
							controller : function($http) {
								var self = this;
								self.disponibilites = [];
								self.disponibilite = null;

								self.ajout = true;
<<<<<<< HEAD

								self.medecins = [];
=======
								
								self.medecinlist = [];
>>>>>>> 4f640c487129d0e01f989f65197573583500cfaf

								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/disponibilites'
									}).then(function success(response) {
										self.disponibilites = response.data;
									}, function error(response) {

									});
								};
<<<<<<< HEAD
=======
								
								self.medecinlist = function(idMedecin) {
									$http({
										method : 'GET',
										url : 'api/disponibilites/medecin=' + idMedecin
									}).then(function success(response) {
										self.disponibilites = response.data;
									}, function error(response) {

									});
								};
>>>>>>> 4f640c487129d0e01f989f65197573583500cfaf

								self.add = function() {
									self.disponibiliteForm.$setPristine();
									self.disponibilite = {};
									self.ajout = true;
									self.listMedecins();
								};

								self.edit = function(convention, code) {
=======
									self.listdisponibilites();
								};

								self.edit = function(id) {
>>>>>>> 4f640c487129d0e01f989f65197573583500cfaf
									self.ajout = false;
									self.disponibiliteForm.$setPristine();
									$http(
											{
												method : 'GET',
<<<<<<< HEAD
												url : 'api/disponibilites/'
											}).then(function success(response) {
										self.disponibilite = response.data;
										self.listMedecins();
=======
												url : 'api/disponibilites/' + id
											}).then(function success(response) {
										self.disponibilite = response.data;
										self.listdisponibilites();
>>>>>>> 4f640c487129d0e01f989f65197573583500cfaf
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