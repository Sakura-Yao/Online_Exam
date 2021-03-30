var curWwwPath = window.document.location.href;
var pathname= window.document.location.pathname;
var pos = curWwwPath.indexOf(pathname);
var localhostPath = curWwwPath .substring(0,pos);

/**
 * 验证提交表单的完整性
 * @param obj
 * @returns {boolean}
 */
// function check_submit(obj){
//     if (Object.values(obj).indexOf("") !== -1){
//         return true;
//     } else {
//         return true;
//     }
// }

/**
 * 登录方法
 * @param use_id
 * @param password
 * @constructor
 */
function Login(use_id,password) {
    $.ajax({
        url:localhostPath+"/api/UserLogin",
        type:"POST",
        data:{
            user_Id:use_id,
            password:password
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === 1){
                window.location.href="index.html";
            }
            else{
                alert(res.message);
                window.location.href="Login.html";
            }
        }
    })
}

/**
 * 获取登录Session
 * @returns {string}
 */
function get_session() {
    var User = "";
    $.ajax({
        url:localhostPath+"/api/getSession",
        type:"POST",
        async:false,
        data:{
            key:'login_session'
        },
        dataType: "json",
        success:function (res) {
            User = res.session_data;
        }
    });
    return User;
}


/**
 * 根据type_Id进行权限判断，显示不同的功能
 * @param typeId
 */
function test_nav(typeId) {
    var type = get_user_type(typeId);
    var Secretary = document.getElementById("Secretary");
    var Teacher = document.getElementById("Teacher");
    var Student = document.getElementById("Student");
    if (type === '教学秘书'){
        Secretary.style.display='block';
    }
    else if (type === '教师'){
        Teacher.style.display='block';
    }
    else {
        Student.style.display='block';
    }
}

/**
 * 获取用户的类型信息
 * @param typeId
 * @returns {string}
 */
function get_user_type(typeId){
    var data = "";
    $.ajax({
        url:localhostPath+"/api/UserType/SelectUserType_Id",
        type:"POST",
        async:false,
        data:{
            Id:typeId
        },
        dataType: "json",
        success:function (res) {
            data = res.data;
        }
    });
    return data;
}

/**
 * 功能跳转
 */
$(".url").click(function () {
    $("#left_menu_title").html($(this).text());
    var targetURL = $(this).attr("url");
    if(targetURL == null){
        alert("功能暂未发布");
    }
    document.getElementById("Location").src = targetURL;
})

//对话框弹出
//需要引入如下内容
//<link rel="stylesheet" href="js/jconfirm/jquery-confirm.min.css">
//<link href="css/style.min.css" rel="stylesheet">
//<script src="js/jconfirm/jquery-confirm.min.js"></script>
//<script type="text/javascript" src="js/main.min.js"></script>
function successAlert() {
    $.confirm({
        title: '成功',
        content: '验证成功',
        type: 'green',
        buttons: {
            omg: {
                text: '确认',
                btnClass: 'btn-green',
                action: function(){
                }
            },
            close: {
                text: '关闭'
            }
        }
    });
}

function successPostAlert() {
    $.confirm({
        title: '成功',
        content: '提交成功',
        type: 'green',
        buttons: {
            omg: {
                text: '确认',
                btnClass: 'btn-green',
                action: function(){
                }
            },
            close: {
                text: '关闭'
            }
        }
    });
}

function wrongAlert()  {
    $.confirm({
        title: '错误提示',
        content: '验证错误',
        type: 'red',
        typeAnimated: true,
        buttons: {
            tryAgain: {
                text: '重试',
                btnClass: 'btn-red',
                action: function(){
                }
            },
            close: {
                text: '关闭'
            }
        }
    });
}

function errorAlert()  {
    $.confirm({
        title: '警告',
        content: '请重试',
        type: 'orange',
        typeAnimated: false,
        buttons: {
            omg: {
                text: '重试',
                btnClass: 'btn-orange',
            },
            close: {
                text: '关闭',
            }
        }
    });
}

function successUpLoadAlert(Total_num,Success_num,Time_spent) {
    $.confirm({
        title: '成功',
        content: '提交成功,总条数：'+Total_num+'，成功条数：'+Success_num+'，所用时间：'+Time_spent+'s',
        type: 'green',
        buttons: {
            omg: {
                text: '确认',
                btnClass: 'btn-green',
                action: function(){
                    window.location.href="/Teacher/batch_teacher.html";
                }
            },
            close: {
                text: '关闭'
            }
        }
    });
}