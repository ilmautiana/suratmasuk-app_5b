cobaApp.controller('EditController', 
	    function($scope, $http, $window) {

	$scope.stm = {};

	$scope.simpan = function() {
		//console.log($scope.stm);
		$http.post('/simpan', $scope.stm).then(sukses, gagal);

		function sukses(response) {
			$window.location.href = "/";
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.batal = function() {
		$window.location.href = "/";
	};

	$scope.muat = function() {
		var id = $window.location.search.split("=")[1];
		$scope.stm.id = id;

		$http.get('/ambil-data-stm/' + id).then(sukses, gagal);

		function sukses(response) {
			//console.log(response.data);
			$scope.stm = response.data;
		};

		function gagal(response) {};

	};

	$scope.muat();

});