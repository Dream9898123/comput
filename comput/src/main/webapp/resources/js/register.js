$(function() {
	// 短信验证码倒计时
	var countdownHandler = function() {
		var $button = $(".sendVerifyCode");
		var number = 60;
		var countdown = function() {
			if (number == 0) {
				$button.attr("disabled", false);
				$button.html("发送验证码");
				number = 60;
				return;
			} else {
				$button.attr("disabled", true);
				$button.html(number + "秒 重新发送");
				number--;
			}
			setTimeout(countdown, 1000);
		}
		setTimeout(countdown, 1000);
	}
	// 发送短信验证码
	$(".sendVerifyCode").on("click", function() {
		var $mobile = $("input[name=phone]");
		var data = {};
		data.mobile = $.trim($mobile.val());
		if (data.mobile == '') {
			alert('请输入手机号码');
			return;
		}
		var reg = /^1\d{10}$/;
		if (!reg.test(data.mobile)) {
			alert(data.mobile);
			return;
		}
		$.ajax({
			url : getBasePath() + "/sendSms",
			async : true,
			type : "post",
			dataType : "text",
			data : data,
			success : function(data) {
				if (data == 'success') {
					countdownHandler();
					return;
				}
				alert(data);
			}
		});
	})
	// 提交
	$(".sub-btn").on("click", function() {
		var data = {};
		data.name = $.trim($("input[name=name]").val());
		data.sex = $.trim($("input:radio[name='sex']:checked").val());
		data.age = $.trim($("select[name=age]").val());
		data.password = $.trim($("input[name=password]").val());
		data.mobile = $.trim($("input[name=phone]").val());
		data.verifyCode = $.trim($("input[name=verifyCode]").val());
		data.yuedu = $.trim($("input:checkbox[name='yuedu']:checked").val());
		if (data.age == '请选择') {
			alert("请选择年龄");
			return;
		}
		if (data.name == '') {
			alert("请输入姓名");
			return;
		}
		if (data.password == '') {
			alert("请输入密码");
			return;
		}
		if (data.mobile == '') {
			alert("请输入手机号");
			return;
		}
		if (data.verifyCode == '') {
			alert("请输入验证码");
			return;
		}
		if (data.yuedu == '') {
			alert("请勾选我同意协议");
			return;
		}
		$.ajax({
			url : getBasePath() + "/register",
			async : true,
			type : "post",
			dataType : "text",
			data : data,
			success : function(data) {
				if (data == 'success') {
					alert("恭喜，注册成功");
					window.location.href=getBasePath() + "/indexpage";
					return;
				} else if (data == 'mfail') {
					alert("手机号错误");
					return;
				} else if (data == 'cfail') {
					alert("验证码错误");
					return;
				} else if (data == 'tfail') {
					alert("验证码过期了");
					return;
				} 
				alert("系统故障，联系管理员");
			}
		});
	})
});
