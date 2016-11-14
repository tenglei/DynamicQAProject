/**
 * 
 */
$(document).ready(function() {
	$("#finish").on("click", function() {
		var quesAns = document.createElement("form");
		var Seleth = document.getElementById("seleth").getAttribute("name");
		var Fillth = document.getElementById("fillth").getAttribute("name");
		var QAth = document.getElementById("qath").getAttribute("name");
		var questionaire = document.getElementById("wenjuan").innerText;
		var Answerp = document.getElementById("answerp");
		document.body.appendChild(quesAns);
		quesAns.method = 'post';
		quesAns.action = 'tijiao.action';
		quesAns.target = '_blank';// 尚不清楚后果
		//生成选择题答案列表
		var i = 0;
		var subval=new Array();
		while (i < parseInt(Seleth)) {
			var tmpId = "as";
			tmpId=tmpId+i.toString();
			var val=document.getElementsByName(tmpId);
			for(var j=0;j<val.length;j++){
				if(val[j].checked){
					subval[i] = val[j].value;
				}
			}
			i++;
		}
		var seltmp = document.createElement("input");
		seltmp.setAttribute("name", "selectans");
		seltmp.setAttribute("type", "hidden");
		seltmp.setAttribute("value", subval); //有可能只是一个内存地址，解决办法，拼接字符串即可，待定
		quesAns.appendChild(seltmp);
		
		//方案二
	//	var tmp;
	//	i=0;
	//	while(i<subval.length){
	//		tmp = tmp + subval[i];
	//		tmp = tmp + "#";
	//		i++;
	//	}
		
		
		
		
		//生成填空题列表
		i=0;
		var subvals=new Array();
		while(i<parseInt(Fillth)){
			var fillId="fillans";
			fillId=fillId+i.toString();
			var fval=document.getElementById(fillId);
			subvals[i] = fval.value;
			i++;
		}
		var filltmp = document.createElement("input");
		filltmp.setAttribute("name", "fillans");
		filltmp.setAttribute("type", "hidden");
		filltmp.setAttribute("value", subvals);
		quesAns.appendChild(filltmp);
		
		i=0;
		var subvalt=new Array();
		while(i<parseInt(QAth)){
			var QAId="quesans";
			QAId = QAId +i.toString();
			var QAval=document.getElementById(QAId);
			subvalt[i]=QAval.value;
			i++;
		}
		var qatmp = document.createElement("input");
		qatmp.setAttribute("name", "qaans");
		qatmp.setAttribute("type", "hidden");
		qatmp.setAttribute("value", subvalt);
		quesAns.appendChild(qatmp);
		
		var questmp = document.createElement("input");
		questmp.setAttribute("name", "QAnum");
		questmp.setAttribute("type", "hidden");
		questmp.setAttribute("value", questionaire);
		quesAns.appendChild(questmp);
		
		var answertmp = document.createElement("input");
		answertmp.setAttribute("name", "huidazhe");
		answertmp.setAttribute("type", "hidden");
		answertmp.setAttribute("value",Answerp.value );
		quesAns.appendChild(answertmp);
		
		quesAns.submit();
		
		
//		var newElement = document.createElement("input");
//		newElement.setAttribute("name", "id");
//		newElement.setAttribute("type", "hidden");
//		newElement.setAttribute("value", elementValue);
//		turnForm.appendChild(newElement);
//		
//		turnForm.submit();
	});

});