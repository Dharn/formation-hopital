(function() {
	var app = angular.module("salle", []);

	app.directive("salle", function() {
		return {
			restrict : 'E',
			templateUrl : "salle.html"
			
			};
		});
})();