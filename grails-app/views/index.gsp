<%--
  Created by IntelliJ IDEA.
  User: Alexander.Kramer
  Date: 12/18/13
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="zipcitystate.ZipCode" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Zip-City-State Sample</title>
</head>
<body>
<zipCode:resources/>
<g:javascript>
    jQuery(document).ready(function() {
        $("#zipField").ziplookup()
                .on('zipChange',function(event, state, city, zip) {
                    $("#zipError").html('').hide();
                    //populate the city and state
                    $("#cityField").val(city);
                    $("#stateField").val(state);
                    //automatically move the cursor to the field that comes next
                    $("#phoneField").focus();
                })
                .on('zipNotFound',function(event,zip) {
                    //maybe display something or just do nothing
                    $("#zipError").show().html("<text style='color:red'>Zip not found!</text>");
                });
    });
</g:javascript>
<h1>Zip-City-State Sample</h1>
<p>Below is an example of the basic functionality provided by this plugin</p>
<h3>Some zips you can try:</h3>
<g:select name="availableZips" from="${ZipCode.list()}" optionValue="${{it.code + '-' + it.city + '-' + it.state}}"/>
<h3>Try it out!</h3>
<p>Enter some of the five digit zips that are present in the the select above.
(Or enter something else and look at the error div)</p>
<label for="zipField">Zip</label><g:textField name="zipField"/>
<div id="zipError"></div>
<label for="cityField">City</label><g:textField name="cityField"/>
<label for="stateField">State</label><g:textField name="stateField"/>
<label for="phoneField">Phone Number</label> <g:textField name="phoneField"/>
</body>
</html>