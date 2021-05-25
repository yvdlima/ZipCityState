# :biohazard: :biohazard: Zip-City-State Plugin :biohazard: :biohazard:

[![](https://jitpack.io/v/yvdlima/ZipCityState.svg)](https://jitpack.io/#yvdlima/ZipCityState)

**This is a port from the original plugin for Grails 4 because I needed for legacy projects, but really, you shouldn't use this, it has 0 tests, does some really bad stuff with the javascript injection and is not useful enough to justify it's existence. STAY AWAY!**

Use version 2.0.2 for Grails 3

## About

Provides utilities to populate the City and State from a given 5 digit zip code. Due to licensing concerns no postal
code data will be packaged with this plugin. The original intent of this plugin was to allow users to easily implement
their own zip code database and lookup.  The design is such that you can easily utilize an external service if you would
prefer.

## Dependencies

This plugin requires jQuery (no strict requirement on version) **It will inject a older version of jQuery every time you use the tag lib, it really sucks!**

## Installation

Add the following to the `build.gradle` file of your Grails project:

```java
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile compile 'com.github.yvdlima:ZipCityState:3.0.0'
}
```

## Demo Project

You can see how the plugin works and develop on it here: <https://github.com/yvdlima/ZipCityStateDemo/>

# Implementation Instructions

Maintain your own database

1. Create a domain class with the zip code info (city,state,zip).
   
    A simple example can be found in the project [ZipCityStateDemo](https://github.com/yvdlima/ZipCityStateDemo/blob/main/grails-app/domain/zipcitystatedemo/ZipCode.groovy)

2. Provide a service which implements the [CityStateLookup](src/main/groovy/grails/plugin/zipcitystate/CityStateLookup.groovy) interface.
   
    An example using the above domain class is provided in the project source [ZipCodeService](https://github.com/yvdlima/ZipCityStateDemo/blob/main/grails-app/services/zipcitystatedemo/ZipCodeService.groovy)
    and copied here:

    ```java
    class ZipCodeService implements CityStateLookup {
        @Override
        ZipCityState lookupByZip(String code) {
            def zipCode = ZipCode.findByCode(code)
            zipCode ? [code:zipCode.code,city:zipCode.city,state:zipCode.state] as ZipCityState : null
        }
    }
    ```

3. Tell the plugin the name of the service bean you created in step 2.
   E.g. ```application.yml```

    ```java
    zipcitystate:
        cityStateLookupService:
            beanName: zipCodeService
    ```
4. Create your gsp
   a. Place the tag to include the necessary js on your page (will use the asset pipeline plugin if installed in your application)

    ```html
    <zipcitystate:resources/>
    ```
b. Bind the javascript function and event to your zip code field. An example usage is provided below:

    ```javascript
    $("#zipField").ziplookup()
    .on('zipChange',function(event, state, city, zip) {
       //populate the city and state
       $("#cityField").val(city);
       $("#stateField").val(state);
       //automatically move the cursor to the field that comes next
       $("#phoneField").focus();
    })
    .on('zipNotFound',function(event,zip) {
        //maybe display something or just do nothing
        $("zipError").html('Zip not found!');
    });
    ```
5. Add the following ```require``` directive to the application manifest file ```grails/assets/javascripts/application.js```

    ```javascript
    //= require zip-city-state
    ```
6. Test it out!
