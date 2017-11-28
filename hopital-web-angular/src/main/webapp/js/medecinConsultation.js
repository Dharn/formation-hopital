(function() {
	var app = angular.module("medecinConsultation", []);

	app.directive("consultation", function() {
		return {
			restrict:'E',
			templateUrl:"medecinConsultation.html",
			controller : function($http) {
				var self = this;
				self.consultations = [];
				self.consultation = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'api/consultations'
					}).then(function success(response) {
						self.consultations = response.data; 
					}, function error(response) {

					});
				};
				
				self.remove = function(id) {
					$http({
						method : 'DELETE',
						url : 'api/consultations/'+id
					}).then(function success(response) {
						self.list();
					}, function error(response) {

					});
					
					
				};

				self.cancel = function() {
					self.formation = null;
				};
				
				self.list();
			},
			controllerAs : "consultationCtrl"
		};
	});
})();