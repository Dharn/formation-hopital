(function() {
	var app = angular.module("specialite", []);

	app
			.directive(
					"specialite",
					function() {
						return {
							restrict : 'E',
							templateUrl : "specialite.html",
							controller : function($http) {
								var self = this;
								self.specialites = [];
								self.specialite = null;

								self.ajout = true;

								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/specialites'
									}).then(function success(response) {
										self.specialites = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.specialiteForm.$setPristine();
									self.specialite = {};
									self.ajout = true;
								};

								self.edit = function(type, code) {
									self.ajout = false;
									self.specialiteForm.$setPristine();
									$http(
											{
												method : 'GET',
												url : 'api/specialites/'
											}).then(function success(response) {
										self.specialite = response.data;
									}, function error(response) {

									});
								};

								self.save = function() {
									if (self.ajout) {
										$http({
											method : 'POST',
											url : 'api/specialites/',
											data : self.specialite
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/specialites/',
											data : self.specialite
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
												url : 'api/specialites/'
											}).then(function success(response) {
										self.list();
									}, function error(response) {

									});

								};

								self.cancel = function() {
									self.specialite = null;
								};

								self.list();
							},
							controllerAs : "specialiteCtrl"
						};
					});
})();