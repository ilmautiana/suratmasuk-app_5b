
var cobaApp = angular.module('CobaApp', []);

cobaApp.controller('CobaController', function($scope){
	$scope.daftarJudul = [];
	$scope.tambah = function(){
		$scope.daftarJudul.push($scope.judul);
	}
});

cobaApp.controller('ApiController', 
	    function($scope, $http, $window) {
	    	$scope.daftarSuratmasuk = [];

	    	$scope.updateData = function() {
	    		$http.get('/daftar-suratmasuk')
	    			.then(sukses, gagal);

	    		function sukses(response) {
	    			console.log(response);
	    			$scope.daftarSuratmasuk = response.data;
	    		};	

	    		function gagal(response) {
	    			console.log(response);
	    		};
	    	};

	    	$scope.ubah = function(stm) {
	    		//console.log(mhs);
	    		$window.location.href = "/edit?id=" + stm.id;
	    	};

	    	$scope.hapus = function(stm) {
	    		$http.delete('/hapus/' + stm.id).then(sukses, gagal);

	    		function sukses(response) {
	    			$scope.updateData();
	    		};

	    		function gagal(response) {};
	    	};

	    	$scope.updateData();
		}
	);