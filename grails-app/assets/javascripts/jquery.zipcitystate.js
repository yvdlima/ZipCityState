(function ($) {
    var requests = {};
    var zipValid = {
        us: /[0-9]{5}(-[0-9]{4})?/
    };

    $.ziplookup = function (zip, callback) {
        // Only make unique requests
        if (!requests[zip]) {
            requests[zip] = $.getJSON(zipLookupBaseUrl + zip);
        }

        // Bind to the finished request
        requests[zip].done(function (data) {
            callback(data.state, data.city, zip);
        });

        // Allow for binding to the deferred object
        return requests[zip];
    };

    $.fn.ziplookup = function () {
        return this.each(function () {
            var ele = $(this);

            ele.on('keyup', function () {
                var zip = ele.val();

                if (zipValid.us.test(zip)) {
                    $.ziplookup(zip, function (state, city) {
                        // When info is not found trigger zipNotFound, otherwise trigger zipChange and return values
                        if (state == null && city == null) {
                            ele.trigger('zipNotFound', [zip]);
                        } else {
                            ele.trigger('zipChange', [state, city, zip]);
                        }
                    })
                }
            });
        });
    };
})(jQuery);
