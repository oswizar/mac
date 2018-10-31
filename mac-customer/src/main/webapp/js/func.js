var contextPath = "";
$(document).ready(function () {
    var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/mdd-web
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
//服务器前缀
    contextPath = localhostPaht + projectName;
    //alert(contextPath);
});


//用户注册
function addUser() {
    var username = $("#name").val();
    var password = $("#password").val();
    if (!username) {
        alert("账号不能为空" + contextPath);
    }
    else if (!password) {
        alert("密码不能为空");
    }
    else {
        var user = {
            "name": username,
            "password": password,
        };
        var _url = contextPath + "/user/showUser";
        $.ajax({
            url: _url,
            type: "POST",
            data: JSON.stringify(user),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var msg = data.msg;
                if (msg != "注册成功") {//注册失败
                    alert(msg);
                }
                else {//注册成功
                    alert(msg);
                    window.location.href = contextPath + "/user_index.html";
                }
            }
        });
    }

}

//用户登录
function loginUser() {
    var username = $("#name").val();
    var password = $("#password").val();
    if (!username) {
        alert("账号不能为空");
    }
    else if (!password) {
        alert("密码不能为空");
    } else {
        var user = {
            "name": username,
            "password": password,
        };
        var _url = contextPath + "/user/loginUser";
        $.ajax({
            url: _url,
            type: "POST",
            data: JSON.stringify(user),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var msg = data.msg;
                var user = data.user;
                if (msg != "登录成功") {//登录失败
                    alert(msg);
                }
                else {//登录成功
                    alert(msg);
                    window.sessionStorage.setItem("user", JSON.stringify(user));
                    window.location.replace(contextPath + "/user_ing.html");//不能返回上个页面
                    //window.location.href= contextPath+"/user_ing.html";//能返回上个页面
                }
            }
        });
    }
}

//修改用户
function updateUser() {
    var id = $("#id").val();
    var username = $("#name").val();
    var password = $("#password").val();
    if (!username) {
        alert("账号不能为空");
    }
    else if (!password) {
        alert("密码不能为空");
    }
    else {
        var user = {
            "id": id,
            "name": username,
            "password": password,
        };
        var _url = contextPath + "/user/updateUser";
        $.ajax({
            url: _url,
            type: "POST",
            data: JSON.stringify(user),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var msg = data.msg;
                if (msg != "修改成功") {
                    alert(msg);
                }
                else {
                    alert(msg);
                    removeSession();
                    window.location.replace(contextPath + "/user_index.html");
                }
            }

        });
    }

}

//删除确认提示
function deleteIt() {
    var msg = "你确定要删除当前账号吗?";
    if (confirm(msg) == true) {
        removeUser();  //确认删除
    } else {
        return false;
    }
}

//删除用户
function removeUser() {
    var id = $("#id").val();
    var username = $("#name").val();
    var password = $("#password").val();
    var _url = contextPath + "/user/removeUser";
    var user = {
        "id": id,
        "name": username,
        "password": password,
    };
    $.ajax({
        type: "POST",
        url: _url,
        data: JSON.stringify(user),
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            var msg = data.msg;
            if (msg != "删除成功") {
                alert(msg);
            }
            else {
                alert(msg);
                removeSession();
                window.location.href = contextPath + "/user_index.html";
            }
        }
    });
}

//销毁session
function removeSession() {
    window.sessionStorage.removeItem("user");
}