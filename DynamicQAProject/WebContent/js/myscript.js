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
        	var t= document.getElementById("tab_logic");
        	t.action="wenda.action";
        	t.submit();
        	$(this).closest("tr").remove();
            $(pr).closest("tr").remove();
       }
       );
        
       
});
    $("#xuanze").on("click", function() {
        // Dynamic Rows Code
        
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
        	var t= document.getElementById("tab_logic");
        	t.action="xuanze.action";
        	t.submit();
        	$(this).closest("tr").remove();
            $(pr).closest("tr").remove();
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
        	var t= document.getElementById("tab_logic");
        	t.action="tiankong.action";
        	t.submit();
        	$(this).closest("tr").remove();
            $(pr).closest("tr").remove();
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
  
    $(".table-sortable tbody").sortable({
        helper: fixHelperModified      
    }).disableSelection();

    $(".table-sortable thead").disableSelection();



   // $("#wenda").trigger("click");
});