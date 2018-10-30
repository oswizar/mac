//用户注册
function addUser() {
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
            "name": username,
            "password": password,
        };
        var _url = "http://localhost:8080/os/user/showUser";
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
                    window.location.href = "http://localhost:8080/os/user_index.html";
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
        var _url = "http://localhost:8080/os/user/loginUser";
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
                    window.location.replace("http://localhost:8080/os/user_ing.html");//不能返回上个页面
                    //window.location.href= "http://localhost:8080/os/user_ing.html";//能返回上个页面
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
        var _url = "http://localhost:8080/os/user/updateUser";
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
                    window.location.replace("http://localhost:8080/os/user_index.html");
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
    var _url = "http://localhost:8080/os/user/removeUser";
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
                window.location.href = "http://localhost:8080/os/user_index.html";
            }
        }
    });
}

//销毁session
function removeSession() {
    window.sessionStorage.removeItem("user");
}