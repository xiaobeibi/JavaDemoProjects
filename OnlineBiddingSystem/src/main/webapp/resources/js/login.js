(function () {
    'use strict';

    function emulatedIEMajorVersion() {
        var groups = /MSIE ([0-9.]+)/.exec(window.navigator.userAgent)
        if (groups === null) {
            return null
        }
        var ieVersionNum = parseInt(groups[1], 10)
        return Math.floor(ieVersionNum)
    }

    function actualNonEmulatedIEMajorVersion() {
        // Detects the actual version of IE in use, even if it's in an older-IE emulation mode.
        // IE JavaScript conditional compilation docs: https://msdn.microsoft.com/library/121hztk3%28v=vs.94%29.aspx
        // @cc_on docs: https://msdn.microsoft.com/library/8ka90k2e%28v=vs.94%29.aspx
        var jscriptVersion = new Function('/*@cc_on return @_jscript_version; @*/')() // jshint ignore:line
        if (jscriptVersion === undefined) {
            return 11; // IE11+ not in emulation mode

        }
        if (jscriptVersion < 9) {
            return 8; // IE8 (or lower; haven't tested on IE<8)
        }
        return jscriptVersion; // IE9 or IE10 in any mode, or IE11 in non-IE11 mode
    }

    var ua = window.navigator.userAgent;
    if (ua.indexOf('Opera') > -1 || ua.indexOf('Presto') > -1) {
        return; // Opera, which might pretend to be IE
    }
    var emulated = emulatedIEMajorVersion();
    if (emulated === null) {
        return; // Not IE
    }
    var nonEmulated = actualNonEmulatedIEMajorVersion()

    if (emulated !== nonEmulated) {
        window.alert('WARNING: You appear to be using IE' + nonEmulated + ' in IE' + emulated + ' emulation mode.\nIE emulation modes can behave significantly differently from ACTUAL older versions of IE.\nPLEASE DON\'T FILE BOOTSTRAP BUGS based on testing in IE emulation modes!')
    }
})();

(function () {
    'use strict';

    if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
        var msViewportStyle = document.createElement('style')
        msViewportStyle.appendChild(
            document.createTextNode(
                '@-ms-viewport{width:auto!important}'
            )
        );
        document.querySelector('head').appendChild(msViewportStyle)
    }

})();
