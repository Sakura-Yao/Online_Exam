// test js file
//问题解决

window.onload = function (){
    get_teachCourse("course-select");
    let question = {cou_Id:"LF46137944"};
    setTimeout(function (){
        $("#course-select option[value='"+question.cou_Id+"']").attr("selected", "selected");
    },100);
}
function qwe(){
    let question = {cou_Id:"LF46137944"};
    $("#course-select option[value='"+question.cou_Id+"']").attr("selected", "selected");
}

function message(){
    lightyear.loading('show');
    setTimeout(function (){
        // setTimeout(function (){
        //     window.location.href = "Login.html";
        // },1500);
        lightyear.loading('hide');
        lightyear.notify('添加成功，页面即将自动跳转','success',1000);
    }, $.ajax({
        url: localhostPath + "/api/question/showCountNum",
        type: "POST",
        data: {
            question_Id: "",
            cou_Id: "",
            type_Id: "",
            subject: "",
            degree: "",
            kwl_Id: "",
        },
        async:false,
        dataType: "json"
    }))
}

function test_num(){
    if (a.test(1.223)){
        console.log("123");
    }
    else {
        console.log("345");
    }
}

