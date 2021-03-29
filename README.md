# Restaurant API

This API searchs for restaurants based on specific parameters.

The parameters supported are:
- name: it is the restaurant name. It will search for restaurant names that contains this value. It will ignores upper or even lower cases. Max: 100 chars.
- rating: the customer rating. It will search for greater or equal than the value specified. Numeric values.
- distance: the distance. It will search for less or equal than the value specified. Numeric values.
- price: the average price by one peson. It will search for less or equal than the value specified. Decimal values.
- cuisine: the kind of cuisine offered by the restaurant. It will search for restaurant cuisine that contains this value. It will ignores upper or even lower cases.

The API, by definition, returns up to five restaurs by GET.

## Examples of GETs

This will search for 
```
curl --location --request GET 'http://localhost:8080/api/v1/restaurants'
```

This will search for restaurant that contains 'Delicious' in its name: 
```
curl --location --request GET 'http://localhost:8080/api/v1/restaurants?name=Delicious'
```

A more complext query supported by the API:
```
curl --location --request GET 'http://localhost:8080/api/v1/restaurants?rating=4&distance=5&price=50&name=Delicious&cuisine=spanish'
```

## Execution

In order to run the API, you need to have installed in your machine the following technologies: 
- at least Java 8;
- maven 3.6.3 or higher;

Ensure that you have all of them configured properly. After the installation you have to configure the enviroment:

### Java 8

export JAVA_HOME=/usr/java/jdk1.5.0_07/bin/java
