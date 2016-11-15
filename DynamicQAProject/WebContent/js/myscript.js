/**
 * 
 */
function AddElement(mytype) {
		var TemO = document.getElementById("add");
		var newInput = document.createElement("input");
		newInput.type = mytype;
		newInput.name = "input1";
		var newline = document.createElement("br");
		TemO.appendChild(newline);
		TemO.appendChild(newInput);
		TemO.appendChild(newline);
	}
$(document).ready(function() {
	 function count(o){
         var t = typeof o;
         if(t == 'string'){
                 return o.length;
         }else if(t == 'object'){
                 var n = 0;
                 for(var i in o){
                         n++;
                 }
                 return n;
         }
         return false;
 }
	
	var newid = 0;
	
    $("#wenda").on("click", function() {
        // Dynamic Rows Code
        
        // Get max row id and set new id
        $.each($("#tab_logic tr"), function() {
            if (parseInt($(this).data("id")) > newid) {
                newid = parseInt($(this).data("id"));
            }
        });
        newid++;
        
        var tr = $("<tr></tr>", {
            id: "addr"+newid,
            "data-id": newid
        });
        var pr = $("<tr></tr>", {
            id: "bddr"+newid,
            "data-id": newid
        });
        // loop through each td and create new elements with name of newi
        $.each($("#tab_logic tbody:eq(0) tr:nth(0) td"), function() {
            var cur_tdh = $(this);
            
            
            var children = cur_tdh.children();
            
            // add new td and element if it has a name
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_tdh).data("name")
                });
                var c = $(cur_tdh).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_tdh).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(pr));
               
               
               
            } else {
            	alert("else");
                var td = $("<td></td>", {
                    'text': $('#tab_logic tr').length
                }).appendTo($(pr));
            }            

        });
        $.each($("#tab_logic tbody:eq(1) tr:nth(0) td"), function() {
            var cur_td = $(this);
            
            var children = cur_td.children();
            
            // add new td and element if it has a name
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_td).data("name")
                });
                
                var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_td).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(tr));
               
            } else {
            	alert("else");
                var td = $("<td></td>", {
                    'text': $('#tab_logic tr').length
                }).appendTo($(tr));
            }
        });
        
        // add delete button and td
        /*
        $("<td></td>").append(
            $("<button class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>")
                .click(function() {
                    $(this).closest("tr").remove();
                })
        ).appendTo($(tr));
        */
        
        // add the new row
        $(pr).appendTo($('#tab_logic'));
        $(tr).appendTo($('#tab_logic'));
        $(tr).find("td button.row-remove").on("click", function() {
        	
             $(this).closest("tr").remove();
             $(pr).closest("tr").remove();
        }
        );
        $(tr).find("td button.row-add").on("click", function() {
        	var test1 = document.myform.score1;
        	var test2 = document.myform.ques1;
        	var test3 = document.myform.key1;
        	var test4 = document.myform.desc1;
        	if(typeof(test1.value)!="undefined"&&test1.value.length!=0){
        		if(isNaN(test1.value)){
        			alert("请输入数字");
        			return false;
        		}
        	}
        	else{
        		alert("分数栏不能为空");
        		return false;
        	}
        	if(typeof(test3.value)!="undefined"&&test3.value.length!=0 ){
        		
        	}
        	else{
        		alert("关键词不能为空");
        		return false;
        	}
        	if(typeof(test2.value)!="undefined"&&test2.value.length!=0){
        		
        	}
        	else{
        		alert("问题栏不能为空");
        		return false;
        	}
        	if(typeof(test4.value)!="undefined"&&test4.value.length!=0 ){
        		
        	}
        	else{
        		alert("答案不能为空！");
        		return false;
        	}
        	alert("添加成功！");
        	document.myform.action="wenda.action";
        	myform.submit();
        	//未删除加入，或许会报错
       
       }
       );
        
       
});
    $("#xuanze").on("click", function() {
        // Dynamic Rows Code
        //alert("xuanze");
        // Get max row id and set new id
        $.each($("#tab_select tr"), function() {
            if (parseInt($(this).data("id")) > newid) {
                newid = parseInt($(this).data("id"));
            }
        });
        newid++;
        
        var tr = $("<tr></tr>", {
            id: "addr"+newid,
            "data-id": newid
        });
        var pr = $("<tr></tr>", {
            id: "bddr"+newid,
            "data-id": newid
        });
        // loop through each td and create new elements with name of newi
        $.each($("#tab_select tbody:eq(0) tr:nth(0) td"), function() {
            var cur_tdh = $(this);
            
            
            var children = cur_tdh.children();
            
            // add new td and element if it has a name
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_tdh).data("name")
                });
                var c = $(cur_tdh).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_tdh).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(pr));
               
               
               
            } else {
            	alert("else");
                var td = $("<td></td>", {
                    'text': $('#tab_select tr').length
                }).appendTo($(pr));
            }            

        });
        $.each($("#tab_select tbody:eq(1) tr:nth(0) td"), function() {
            var cur_td = $(this);
            
            var children = cur_td.children();
            
            // add new td and element if it has a name
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_td).data("name")
                });
                
                var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_td).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(tr));
               
            } else {
            	alert("else");
                var td = $("<td></td>", {
                    'text': $('#tab_select tr').length
                }).appendTo($(tr));
            }
        });
        
        // add delete button and td
        /*
        $("<td></td>").append(
            $("<button class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>")
                .click(function() {
                    $(this).closest("tr").remove();
                })
        ).appendTo($(tr));
        */
        
        // add the new row
        $(pr).appendTo($('#tab_logic'));
        $(tr).appendTo($('#tab_logic'));
        $(tr).find("td button.row-remove").on("click", function() {
             $(this).closest("tr").remove();
             $(pr).closest("tr").remove();
        }
        );
        $(tr).find("td button.row-add").on("click", function() {
        	
        	
        	var test1 = document.myform.score1;
        	var test2 = document.myform.ques1;
        	var test3 = document.myform.key1;
        	var test4 = document.myform.first1;
        	var test5 = document.myform.second1;
        	var test6 = document.myform.third1;
        	var test7 = document.myform.fourth1;
        	if(typeof(test1.value)!="undefined"&&test1.value.length!=0){
        		if(isNaN(test1.value)){
        			alert("请输入数字");
        			return false;
        		}
        	}
        	else{
        		alert("分数栏不能为空");
        		return false;
        	}
        	if(typeof(test3.value)!="undefined"&&test3.value.length!=0 ){
        		if(test3.value!='A'&&test3.value!='B'&&test3.value!='C'&&test3.value!='D')
        		{
        			alert("答案必须输入大写的ABCD！！！");
        			return false;
        		}
        	}
        	else{
        		alert("答案不能为空");
        		return false;
        	}
        	if(typeof(test4.value)!="undefined"&&test4.value.length!=0){
        		
        	}
        	else{
        		alert("选项不能为空");
        		return false;
        	}
        	if(typeof(test5.value)!="undefined"&&test5.value.length!=0){
        		
        	}
        	else{
        		alert("选项不能为空");
        		return false;
        	}
        	if(typeof(test6.value)!="undefined"&&test6.value.length!=0){
	
        	}
        	else{
        		alert("选项不能为空");
        		return false;
        	}
        	if(typeof(test7.value)!="undefined"&&test7.value.length!=0){
	
        	}
        	else{
        		alert("选项不能为空");
        		return false;
        	}
        	if(typeof(test2.value)!="undefined"&&test2.value.length!=0){
	
        	}
        	else{
        		alert("问题栏不能为空");
        		return false;
        	}
        	alert("添加成功！");
        	document.myform.action="xuanze.action";
        	myform.submit();
        	//未删除加入，或许会报错
       }
       );
        
       
});
    
    $("#tiankong").on("click", function() {
        // Dynamic Rows Code
        
        // Get max row id and set new id
        $.each($("#tab_tiankong tr"), function() {
            if (parseInt($(this).data("id")) > newid) {
                newid = parseInt($(this).data("id"));
            }
        });
        newid++;
        
        var tr = $("<tr></tr>", {
            id: "addr"+newid,
            "data-id": newid
        });
        var pr = $("<tr></tr>", {
            id: "bddr"+newid,
            "data-id": newid
        });
        // loop through each td and create new elements with name of newi
        $.each($("#tab_tiankong tbody:eq(0) tr:nth(0) td"), function() {
            var cur_td = $(this);
            
            var children = cur_td.children();
            
            // add new td and element if it has a name
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_td).data("name")
                });
                
                var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_td).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(pr));
               
            } else {
            	alert("else");
                var td = $("<td></td>", {
                    'text': $('#tab_tiankong tr').length
                }).appendTo($(pr));
            }
        });
        
        $.each($("#tab_tiankong tbody:eq(1) tr:nth(0) td"), function() {
            var cur_td = $(this);
            
            var children = cur_td.children();
            
            // add new td and element if it has a name
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_td).data("name")
                });
                
                var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_td).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(tr));
               
            } else {
            	alert("else");
                var td = $("<td></td>", {
                    'text': $('#tab_tiankong tr').length
                }).appendTo($(tr));
            }
        });
        
        // add delete button and td
        /*
        $("<td></td>").append(
            $("<button class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>")
                .click(function() {
                    $(this).closest("tr").remove();
                })
        ).appendTo($(tr));
        */
        
        // add the new row
       
        $(pr).appendTo($('#tab_logic'));
        $(tr).appendTo($('#tab_logic'));
        $(tr).find("td button.row-remove").on("click", function() {
             $(this).closest("tr").remove();
             $(pr).closest("tr").remove();
        }
        );
        $(tr).find("td button.row-add").on("click", function() {
        	var test1 = document.myform.score1;
        	var test2 = document.myform.ques1;
        	var test3 = document.myform.fillnum1;
        	var test4 = document.myform.answer1;
        	if(typeof(test3.value)!="undefined"&&test3.value.length!=0 ){
        		if(isNaN(test3.value)){
        			alert("请输入数字");
        			return false;
        		}
        	}
        	else{
        		alert("空格数量不能为空");
        		return false;
        	}
        	if(typeof(test4.value)!="undefined"&&test4.value.length!=0){
        		//var testmp = test4.split(" ");
        		//if(count(testmp)!=test3.value)
        		//{
        			//alert("要求空格数量和输入的数量必须匹配")
        		//}
        	}
        	else{
        		alert("答案不能为空");
        		return false;
        	}
        	if(typeof(test1.value)!="undefined"&&test1.value.length!=0){
        		if(isNaN(test1.value)){
        			alert("请输入数字");
        			return false;
        		}
        	}
        	else{
        		alert("分数栏不能为空");
        		return false;
        	}
        	
        	if(typeof(test2.value)!="undefined"&&test2.value.length!=0){
        		
        	}
        	else{
        		alert("问题栏不能为空");
        		return false;
        	}
        	alert("添加成功！");
        	
        	document.myform.action="tiankong.action";
        	myform.submit();
        	//未删除加入，或许会报错
       }
       );
        
        
       
});



    // Sortable Code
    var fixHelperModified = function(e, tr) {
        var $originals = tr.children();
        var $helper = tr.clone();
    
        $helper.children().each(function(index) {
            $(this).width($originals.eq(index).width())
        });
        
        return $helper;
    };
	/*
    $(".table-sortable tbody").sortable({
        helper: fixHelperModified      
    }).disableSelection();

    $(".table-sortable thead").disableSelection();
	*/


   // $("#wenda").trigger("click");
});