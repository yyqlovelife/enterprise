const baseurl="http://106.55.63.99:8080/api/"
function cambiar_login() {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
    document.querySelector('.cont_form_login').style.display = "block";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";

    setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);
  
    setTimeout(function(){
    document.querySelector('.cont_form_sign_up').style.display = "none";},200);
}

function apply() {
    var id1=$("#id1").val();
    var password1=$("#password1").val();
    var card_number1=$("#card_number1").val();
    var score_number1=$("#score_number1").val();

    if(id1==''){
        alert('您的用户名不能为空！');
        return false;
    }
    if(score_number1==''){
        alert('授信额度不能为空！');
        return false;
    }
    if(card_number1==''){
        alert('银行卡号不能为空！');
        return false;
    }
    if(password1==''){
        alert('您的密码不能为空！');
        return false;
    }
    else {
        $.ajax({
            type: "POST",//HTTP请求方法类型
            dataType: "json",//预期前端发给后端的数据类型
            contentType:"application/json",
            url: baseurl+"applyscore",//url地址
            data: JSON.stringify({
                'id1': id1, 'password1': password1,
                'card_number1': card_number1, 'score_number1': score_number1
            }),
            success: function (result) {
                if(result.statecode==1){
                    alert('用户名密码错误，请重新操作')
                };
                if (result.statecode == 3) {
                    alert('授信成功，请前往查询核实')
                }
                ;
            },
            error: function () {
                alert("授信异常！");
            }
        });
    }
}

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  

}    

function convert() {
    var id2=$("#id2").val();
    var password2=$("#password2").val();
    var card_number2=$("#card_number2").val();
    var score_number2=$("#score_number2").val();

    if(id2==''){
        alert('您的用户名不能为空！');
        return false;
    }
    if(score_number2==''){
        alert('承兑额度不能为空！');
        return false;
    }
    if(card_number2==''){
        alert('银行卡号不能为空！');
        return false;
    }
    if(password2==''){
        alert('您的密码不能为空！');
        return false;
    }
    else {
        $.ajax({
            type: "POST",//HTTP请求方法类型
            dataType: "json",//预期前端发给后端的数据类型
            contentType:"application/json",
            url: baseurl+"convert",//url地址
            data: JSON.stringify({
                'id2': id2, 'password2': password2,
                'card_number2': card_number2, 'score_number2': score_number2
            }),
            success: function (result) {
                if(result.statecode==1){
                    alert('用户名密码错误，请重新操作')
                };
                if(result.statecode==2){
                    alert('您的积分余额不足')
                }
                if (result.statecode == 3) {
                    alert('承兑成功，请前往查询核实')
                }
                ;
            },
            error: function () {
                alert("承兑异常！");
            }
        });
    }
}


function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
}



function showscoreE() {
    var id=$("#id").val();
    var password=$("#password").val();


    if(id==''){
        alert('您的用户名不能为空！');
        return false;
    }
    if(password==''){
        alert('您的密码不能为空！');
        return false;
    }
    else {
        console.log(id,password);
        $.ajax({
            type: "get",//HTTP请求方法类型
            dataType: "json",//预期前端发给后端的数据类型
            url: baseurl+"showscoreE",//url地址
            data: {
                'id': id, 'password': password
            },
            success: function (result) {
                if(result.statecode==1){
                    alert('用户名密码错误，请重新操作')
                };
                if (result.statecode == 3) {
                    alert('您的积分数额为：' + result.score_number)
                }
                ;
            },
            error: function () {
                alert("查询异常！");
            }
        });
    }
}