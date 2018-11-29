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

document.onkeydown = function (e) {
    if (!e) e = window.event;
    if ((e.keyCode || e.which) == 13) {
    	$(".login-button").click();
    }
}

$(".login-button").click(function(){
	var loginForm = $(".login-form").serialize();
	$.ajax({
		type:"post",
		url:"/ClientRelations_action/staffLogin",
		data:loginForm,
		success:function(t){
			if (t.code== 0) {
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
