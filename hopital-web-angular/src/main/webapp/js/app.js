(function() {
	var app = angular.module("hopitalApp", [ "connexion" ,"patient","adminSalle","medecin","adminConsultation",
		"specialite","medecinConsultation","secretaireConsultation"]);
	
	
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
