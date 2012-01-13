<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<c:set var="contextRoot" value="<%= request.getContextPath() %>" />
<html>
<head>
<title>マシン管理簿</title>
<meta charset="utf-8">

<link rel="stylesheet" type="text/css"
    href="${contextRoot}/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"
    href="${contextRoot}/css/bootstrap.css" />
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css"
    href="${contextRoot}/css/custom-theme/jquery-ui-1.8.16.custom.css" />
<script src="${contextRoot}/js/i18n/grid.locale-en.js"
    type="text/javascript"></script>
<script src="${contextRoot}/js/jquery.jqGrid.src.js"
    type="text/javascript"></script>
<style>
body {
    font-size: 62.5%;
}
fieldset legend {
    font-size: 100%;
}
td,th {
    font-size: 80%;
}

label {
    display: block;
}

.dialog {
    display: none;
}
</style>
</head>
<body>
    <div id="tabs">
        <ul>
            <li><a href="#crud">管理マシン</a></li>
            <li><a href="#config">設定</a></li>
        </ul>
        <div id="crud">
            <fieldset>
                <legend class="ui-state-highlight">マシン一覧</legend>
                <div>
                    <button id="ping">ping</button>
                    <table id="machines"></table>
                    <div id="pager"></div>
                    <br>

                    <div class="dialog" title="新規登録">
                        <form>
                            <dl>
                                <dt>IPアドレス</dt>
                                <dd>
                                    <input name="ip">
                                </dd>
                                <dt>ホスト名</dt>
                                <dd>
                                    <input name="hostName">
                                </dd>
                                <dt>備考</dt>
                                <dd>
                                    <input name="comment">
                                </dd>
                            </dl>
                            <button id="submit">送信</button>
                        </form>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend class="ui-state-highlight">ファイルDL</legend>
                <div>
                    <button id="download">hostsファイル</button>
                </div>
            </fieldset>
        </div>
        <div id="config">
            <form:form id="configForm" modelAttribute="config">
                <fieldset>
                    <legend class="ui-state-highlight">設定情報登録フォーム</legend>
                    <div>
                        <label for="hostsHeader">Hostsファイル ヘッダー</label>
                        <form:hidden path="id" />
                        <form:textarea path="hostsHeader"
                            style="width:600px; height: 400px;"></form:textarea>
                        <br>
                        <button id="configUpdate">更新</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
    <script type="text/javascript">
        $("#tabs").tabs();
        $.fn.widgetContent = function() {
            return this.addClass("ui-widget-content ui-corner-all");
        };

        $.fn.widgetHeader = function() {
            return this.addClass("ui-widget-header ui-corner-all");
        };

        $.fn.panel = function() {
            return this.widgetContent().css("padding", "10px").css(
                    "margin-bottom", "10px");
        };

        $.fn.headerBar = function() {
            return this.widgetHeader().css("padding", "6px");
        };

        $.fn.bar = function() {
            return this.addClass("ui-state-default ui-corner-all")
                    .attr("style", "padding:6px");
        };

        $("fieldset").panel();
        $("legend").headerBar();
        $("input,select").widgetContent();
        $("button").button();
        $(function() {
            var machines = $('#machines');
            var lastSelected;
            machines.jqGrid({
                url : '${contextRoot}/machine/list',
                datatype : 'json',
                colNames : [ 'IP', 'ホスト名', 'OS', 'CPU', 'メモリ',
                        'ストレージ', 'ユーザ名', 'パスワード', '仮想', '備考' ],
                colModel : [ {
                    name : 'ip',
                    index : 'ip',
                    editable : true,
                    width : 150
                }, {
                    name : 'hostName',
                    index : 'hostName',
                    editable : true,
                    width : 150
                }, {
                    name : 'os',
                    index : 'os',
                    editable : true,
                    width : 200
                }, {
                    name : 'cpu',
                    index : 'cpu',
                    editable : true,
                    width : 100
                }, {
                    name : 'memory',
                    index : 'memory',
                    editable : true,
                    width : 100
                }, {
                    name : 'strage',
                    index : 'strage',
                    editable : true,
                    width : 100
                }, {
                    name : 'user',
                    index : 'user',
                    editable : true,
                    width : 100
                }, {
                    name : 'password',
                    index : 'password',
                    editable : true,
                    width : 100
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
                    width : 150,
                    edittype : 'textarea',
                    editable : true,
                    sortable : false,
                    editoptions : {
                        rows : '5',
                        cols : '20'
                    }
                } ],
                height : 450,
                rowNum : 20,
                rowList : [ 10, 20, 30 ],
                pager : '#pager',
                sortname : 'ip',
                viewrecords : true,
                sortorder : 'asc',
                caption : 'マシン一覧',
                editurl : '${contextRoot}/machine/update',
                /*
                onSelectRow : function(id) {
                    if (id && id !== lastSelected) {
                        machines.jqGrid('restoreRow', lastSelected);
                        lastSelected = id;
                    }
                    machines.jqGrid('editRow', id, true);
                },*/
                jsonReader : {
                    repeatitems : false
                }
            });

            machines.jqGrid('navGrid', '#pager', {}, //options
            {
                url : '${contextRoot}/machine/update',
                editCaption : 'マシン情報編集'
            }, // edit options
            {
                url : '${contextRoot}/machine/insert',
                addCaption : 'マシン追加'
            }, // add options
            {
                url : '${contextRoot}/machine/delete',
                caption : 'マシン削除',
                msg : '選択したマシン情報を削除します'
            },// del options
            {
                url : '${contextRoot}/machine/search',
                caption : 'マシン検索'
            } // search options
            );

            $('#add').click(function() {
                machines.editGridRow('new', {
                    url : '${contextRoot}/machine/insert'
                });
            });
            $('#download').click(function() {
                location.href = "download";
            });
            $('#configUpdate').click(
                    function() {
                        $.post('${contextRoot}/config/update', $('#configForm')
                                .serialize(), function(res) {
                            // console.log(res);
                            if (res.result === 'success'
                                    && res.id != null) {
                                $('#id').val(res.id);
                            }
                        }, 'json');
                        return false;
                    });
            $("#ping").click(
                    function() {
                        $("td[aria-describedby=machines_ip]").each(function(e) {
                            var self = $(this);
                            var ip = self.text();
                            $.get('${contextRoot}/machine/ping/' + ip + '/', function (ret) {
                                self.css("background-color", ret ? "lime" : "red");
                            })
                        });
                    }
            );
        });
    </script>
</body>
</html>
