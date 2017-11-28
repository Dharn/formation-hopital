(function() {
	var app = angular.module("connexion", []);

	app.directive("connexion", function() {
		return {
			restrict : 'E',
			templateUrl : 'mir.html',
			controller : function() {

			},
			controllerAs: 'connexionCtrl'
		};
	});
})();