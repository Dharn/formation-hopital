(function() {
	var app = angular.module("salle", []);

	app.directive("salle", function() {
		return {
			restrict : 'E',
			templateUrl : "salle.html"
			controller : function($http){
				var self = this;
				self.salles=[];
				self.salle=null;
					
				self.list = function(){
					$http({
						method : 'GET', 
						url : 'api/salles'
							
					}).then(function success(response){
						self.salles = response.data;
					}, function error(response){
							
					});
						
				};
					
				self.add = function(){
					self.salleForm.$setPristine();
					self.salle = {};
				};
				
				self.edit = function(){
					self.salleForm.$setPristine();
					$http({
						method : 'GET',			
						url : 'api/salles/'+id
						}).then(function success(response){
							self.salle = response.data;
						}, function error(response){
							
					});
				};
				
				self.save = function(){
					if (self.salle.id == null){
						$http({
							method : 'POST',
							url : 'api/salles/',
							data : self.salle
						}).then(function success(response){
							self.list();
							self.cancel();
						}, function error (response){
								
						});
					}else{
						$http({
							method : 'PUT',
							url : 'api/salles/',
							data : self.salle
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
			controllerAs : salleCtrl
		};
	});
})();