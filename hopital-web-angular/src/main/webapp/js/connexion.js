(function() {
	var app = angular.module("connexion", []);

	app.directive("connexion", function() {
		return {
			restrict : 'E',
			templateUrl : "connexion.html"
			
			};
		});
})();