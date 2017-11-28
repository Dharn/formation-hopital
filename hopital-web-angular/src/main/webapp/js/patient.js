(function() {
	var app = angular.module("patient", []);

	app.directive("patient", function() {
		return {
			restrict : 'E',
			templateUrl : "patient.html",
			controller : function($http){
				var self = this;
				self.patients=[];
				self.patient=null;
				
				self.list = function(){
					$http({
						method : 'GET', 
						url : 'api/patients'
						
					}).then(function success(response){
						self.patients = response.data;
					}, function error(response){
						
					});
					
				};
				
				self.add = function(){
					self.patientForm.$setPristine();
					self.patient = {};
				};
				
				self.edit = function(){
					self.patientForm.$setPristine();
					$http({
						method : 'GET',
						url : 'api/patients/'+id
					}).then(function success(response){
						self.patient = response.data;
					}, function error(response){
						
					});
				};
				
				self.save = function(){
					if (self.patient.id == null){
						$http({
							method : 'POST',
							url : 'api/patients/',
							data : self.patient
						}).then(function success(response){
							self.list();
							self.cancel();
						}, function error (response){
							
						});
					}else{
						$http({
							method : 'PUT',
							url : 'api/patients/',
							data : self.patient
						}).then(function success(response) {
							self.list();
							self.cancel();
						}, function error(response) {

						});
					}
				};
				
				self.remove = function(id) {
					$http({
						method : 'DELETE',
						url : 'api/patients/'+id
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
			controllerAs : patientCtrl
		};
	});
})();