<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://v3.bootcss.com/favicon.ico">

    <link href="<%=basePath%>resources/bootstrap/css/United/bootstrap.min.css"
          rel="stylesheet">
    <link href="<%=basePath%>resources/bootstrap/css/jumbotron-narrow.css" rel="stylesheet">

    <script type="application/javascript" src="<%=basePath%>resources/js/jquery-2.2.3.min.js"></script>
    <script type="application/javascript" src="<%=basePath%>resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="<%=basePath%>resources/js/public.js"></script>

    <script type="text/javascript">

        try {
            window.AG_onLoad = function (func) {
                if (window.addEventListener) {
                    window.addEventListener('DOMContentLoaded', func);
                }
            };
            window.AG_removeElementById = function (id) {
                var element = document.getElementById(id);
                if (element && element.parentNode) {
                    element.parentNode.removeChild(element);
                }
            };
            window.AG_removeElementBySelector = function (selector) {
                if (!document.querySelectorAll) {
                    return;
                }
                var nodes = document.querySelectorAll(selector);
                if (nodes) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (nodes[i] && nodes[i].parentNode) {
                            nodes[i].parentNode.removeChild(nodes[i]);
                        }
                    }
                }
            };
            window.AG_each = function (selector, fn) {
                if (!document.querySelectorAll) return;
                var elements = document.querySelectorAll(selector);
                for (var i = 0; i < elements.length; i++) {
                    fn(elements[i]);
                }
            };
            var AG_removeParent = function (el, fn) {
                while (el && el.parentNode) {
                    if (fn(el)) {
                        el.parentNode.removeChild(el);
                        return;
                    }
                    el = el.parentNode;
                }
            };
            var _gaq = [];
            var _gat = {
                _getTracker: function () {
                    return {
                        _initData: function () {
                        }, _trackPageview: function () {
                        }, _trackEvent: function () {
                        }, _setAllowLinker: function () {
                        }, _setCustomVar: function () {
                        }
                    }
                }, _createTracker: function () {
                    return this._getTracker();
                }, _anonymizeIp: function () {
                }
            };

            function urchinTracker() {
            }

            var nol_t = function () {
                return {
                    record: function () {
                        return {
                            post: function () {
                            }
                        }
                    }
                }
            };
            var addthis = {
                init: function () {
                }, addEventListener: function () {
                }, button: function () {
                }, counter: function () {
                }, update: function () {
                }, toolbox: function () {
                }, layers: function () {
                }
            };
        } catch (ex) {
            console.error('Error executing AG js: ' + ex);
        }</script>

    <style id="style-1-cropbar-clipper" type="text/css">

        /* Copyright 2014 Evernote Corporation. All rights reserved. */
        .en-markup-crop-options {
            top: 18px !important;
            left: 50% !important;
            margin-left: -100px !important;
            width: 200px !important;
            border: 2px rgba(255, 255, 255, .38) solid !important;
            border-radius: 4px !important;
        }

        .en-markup-crop-options div div:first-of-type {
            margin-left: 0px !important;
        }
    </style>
</head>
<body>

<div id="msgModel" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h5 class="modal-title">
                    提示
                </h5>
            </div>
            <div id="msgModelBody" class="modal-body" style="text-align: center;min-height: 50px">
            </div>
        </div>
    </div>
</div>


<div class="container" id="myContainer" style="display: none;">

    <div class="header clearfix">
        <div id="title">
            <tiles:insertAttribute name="header"/>
        </div>
    </div>

    <div id="content" style="min-height: 400px;">
        <tiles:insertAttribute name="main-container"/>
    </div>

    <div id="bottom">
        <tiles:insertAttribute name="bottom"/>
    </div>

</div> <!-- /container -->
</body>
</html>
<script>
    window.onload = $("#myContainer").show();
</script>
