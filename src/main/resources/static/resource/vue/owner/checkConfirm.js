new Vue({
	el: "#chkBtn",
	data: {
		idStatus: "",
		idData: null,
		emailStatus: "",
		emailData: null
	},
	methods: {
		checkId: function() {
			var that = this;

			// 아이디 비어 있는지 체크
			var id = document.getElementById("owner-id").value;
			if (id == "" || id == null || id == undefined) {
				that.idStatus = "아이디를 입력하세요.";
				return;
			}

			// 중복된 아이디 확인
			axios.post("http://localhost/api/json/getOwnerId?id=" + id)
				.then(function(response) {
					if (response.data == null || response.data == "") {
						that.idStatus = "아이디 생성이 가능합니다.1";
						that.idData = response.data;
					} else {
						that.idStatus = "아이디 생성이 불가능합니다.2";
						that.idData = response.data;
					}
				});

			// 아이디 생성 여부
			if (that.idData == "") {
				that.idStatus = "아이디 생성이 가능합니다.3";
			} else if (that.idData != null) {
				that.idStatus = "아이디 생성이 불가능합니다.4";
			}
		},
		checkEmail: function() {
			var that = this;

			var emailHead = document.getElementById("email-head").value;
			var email = document.getElementById("email").value;
			if (emailHead == "" || emailHead == null) {
				that.emailStatus = "이메일 입력하세요.";
			}
			if (email == "" || email == null) {
				that.emailStatus = "이메일 주소를 입력하세요.";
			} else {
				axios.post("http://localhost/api/json/getOwnerEmail?email=" + email)
					.then(function(response) {
						if (response.data == null || response.data == "") {
							that.emailStatus = "이메일 생성이 가능합니다.1";
							that.emailData = response.data;
						} else {
							that.emailStatus = "아이디 생성이 불가능합니다.2";
							that.emailData = response.data;
						}
				});
			}
			
			// 이메일 생성 여부
			if (that.emailData == "") {
				that.emailStatus = "이메일 생성이 가능합니다.3";
			} else if (that.emailData != null) {
				that.emailStatus = "이메일 생성이 불가능합니다.4";
			}
		}
	}
});