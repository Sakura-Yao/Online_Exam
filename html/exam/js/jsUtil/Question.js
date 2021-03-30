/**
 * 添加试题-预览所选科目
 */
function preview_course(){
    if ($('#course-select').val()==='') {
        $("#preview-course").empty();
        $("#preview-kwl").empty();
    } else {
        get_knowledge_select($('#course-select').val(), 'knowledge-select');
        $("#preview-course").html($("#course-select option:selected").html() + ' (' + $("#course-select").val() + ')');
        $("#preview-kwl").html('');
    }
}

/**
 * 添加试题-预览所选知识点
 */
function preview_kwl(){
    $("#preview-kwl").html($("#knowledge-select option:selected").html());
}

/**
 * 添加试题-预览难度系数
 */
function preview_degree(){
    if (check_degree_val('degree-input')){
        $("#preview-degree").html($("#degree-input").val());
    }
}

function question_update_onload_function() {
    let question = get_updateQuestionInfo_Val(GetRequest().question_Id);
    get_teachCourse("course-select");
    get_knowledge_select(question.cou_Id, 'knowledge-select');
    console.log(question);
    $("#question_Id").val(question.id);
    $("#type_Id").val(question.type_Id);
    setTimeout(function (){
        $("#course-select option[value='"+question.cou_Id+"']").attr("selected", "selected");
        $("#knowledge-select option[value='"+question.kwl_Id+"']").attr("selected", "selected");
    },200);
    $("#preview-course").html(question.cou_Name+" ("+question.cou_Id+")");
    $("#preview-kwl").html(question.kwl_Name);
    $("#subject-input").val(question.subject);
    $("#preview-question").html(question.subject);
    UE.getEditor('question').setContent(question.subject);

    $("#preview-choice_a").html(question.choice_A);
    $("#choice-a-input").val(question.choice_A);

    $("#preview-choice_b").html(question.choice_B);
    $("#choice-b-input").val(question.choice_B);

    $("#preview-choice_c").html(question.choice_C);
    $("#choice-c-input").val(question.choice_C);

    $("#preview-choice_d").html(question.choice_D);
    $("#choice-d-input").val(question.choice_D);

    $("#preview-answer").html(question.answer);
    $("#answer-input").val(question.answer);
    if (question.type_Id !== '1f45bd0005c541b998731546b3b8909a'){
        $("#not_single").show();
        UE.getEditor('answer').setContent(question.answer);
    } else {
        $("#single").show();
        $("#single_options").show();
        $("#preview-single-options").show();
        UE.getEditor('choice_a').setContent(question.choice_A);
        UE.getEditor('choice_b').setContent(question.choice_B);
        UE.getEditor('choice_c').setContent(question.choice_C);
        UE.getEditor('choice_d').setContent(question.choice_D);
        let index = 1;
        if (question.answer === 'A')
            index = 0;
        if (question.answer === 'B')
            index = 1;
        if (question.answer === 'C')
            index = 2;
        if (question.answer === 'D')
            index = 3;
        $("input:radio[name=answer]")[index].checked=true;
    }

    $("#preview-analysis").html(question.analysis);
    $("#analysis-input").val(question.analysis);
    UE.getEditor('analysis').setContent(question.analysis);

    $("#preview-degree").html(question.degree);
    $("#degree-input").val(question.degree);
}