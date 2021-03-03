let data = document.createElement('input'); 
data.setAttribute('type', 'hidden'); 
data.setAttribute('name', 'owner'); 

new Vue ({
    el : "#join",
    data : {
        status: "",
        owner : {
            no: null
        }
    },
    methods: {
        login : function(e) {
			var that = this;
	
            // 아이디 체크
            var idValue = document.getElementById("id").value;
            if(idValue == null || idValue == "" || idValue == undefined) {
                this.status = "아이디를 입력하세요.";
                return;
            }

            // 비밀번호 체크
            var passwordValue = document.getElementById("password").value;
            if(passwordValue == null || passwordValue == "" || passwordValue == undefined) {
                this.status = "비밀번호를 입력하세요.";
                return;
            }

			axios.post("http://localhost/api/json/getOwnerLogin", null,
				{ 
					params: {
						id : idValue,
						password : passwordValue
					}
				}).then(function(response) {
					that.owner = response.data;
				});

            if(that.owner.no == null) {
                e.preventDefault();
            }
        }
    }
});