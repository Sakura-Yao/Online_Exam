/**
 * @return {string}
 */
function formatDate(datetime) {
    var year=datetime.getFullYear();  //取得4位数的年份
    var month=((datetime.getMonth()+1)<10)?("0"+datetime.getMonth()+1):datetime.getMonth()+1;  //取得日期中的月份，其中0表示1月，11表示12月
    var date=(datetime.getDate()<10)?"0"+datetime.getDate():datetime.getDate();      //返回日期月份中的天数（1到31）
    var hour=(datetime.getHours()<10)?"0"+datetime.getHours():datetime.getHours();     //返回日期中的小时数（0到23）
    var minute=(datetime.getMinutes()<10)?"0"+datetime.getMinutes():datetime.getMinutes(); //返回日期中的分钟数（0到59）
    var second=(datetime.getSeconds()<10)?"0"+datetime.getSeconds():datetime.getSeconds(); //返回日期中的秒数（0到59）
    return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
}