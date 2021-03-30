
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

function get_user_type(typeId){
    var data = "";
    $.ajax({
        url:"http://localhost/api/UserType/SelectUserType_Id",
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

$(".url").click(function () {
    $("#left_menu_title").html($(this).text());
    var targetURL = $(this).attr("url");
    if(targetURL == null){
        alert("功能暂未发布");
    }
    document.getElementById("Location").src = targetURL;
})