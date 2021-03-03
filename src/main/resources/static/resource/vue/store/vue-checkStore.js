const check = new Vue({
	el: "#storeOpen",
	data: {
		storeStatus: "",
		isOk : false
	},
	methods: {
		checkStore: function(value) {
			const that = this;
			const id = document.getElementById("name").value;
			if(id != "") {
				axios.post("http://localhost/api/json/getStoreStatus?storeName=" + id)
					.then(function (response) {
						if (response.data == null || response.data == "") {
							check.storeStatus = "등록이 가능한 이름입니다.";
							that.isOk = true;
							return;
						} else {
							check.storeStatus = "다른 가게 이름을 설정해주세요.";
							return;
						}
					});
			} else {
				this.storeStatus = "비어 있습니다";
			}
		}
	}
});