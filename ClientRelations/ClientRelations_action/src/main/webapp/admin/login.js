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
		url:"../staffLogin",
		data:loginForm,
		success:function(t){
			if (t.code== 0) {
				location.href = "index.jsp";
			}else{
				layer.msg(""+t.msg);
			}
		}
	})
})

/*$(".login-button").on('click',function(){
	location.href = "index.html";
})*/
