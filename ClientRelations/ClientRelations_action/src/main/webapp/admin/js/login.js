layui.define(['element'],function(exports){

    var $ = layui.$;
    $('.input-field').on('change',function(){
        var $this = $(this),
            value = $.trim($this.val()),
            $parent = $this.parent();

        if(value !== '' && !$parent.hasClass('field-focus')){
            $parent.addClass('field-focus');
        }else{
            $parent.removeClass('field-focus');
        }
    })
    exports('login');
});

$(".login-button").click(function(){
	var loginForm = $(".login-form").serialize();
	$.ajax({
		type:"post",
		url:"../enterAdminAction",
		data:loginForm,
		success:function(t){
			layer.msg(t.msg);
			if (t.msg=="登录成功") {
				location.href = "index.jsp";
			}else{
				layer.msg("账号或密码错误");
			}
		}
	})
	console.log(loginForm);
})

/*$(".login-button").on('click',function(){
	location.href = "index.html";
})*/
