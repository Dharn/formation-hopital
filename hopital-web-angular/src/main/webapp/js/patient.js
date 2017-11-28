(function() {
	var app = angular.module("patient", []);

	app.directive("patient", function() {
		return {
			restrict : 'E',
			templateUrl : "patient.html"
			
			};
		});
})();