(function() {
	var app = angular.module("adminSalle", []);

	app.directive("salle", function() {
		return {
			restrict : 'E',
			templateUrl : "salle.html",
			controller : function($http){
				var self = this;
				self.patients=[];
				self.patient=null;
				self.salleSpecialites = [];
				
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
					self.listSalleSpecialites();
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
				
				self.show = function(){
					$http({
						method : 'GET', 
						url : 'api/salles'+id
						
					}).then(function success(response){
						self.salle = response.data;
					}, function error(response){
						
					});
					
				};
				
//				self.listSalleSpecialites = function() {
//					$http({
//						method : 'GET',
//						url : 'api/'
//					}).then(function success(response) {
//						self.salleSpecialites = response.data;
//						
//					}, function error(response) {
//
//					});
//				};
				
				self.list();
				self.salleSpecialites();
				
			},
			controllerAs : patientCtrl
		};
	});
})();