<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<c:set var="contextRoot" value="<%=request.getContextPath()%>" />
<html>
<head>
<title>マシン管理簿</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="stylesheet" type="text/css"
    href="${contextRoot}/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"
    href="${contextRoot}/css/bootstrap.css" />
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<c:choose>
    <c:when test="">
        <c:otherwise></c:otherwise>
    </c:when>
    <c:when test="${config.theme == 'custom-theme'}">
        <link rel="stylesheet" type="text/css"
            href="${contextRoot}/css/custom-theme/jquery-ui-1.8.16.custom.css" />
    </c:when>
    <c:otherwise>
        <link rel="stylesheet" type="text/css"
            href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/themes/${config.theme}/jquery-ui.css" />
    </c:otherwise>
</c:choose>
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
                        <label for="theme">theme</label>
                        <form:select path="theme"
                            items="${themeCodeList}" />
                        <br> <label for="hostsHeader">Hostsファイル
                            ヘッダー</label>
                        <form:hidden path="id" />
                        <form:textarea path="hostsHeader"
                            style="width:600px; height: 400px;"></form:textarea>

                    </div>
                    <div>
                        <button id="configUpdate">更新</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
    <script type="text/javascript"
        src="${contextRoot}/js/application.js"></script>
    <script type="text/javascript">
                    application.load("${contextRoot}");
                </script>
</body>
</html>
