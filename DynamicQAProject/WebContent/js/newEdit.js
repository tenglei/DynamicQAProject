/**
 * 
 */
$(document).ready(function() {
	var addNum=0;
	var selNum=0;
	var fillNum=0;
	var ansNum=0;
	var listTmp=new Array();
	
	
	var wenjuanname=new Array();
	var choiceques=new Array();
	var ansA=new Array();
	var ansB=new Array();
	var ansC=new Array();
	var ansD=new Array();
	var choicescore=new Array();
	var choiceAns=new Array();
	var fillques=new Array();
	var fillscore=new Array();
	var fillAns=new Array();
	var blanknum=new Array();
	var ques=new Array();
	var quesscore=new Array();
	var quesKey=new Array();
	var quesDes = new Array();
	
	var wenjuanclass;
	
	
	
	$("#addSelect").on("click", function() {		
		listTmp[addNum]=1;
		addNum++;
		selNum++;
		
		selectdiv="<div "+ "name='select'> " +"第"+ addNum +"题、"+
		"<input class='form-control' style='width:500px;'  type='text' id='selQ"+selNum+"' placeholder='请输入选择题题目' />"+"*"+
		"<input class='form-control' style='width:100px;' type='text' placeholder='请输入分值' id='selS"+selNum+"'/>"+"*"+
		"<button  class='btn btn-danger'>删除</button>"+"<br>"+
		"<br>"+"A:"+"<input  class='radio-inline' type='radio' name=" +selNum+" value='A'/>"+"&nbsp;&nbsp;<input class='form-control' style='width:500px;' type='text' name='sel1'/>"+"*"+"<br>"+
		"<br>"+"B:"+"<input  class='radio-inline' type='radio' name=" +selNum+" value='B'/>"+"&nbsp;&nbsp;<input class='form-control' style='width:500px;' type='text' name='sel2'/>"+"*"+"<br>"+
		"<br>"+"C:"+"<input  class='radio-inline' type='radio' name=" +selNum+" value='C'/>"+"&nbsp;&nbsp;<input class='form-control' style='width:500px;' type='text' name='sel3'/>"+"*"+"<br>"+
		"<br>"+"D:"+"<input  class='radio-inline' type='radio' name=" +selNum+" value='D'/>"+"&nbsp;&nbsp;<input class='form-control' style='width:500px;' type='text' name='sel4'/>"+"*"+"<br>"+
		" </div>"+"<br>";
		$("#quesList").append(selectdiv);
		$(".btn-danger").on("click", function() {
			$(this).parent().remove();
			addNum--;
			selNum--;
		});
	});
	$("#addFill").on("click", function() {
		listTmp[addNum]=2;
		addNum++;
		fillNum++;
		
		filldiv="<div name='fill'>" +"第" + addNum+"题、"+
		"<input class='form-control' style='width:500px;' type='text' id='fillQ"+fillNum+"' placeholder='请输入填空题格式如：XXX，__'/>"+"*" +"<input type='text' id='blockNum"+fillNum +"'"+
		"placeholder='请输入空格数量' class='form-control' style='width:100px;'/>"+"*"+"<input class='form-control' style='width:100px;' type='text' placeholder='请输入分值' id='fillS"+fillNum+"'/>"+"*"+"<button class='btn btn-danger'>删除</button>"+"<br>"+
		"<br>&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='blockAns"+fillNum +"'"+
		"placeholder='请输入答案，用空格分隔' class='form-control' style='width:500px;'/>"+"*"+
		" </div>"+"<br>";
		$("#quesList").append(filldiv);
		$(".btn-danger").on("click", function() {
			$(this).parent().remove();
			addNum--;
			fillNum--;
		});
		
	});
	$("#addAnswer").on("click", function() {
		listTmp[addNum]=3;
		addNum++;
		ansNum++;
		
		ansdiv="<div name='ans'>" +"第" + addNum+"题、"+
		"<input class='form-control' style='width:500px;' type='text' id='ansQ"+ansNum+"' placeholder='请输入问答题题目'/>"+"*"+
		"<input class='form-control' style='width:200px;' type='text' id='keyQ"+ansNum+"' placeholder='请输入关键词'/>"+"*"+
		"<input class='form-control' style='width:100px;' type='text' id='desS"+ansNum+"' placeholder='请输入分值'/>"+"*"+"<button class='btn btn-danger'>删除</button>"+"<br>"+
		"<br>&nbsp;&nbsp;&nbsp;&nbsp;<input class='form-control' style='width:500px;height:300px;' type='text' id='desQ"+ansNum+"' placeholder='问答题描述'/>"+"*"+"<br>"+
		"</div><br>"
		$("#quesList").append(ansdiv);
		$(".btn-danger").on("click", function() {
			$(this).parent().remove();
			addNum--;
			ansNum--;
		});
	});
	$("#finish").on("click", function() {
		var exit =1;
		var addTmp=0;
		var selTmp=0;
		var fillTmp=0;
		var quesName=$("#quesName").val();
		if(quesName==""){
			alert("问卷名不能为空");
			return;
		}
		$("#quesList div").each(function(){
			var divTmp = $(this).attr("name");
			if(divTmp=="select"){
				addTmp++;
				var selQ= $("#selQ"+addTmp).val();
				var selA=  $('input[name='+addTmp+']:checked').val();
				var selS=  $("#selS"+addTmp).val();
				
				var choiceA= $("[name='sel1']").val();
				var choiceB= $("[name='sel2']").val();
				var choiceC= $("[name='sel3']").val();
				var choiceD= $("[name='sel4']").val();
				addTmp--;
				if(choiceA==""||choiceB==""||choiceC==""||choiceD==""){
					alert("选择题选项不能为空");
					exit=0;
					return;
				}
				else if(typeof(selA)=="undefined"){
					alert("选择题需选一个选项作为答案");
					exit=0;
					return;
				}
				else if(selS==""){
					alert("选择题分数不能为空");
					exit=0;
					return;
				}
				else if(isNaN(selS)){
					alert("选择题分数栏请输入数字");
					//alert(selS);
					exit=0;
					return;
				}
				
		
				choiceques[addTmp]=selQ;
				choicescore[addTmp]=selS;
				choiceAns[addTmp]=selA;
				ansA[addTmp]=choiceA;
				ansB[addTmp]=choiceB;
				ansC[addTmp]=choiceC;
				ansD[addTmp]=choiceD;
				addTmp++;
				
				
				
//				//alert(choiceques[addTmp]);
//				//alert(choicescore[addTmp]);
//				//alert(choiceAns[addTmp]);
//				//alert(ansA[addTmp]);
//				//alert(ansB[addTmp]);
//				//alert(ansC[addTmp]);
//				//alert(ansD[addTmp]);
				
			}
			else if(divTmp=="fill"){
				selTmp++;
				var fillQ=$("#fillQ"+selTmp).val();
				var blockAns=$("#blockAns"+selTmp).val();
				var blockNum=$("#blockNum"+selTmp).val();
				var fillS = $("#fillS"+selTmp).val();
				selTmp--;
				
				var lengthTmp= new Array();
				lengthTmp =	blockAns.split(",");
				if(fillQ==""){
					alert("填空题题目不能为空");
					exit=0;
					return;
				}
				else if(blockAns==""){
					alert("填空题答案不能为空");
					exit=0;
					return;
				}
				else if(blockNum==""){
					alert("空格数量不能为空");
					exit=0;
					return;
				}
				else if(fillS==""){
					alert("填空题分数不能为空");
					exit=0;
					return;
				}
				else if(isNaN(fillS)){
					alert("填空题分数栏请输入数字");
					exit=0;
					return;
				}
				else if(isNaN(blockNum)){
					alert("空格数量请输入数字");
					exit=0;
					return;
				}
				else if(blockNum!=lengthTmp.length){
//					alert(blockNum);
//					alert(lengthTmp);
//					alert(lengthTmp.length);
					alert("填空题空格数量需与答案输入的相等");
					exit=0;
					return;
				}
				
				
				fillques[selTmp]=fillQ;
				fillAns[selTmp]=blockAns;
				blanknum[selTmp]=blockNum;
				fillscore[selTmp]=fillS;
//				//alert(fillques[selTmp]);
//				//alert(fillAns[selTmp]);
//				//alert(blanknum[selTmp]);
//				//alert(fillscore[selTmp]);
				selTmp++;
			}
			else if(divTmp=="ans"){
				fillTmp++;
				var ansQ = $("#ansQ"+fillTmp).val();
				var keyQ = $("#keyQ"+fillTmp).val();
				var desS = $("#desS"+fillTmp).val();
				var desQ = $("#desQ"+fillTmp).val();
				fillTmp--;
				if(ansQ==""){
					alert("问答题题目不能为空");
					exit=0;
					return;
				}
				else if(keyQ==""){
					alert("问答题关键词不能为空");
					exit=0;
					return;
				}
				else if(desS==""){
					alert("问答题分数不能为空");
					exit=0;
					return;
				}
				else if(isNaN(desS)){
					alert("问答题分数栏请输入数字");
					exit=0;
					return;
				}
				
				ques[fillTmp]=ansQ;
				quesKey[fillTmp]=keyQ;
				quesscore[fillTmp]=desS;
				quesDes[fillTmp]=desQ;
				fillTmp++;
				
//				//alert(ques[fillTmp]);
//				//alert(quesKey[fillTmp]);
//				//alert(quesscore[fillTmp]);
//				//alert(quesDes[fillTmp]);
			}
		});
//		var wenjuanname=new Array();
		
//		var choiceques=new Array();
//		var ansA=new Array();
//		var ansB=new Array();
//		var ansC=new Array();
//		var ansD=new Array();
//		var choicescore=new Array();
//		var choiceAns=new Array();
//		var fillques=new Array();
//		var fillscore=new Array();
//		var fillAns=new Array();
//		var blanknum=new Array();
//		var ques=new Array();
//		var quesscore=new Array();
//		var quesKey=new Array();
//		var quesDes = new Array();
		if(exit==1){
		var myform= $("#tab_form")[0];
		//选择题
		var tmp1 = document.createElement("input");
		tmp1.setAttribute("name", "choiceques");
		tmp1.setAttribute("type", "hidden");
		tmp1.setAttribute("value", choiceques); 
		////alert(choiceques);
		myform.appendChild(tmp1);	
		
		var tmp2 = document.createElement("input");
		tmp2.setAttribute("name", "ansA");
		tmp2.setAttribute("type", "hidden");
		tmp2.setAttribute("value", ansA); 
		////alert(ansA);
		
		myform.appendChild(tmp2);	
		
		var tmp3 = document.createElement("input");
		tmp3.setAttribute("name", "ansB");
		tmp3.setAttribute("type", "hidden");
		tmp3.setAttribute("value", ansB); 
		////alert(ansB);
		myform.appendChild(tmp3);	
		
		var tmp4 = document.createElement("input");
		tmp4.setAttribute("name", "ansC");
		tmp4.setAttribute("type", "hidden");
		tmp4.setAttribute("value", ansC); 
		////alert(ansC);
		myform.appendChild(tmp4);	
		
		var tmp5 = document.createElement("input");
		tmp5.setAttribute("name", "ansD");
		tmp5.setAttribute("type", "hidden");
		tmp5.setAttribute("value", ansD); 
		////alert(ansD);
		myform.appendChild(tmp5);
		
		var tmp6 = document.createElement("input");
		tmp6.setAttribute("name", "choicescore");
		tmp6.setAttribute("type", "hidden");
		tmp6.setAttribute("value", choicescore); 
		////alert(choicescore);
		myform.appendChild(tmp6);
		
		var tmp7 = document.createElement("input");
		tmp7.setAttribute("name", "choiceans");
		tmp7.setAttribute("type", "hidden");
		tmp7.setAttribute("value", choiceAns); 
		////alert(choiceAns);
		myform.appendChild(tmp7);
		
		//填空题
		var tmp8 = document.createElement("input");
		tmp8.setAttribute("name", "fillques");
		tmp8.setAttribute("type", "hidden");
		tmp8.setAttribute("value", fillques); 
		myform.appendChild(tmp8);
		
		var tmp9 = document.createElement("input");
		tmp9.setAttribute("name", "fillscore");
		tmp9.setAttribute("type", "hidden");
		tmp9.setAttribute("value", fillscore); 
		myform.appendChild(tmp9);
		
		var tmp10 = document.createElement("input");
		tmp10.setAttribute("name", "fillans");
		tmp10.setAttribute("type", "hidden");
		tmp10.setAttribute("value", fillAns); 
		myform.appendChild(tmp10);
		
		var tmp11 = document.createElement("input");
		tmp11.setAttribute("name", "blanknum");
		tmp11.setAttribute("type", "hidden");
		tmp11.setAttribute("value", blanknum); 
		myform.appendChild(tmp11);
		
		//问答题
		var tmp12 = document.createElement("input");
		tmp12.setAttribute("name", "ques");
		tmp12.setAttribute("type", "hidden");
		tmp12.setAttribute("value", ques); 
		myform.appendChild(tmp12);
		
		var tmp13 = document.createElement("input");
		tmp13.setAttribute("name", "quesscore");
		tmp13.setAttribute("type", "hidden");
		tmp13.setAttribute("value", quesscore); 
		myform.appendChild(tmp13);
		
		var tmp14 = document.createElement("input");
		tmp14.setAttribute("name", "queskey");
		tmp14.setAttribute("type", "hidden");
		tmp14.setAttribute("value", quesKey); 
		myform.appendChild(tmp14);
		
		var tmp15 = document.createElement("input");
		tmp15.setAttribute("name", "quesans");
		tmp15.setAttribute("type", "hidden");
		tmp15.setAttribute("value", quesDes); 
		myform.appendChild(tmp15);
		
		//问卷类型
		var tmp16 = document.createElement("input");
		tmp16.setAttribute("name", "wenjuanclass");
		tmp16.setAttribute("type", "hidden");
		tmp16.setAttribute("value", wenjuanclass); 
		myform.appendChild(tmp16);
		
//		var tmp17 = document.createElement("input");
//		tmp17.setAttribute("name", "wenjuanname");
//		tmp17.setAttribute("type", "hidden");
//		tmp17.setAttribute("value", editname); 
//		////alert("wenjuan");
//		//alert(editname);
//		myform.appendChild(tmp17);
		
		var tmp18 = document.createElement("input");
		tmp18.setAttribute("name", "listTmp");
		tmp18.setAttribute("type", "hidden");
		tmp18.setAttribute("value", listTmp); 
		myform.appendChild(tmp18);
		
		var tmp19 = document.createElement("input");
		tmp19.setAttribute("name", "authorname");
		tmp19.setAttribute("type", "hidden");
		tmp19.setAttribute("value", author); 
		myform.appendChild(tmp19);
		
		var tmp20 = document.createElement("input");
		tmp20.setAttribute("name", "editname");
		tmp20.setAttribute("type", "hidden");
		tmp20.setAttribute("value", base); 
		myform.appendChild(tmp20);
		
		myform.submit();
		}
	});
	$("#selectKind").on("click", function() {
	 wenjuanclass=$("#selectKind").val();
	});
	wenjuanclass=$("#selectKind").val();
//	var editname=$("#wenjuanname").val();
//	//alert(editname);//alert("sadfa");
	
	var author =$("#author").attr("name");
	var base =$("#base").attr("name");
	

});