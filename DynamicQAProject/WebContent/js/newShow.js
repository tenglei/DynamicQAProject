/**
 * 
 */
$(document).ready(function() {
	//alert("third newShow.js");
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
	
	var wenjuanhao = $("#wenjuanhao").val();
	
	////alert("get");
	//alert(wenjuanhao);

	var addSel= function() {		
		addNum++;
	
		
		selectdiv="<div "+ "name='select'> " +"第"+ addNum +"题、"+
		"<input readonly='true' class='form-control' style='width:500px;'  type='text' id='selQ"+selNum+"' value='"+choiceques[selNum]+"' />"+"&nbsp;&nbsp;"+
		"分值：  "+choicescore[selNum]+"<br>"+
		"<br>"+"A:"+"<input  class='radio-inline' type='radio' name='" +selNum+"' value='A'/>"+"&nbsp;&nbsp;<input readonly='true' class='form-control' style='width:500px;' type='text' name='sel1' value='"+ansA[selNum]+"'/>"+"*"+"<br>"+
		"<br>"+"B:"+"<input  class='radio-inline' type='radio' name='" +selNum+"' value='B'/>"+"&nbsp;&nbsp;<input readonly='true' class='form-control' style='width:500px;' type='text' name='sel2' value='"+ansB[selNum]+"'/>"+"*"+"<br>"+
		"<br>"+"C:"+"<input  class='radio-inline' type='radio' name='" +selNum+"' value='C'/>"+"&nbsp;&nbsp;<input readonly='true' class='form-control' style='width:500px;' type='text' name='sel3' value='"+ansC[selNum]+"'/>"+"*"+"<br>"+
		"<br>"+"D:"+"<input  class='radio-inline' type='radio' name='" +selNum+"' value='D'/>"+"&nbsp;&nbsp;<input readonly='true' class='form-control' style='width:500px;' type='text' name='sel4' value='"+ansD[selNum]+"'/>"+"*"+"<br>"+
		" </div>"+"<br>";
		$("#quesList").append(selectdiv);
		selNum++;
	}
	var addFill= function() {
		addNum++;
		
		
		filldiv="<div name='fill'>" +"第" + addNum+"题、"+
		"<input readonly='true' class='form-control' style='width:500px;' type='text' id='fillQ"+fillNum+"' value='"+fillques[fillNum]+"'/>"+"&nbsp;&nbsp;"+"分值： " +fillscore[fillNum]+"<br>"+
		"<br>&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='blockAns"+fillNum +"'"+
		"placeholder='请输入答案' class='form-control' style='width:500px;'/>"+"*"+
		" </div>"+"<br>";
		$("#quesList").append(filldiv);
		fillNum++;
		
	}
	var addAns = function() {
		addNum++;

		
		ansdiv="<div name='ans'>" +"第" + addNum+"题、"+
		"<input class='form-control' readonly='true' style='width:500px;' type='text' id='ansQ"+ansNum+"' value='"+ques[ansNum]+"'/>"+"&nbsp;&nbsp;分值： "+
		quesscore[ansNum]+"<br>"+
		"<br>&nbsp;&nbsp;&nbsp;&nbsp;<input class='form-control' style='width:500px;height:300px;' type='text' id='desQ"+ansNum+"' placeholder='在此回答'/>"+"*"+"<br>"+
		"</div><br>"
		$("#quesList").append(ansdiv);
		ansNum++;
	}
	$("#finish").on("click", function() {
		//alert("finish click");
		var exit =1;
		var addTmp=0;
		var selTmp=0;
		var fillTmp=0;
		var myName=$("#answerName").val();
		if(myName==""){
			alert("请输入您的称呼");
			return;
		}
		var answerName=$("#answerName").val();
		$("#quesList div").each(function(){
			var divTmp = $(this).attr("name");
			if(divTmp=="select"){
				var selQ= $("#selQ"+addTmp).val();
				var selA=  $('input[name='+addTmp+']:checked').val();
				//alert("select");
				//alert(selA);
				var selS=  $("#selS"+addTmp).val();
				
				var choiceA= $("[name='sel1']").val();
				var choiceB= $("[name='sel2']").val();
				var choiceC= $("[name='sel3']").val();
				var choiceD= $("[name='sel4']").val();
				
				//alert(selA);
				if(typeof(selA)=="undefined"){
					alert("选择题需选一个选项作为答案");
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
				var fillQ=$("#fillQ"+selTmp).val();
				var blockAns=$("#blockAns"+selTmp).val();
				var blockNum=$("#blockNum"+selTmp).val();
				var fillS = $("#fillS"+selTmp).val();
				//alert("blockAns");
				//alert(blockAns);
				//alert(selTmp);
				//alert(blockAns);
				if(blockAns==""){
					alert("填空题不能为空");
					exit=0;
					return;
				}
				
				fillques[selTmp]=fillQ;
				fillAns[selTmp]=blockAns;
				blanknum[selTmp]=blockNum;
				fillscore[selTmp]=fillS;
				selTmp++;
//				//alert(fillques[selTmp]);
//				//alert(fillAns[selTmp]);
//				//alert(blanknum[selTmp]);
//				//alert(fillscore[selTmp]);
			}
			else if(divTmp=="ans"){
				var ansQ = $("#ansQ"+fillTmp).val();
				var keyQ = $("#keyQ"+fillTmp).val();
				var desS = $("#desS"+fillTmp).val();
				var desQ = $("#desQ"+fillTmp).val();
				//alert("desQ");
				//alert(desQ);
				//alert(fillTmp);
				//alert(desQ);
				if(desQ==""){
					alert("问答题不能为空");
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
		
//		ansA={qq,qq};
//		ansB={qq,qq};
//		ansC={qq,qq};
//		ansD={qq,qq};
//		choiceques={qq,qq};
//		choicescore=[1,2];
//		addSel();
		
		
		
		
		if(exit==1){
			
			var myform= $("#tab_form")[0];
			//选择题
			var tmp1 = document.createElement("input");
			tmp1.setAttribute("name", "choiceques");
			tmp1.setAttribute("type", "hidden");
			tmp1.setAttribute("value", choiceques); 
			myform.appendChild(tmp1);	
			
			var tmp2 = document.createElement("input");
			tmp2.setAttribute("name", "ansA");
			tmp2.setAttribute("type", "hidden");
			tmp2.setAttribute("value", ansA); 
			myform.appendChild(tmp2);	
			
			var tmp3 = document.createElement("input");
			tmp3.setAttribute("name", "ansB");
			tmp3.setAttribute("type", "hidden");
			tmp3.setAttribute("value", ansB); 
			myform.appendChild(tmp3);	
			
			var tmp4 = document.createElement("input");
			tmp4.setAttribute("name", "ansC");
			tmp4.setAttribute("type", "hidden");
			tmp4.setAttribute("value", ansC); 
			myform.appendChild(tmp4);	
			
			var tmp5 = document.createElement("input");
			tmp5.setAttribute("name", "ansD");
			tmp5.setAttribute("type", "hidden");
			tmp5.setAttribute("value", ansD); 
			myform.appendChild(tmp5);
			
			var tmp6 = document.createElement("input");
			tmp6.setAttribute("name", "choicescore");
			tmp6.setAttribute("type", "hidden");
			tmp6.setAttribute("value", choicescore); 
			myform.appendChild(tmp6);
			
			var tmp7 = document.createElement("input");
			tmp7.setAttribute("name", "selectans");
			tmp7.setAttribute("type", "hidden");
			tmp7.setAttribute("value", choiceAns); 
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
			//alert(fillAns);
			
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
			tmp14.setAttribute("name", "quesKey");
			tmp14.setAttribute("type", "hidden");
			tmp14.setAttribute("value", quesKey); 
			myform.appendChild(tmp14);
			
			var tmp15 = document.createElement("input");
			tmp15.setAttribute("name", "qaans");
			tmp15.setAttribute("type", "hidden");
			tmp15.setAttribute("value", quesDes); 
			//alert(quesDes);
			myform.appendChild(tmp15);
			
			//问卷类型
			var tmp16 = document.createElement("input");
			tmp16.setAttribute("name", "wenjuanclass");
			tmp16.setAttribute("type", "hidden");
			tmp16.setAttribute("value", wenjuanclass); 
			myform.appendChild(tmp16);
			
			var tmp17 = document.createElement("input");
			tmp17.setAttribute("name", "editname");
			tmp17.setAttribute("type", "hidden");
			tmp17.setAttribute("value", editname); 
			myform.appendChild(tmp17);
			
			var tmp18 = document.createElement("input");
			tmp18.setAttribute("name", "QAnum");
			tmp18.setAttribute("type", "hidden");
			tmp18.setAttribute("value", wenjuanhao); 
			//alert(wenjuanhao);
			myform.appendChild(tmp18);
			
			var tmp19 = document.createElement("input");
			tmp19.setAttribute("name", "huidazhe");
			tmp19.setAttribute("type", "hidden");
			tmp19.setAttribute("value",answerName); 
			myform.appendChild(tmp19);
			//alert(answerName);
			myform.submit();
		}
	});
//	var wenjuanname=new Array();
//	var choiceques=new Array();
//	var ansA=new Array();
//	var ansB=new Array();
//	var ansC=new Array();
//	var ansD=new Array();
//	var choicescore=new Array();
//	var choiceAns=new Array();
//	var fillques=new Array();
//	var fillscore=new Array();
//	var fillAns=new Array();
//	var blanknum=new Array();
//	var ques=new Array();
//	var quesscore=new Array();
//	var quesKey=new Array();
//	var quesDes = new Array();
//	
//	var wenjuanclass;

	
	
	
	$("#selectKind").on("click", function() {
	 wenjuanclass=$("#selectKind").val();
	});
	wenjuanclass=$("#selectKind").val();
	var editname=$("#wenjuanname").val();
	
	var initShow=function(){
//		var tmp1=$("#wenjuanname").val();
		var tmp2=$("#choiceques").val();
		var tmp3=$("#ansA").val();
		var tmp4=$("#ansB").val();
		var tmp5=$("#ansC").val();
		var tmp6=$("#ansD").val();
		var tmp7=$("#choicescore").val();
		var tmp8=$("#fillques").val();
		var tmp9=$("#fillscore").val();
//		var tmp10=$("#fillAns").val();
		var tmp11=$("#ques").val();
		var tmp12=$("#quesscore").val();
		var tmp13=$("#listTmp").val();
//		var tmp14=$("#wenjuanclass").val();
		
		tmp2 = tmp2.substring(1,tmp2.length-1);
		tmp3 = tmp3.substring(1,tmp3.length-1);
		tmp4 = tmp4.substring(1,tmp4.length-1);
		tmp5 = tmp5.substring(1,tmp5.length-1);
		tmp6 = tmp6.substring(1,tmp6.length-1);
		tmp7 = tmp7.substring(1,tmp7.length-1);
		tmp8 = tmp8.substring(1,tmp8.length-1);
		tmp9 = tmp9.substring(1,tmp9.length-1);
		tmp11 = tmp11.substring(1,tmp11.length-1);
		tmp12= tmp12.substring(1,tmp12.length-1);
		
//		//alert(tmp2);
//		//alert(tmp3);
//		//alert(tmp4);
//		//alert(tmp5);
//		//alert(tmp6);
//		//alert(tmp7);
//		//alert(tmp8);
//		//alert(tmp9);
//		//alert(tmp11);
//		//alert(tmp12);
		
		
//		wenjuanname=tmp1;
		choiceques=tmp2.split(",");
		ansA=tmp3.split(",");
		ansB=tmp4.split(",");
		ansC=tmp5.split(",");
		ansD=tmp6.split(",");
		choicescore=tmp7.split(",");
		fillques=tmp8.split(",");
		fillscore=tmp9.split(",");
//		fillAns=tmp10.split(",");
		ques=tmp11.split(",");
		quesscore=tmp12.split(",");
		listTmp=tmp13.split(",");
		////alert(listTmp.length);
		
		var i=0;
		for( i=0;i<listTmp.length;i++){
			////alert(i);
			if(listTmp[i]=='1'){
				addSel();
			}
			else if(listTmp[i]=='2'){
				addFill();
			}
			else{
				addAns();
			}
		}
		
	}
	
	
//	var s= "qq,aa";
//	var t= "1,2";
//	choiceques=s.split(",");
//	ansA=s.split(",");
//	ansB=s.split(",");
//	ansC=s.split(",");
//	ansD=s.split(",");
//	choicescore=t.split(",");
//	fillques=s.split(",");
//	fillscore=t.split(",");
//	ques=s.split(",");
//	quesscore=t.split(",");
//	addSel();
//	addSel();
//	addFill();
//	addFill();
//	addAns();
//	addAns();
	initShow();
});