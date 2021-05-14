/**
 *
 */

/**
 * 模态框展示提示信息
 * @type {{showErrorMsg: MSG."showErrorMsg"}} {{showErrorMsg: MSG."showErrorMsg"}}
 */
var MSG = {

    "showSucceedMsg": function (msg) {
        $("#msgModelBody").empty().append(msg);
        $("#msgModel").modal("toggle");
    },
    "showErrorMsg": function (msg) {
        $("#msgModelBody").empty().append(msg);
        $("#msgModel").modal("toggle");
    },
    "showLoadMsg": function (msg) {
        $("#msgModelBody").empty().append(msg);
        $("#msgModel").modal("toggle");
    }
};


(function ($) {
    var _ajax = $.ajax;
    $.ajax = function (opt) {
        var fn = {
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            success: function (data, textStatus) {
            }
        };
        if (opt.error) {
            fn.error = opt.error;
        }
        if (opt.success) {
            fn.success = opt.success;
        }
        //扩展增强处理
        var _opt = $.extend(opt, {
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                fn.error(XMLHttpRequest, textStatus, errorThrown);
                MSG.showErrorMsg(textStatus);
            },
            success: function (data, textStatus) {
                fn.success(data, textStatus);
            }
        });
        _ajax(_opt);
    };
})(jQuery);
