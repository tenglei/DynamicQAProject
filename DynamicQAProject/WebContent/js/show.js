/**
 * 
 */
$(document).ready(function() {
	$("#finish").on("click", function() {
		var quesAns = document.createElement("form");
		var Seleth = getElementById("seleth").getAttribute("name");
		var Fillth = getElementById("fillth").getAttribute("name");
		var QAth = getElementById("qath").getAttribute("name");
		document.body.appendChild(quesAns);
		quesAns.method = 'post';
		quesAns.action = 'answer.action';
		quesAns.target = '_blank';// 尚不清楚后果
		//生成选择题答案列表
		var i = 0;
		var subval=new Array();
		while (i < Seleth) {
			var tmpId = "as";
			tmpId=tmpId+i;
			var val=document.getElementByName(tmpID);
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
		while(i<Fillth){
			var fillId="fillans";
			fillId=fillId+i;
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
		while(i<QAth){
			var QAId="quesans";
			QAId = QAId +i;
			var QAval=document.getElementById(QAId);
			subvalt[i]=QAval.value;
			i++;
		}
		var qatmp = document.createElement("input");
		qatmp.setAttribute("name", "qaans");
		qatmp.setAttribute("type", "hidden");
		qatmp.setAttribute("value", subvalt);
		quesAns.appendChild(qatmp);
		
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