$.fn.widgetContent = function() {
    return this.addClass("ui-widget-content ui-corner-all");
};

$.fn.widgetHeader = function() {
    return this.addClass("ui-widget-header ui-corner-all");
};

$.fn.panel = function() {
    return this.widgetContent().css("padding", "10px").css("margin-bottom",
            "10px");
};

$.fn.headerBar = function() {
    return this.widgetHeader().css("padding", "6px");
};

$.fn.bar = function() {
    return this.addClass("ui-state-default ui-corner-all").attr("style",
            "padding:6px");
};

var application = {
    load : function(contextRoot) {
        $("#tabs").tabs();
        $("fieldset").panel();
        $("legend").headerBar();
        $("input,select").widgetContent();
        $("button").button();

        var machines = $('#machines');
        var lastSelected;
        machines.jqGrid({
            url : contextRoot + '/machine/list',
            datatype : 'json',
            colNames : [ 'IP', 'ホスト名', 'OS', 'CPU', 'メモリ', 'ストレージ', 'ユーザ名',
                    'パスワード', '仮想', '備考' ],
            colModel : [ {
                name : 'ip',
                index : 'ip',
                editable : true,
                width : 100
            }, {
                name : 'hostName',
                index : 'hostName',
                editable : true,
                width : 100
            }, {
                name : 'os',
                index : 'os',
                editable : true,
                width : 150
            }, {
                name : 'cpu',
                index : 'cpu',
                editable : true,
                width : 100
            }, {
                name : 'memory',
                index : 'memory',
                editable : true,
                width : 50
            }, {
                name : 'strage',
                index : 'strage',
                editable : true,
                width : 50
            }, {
                name : 'user',
                index : 'user',
                editable : true,
                width : 75
            }, {
                name : 'password',
                index : 'password',
                editable : true,
                width : 75
            }, {
                name : 'virtual',
                index : 'virtual',
                editable : true,
                edittype : 'select',
                editoptions : {
                    value : 'true:仮想;false:物理'
                },
                width : 50
            }, {
                name : 'comment',
                index : 'comment',
                width : 300,
                edittype : 'textarea',
                editable : true,
                sortable : false,
                editoptions : {
                    rows : '5',
                    cols : '20'
                }
            } ],
            height : 600,
            rowNum : 20,
            rowList : [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
            pager : '#pager',
            sortname : 'ip',
            viewrecords : true,
            sortorder : 'asc',
            caption : 'マシン一覧',
            editurl : contextRoot + '/machine/update',
            /*
             * onSelectRow : function(id) { if (id && id !== lastSelected) {
             * machines.jqGrid('restoreRow', lastSelected); lastSelected = id; }
             * machines.jqGrid('editRow', id, true); },
             */
            jsonReader : {
                repeatitems : false
            }
        });

        machines.jqGrid('navGrid', '#pager', {}, // options
        {
            url : contextRoot + '/machine/update',
            editCaption : 'マシン情報編集'
        }, // edit options
        {
            url : contextRoot + '/machine/insert',
            addCaption : 'マシン追加'
        }, // add options
        {
            url : contextRoot + '/machine/delete',
            caption : 'マシン削除',
            msg : '選択したマシン情報を削除します'
        },// del options
        {
            url : contextRoot + '/machine/search',
            caption : 'マシン検索'
        } // search options
        );

        $('#add').click(function() {
            machines.editGridRow('new', {
                url : contextRoot + '/machine/insert'
            });
        });
        $('#download').click(function() {
            location.href = "download";
        });
        $('#configUpdate').click(
                function() {
                    $.post(contextRoot + '/config/update', $('#configForm')
                            .serialize(), function(res) {
                        // console.log(res);
                        if (res.result === 'success') {
                            if (res.id != null) {
                                $('#id').val(res.id);
                            }
                            location.href = contextRoot + "/";
                        }
                    }, 'json');
                    return false;
                });
        $("#ping").click(function() {
            $("td[aria-describedby=machines_ip]").each(function(e) {
                var self = $(this);
                var ip = self.text();
                self.text("pinging..");
                $.get(contextRoot + '/machine/ping/' + ip + '/', function(ret) {
                    self.text(ip);
                    self.css("background-color", ret ? "lime" : "red");
                })
            });
        });
    }
}