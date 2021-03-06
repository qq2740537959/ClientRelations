layui.define(['element'],function(exports){

    var $ = layui.$;
    $('.input-field').on('change',function(){
        var $this = $(this),
            value = $.trim($this.val()),
            $parent = $this.parent();

        if(value !== ''){
            $parent.addClass('field-focus');
        }else{
            $parent.removeClass('field-focus');
        }
    })
    exports('login');
});

document.onkeydown = function (e) {
    if (!e) e = window.event;
    if ((e.keyCode || e.which) == 13) {
    	$(".login-button").click();
    }
}

$(".login-button").click(function(){
	var username = $("#username").val();
	var password = $("#password").val();
	if (username == "" || username == null) {
		layer.msg("请输入用户名！",{
			anim:6
		});
		return ;
	}
	if (password == "" || password == null) {
		layer.msg("请输入密码",{
			anim:6
		});
		return ;
	}
	var loginForm = $(".login-form").serialize();
	var index;
	$.ajax({
		type:"post",
		url:"/ClientRelations_action/staffLogin",
		data:loginForm,
		beforeSend: function () {
        	index = index = layer.load(0, {time: 10*1000});
        },
		success:function(t){
			layer.close(index);
			if (t.code== 0) {
				layer.msg(""+t.msg);
				location.href = "admin/index.jsp";
			}else{
				layer.msg(""+t.msg);
			}
		}
	})
})

/*$(".login-button").on('click',function(){
	location.href = "index.html";
})*/
