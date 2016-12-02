/**
 * 
 */
var init={'questions':[{'question':'jQuery是什么？','answers':['JavaScript库','CSS库','PHP框架','以上都不是'],'correctAnswer':1},{'question':'找出不同类的一项?','answers':['写字台','沙发','电视','桌布'],'correctAnswer':3},{'question':'国土面积最大的国家是：','answers':['美国','中国','俄罗斯','加拿大'],'correctAnswer':3},{'question':'月亮距离地球多远？','answers':['18万公里','38万公里','100万公里','180万公里'],'correctAnswer':2}]};
$(function(){
	$('#quiz-container').jquizzy({
        questions: init.questions
    });
});