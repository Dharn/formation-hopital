(function() {
	var app = angular.module("hopitalApp", []);
	
	app.directive("connexion", function() {
		return {
			restrict : 'E',
			templateUrl : 'mir.html',
			controller : function() {
				
				var self = this;
				
				self.utilisateurConnexion = null;

			},
			controllerAs: 'connexionCtrl'
		};
	});
	
	app.factory('AuthInterceptor', [ function() {
		return {
			// Send the Authorization header with each request
			'request' : function(config) {
				config.headers = config.headers || {};
				var encodedString = btoa("admin:admin");
				config.headers.Authorization = 'Basic ' + encodedString;
				return config;
			}
		};
	} ]);

	app.config(function($httpProvider) {
		$httpProvider.interceptors.push('AuthInterceptor');
	});


})();
