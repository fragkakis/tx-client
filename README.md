tx-client
=========

This project is a Java client of the RESTful API of [Transifex](www.transifex.com).

The API is described [here](http://docs.transifex.com/developer/api/).

Parts of the client API are still missing or in progress.

Implementation
--------------

The client uses JaxRS 2.0 annotations, so this is the only compile-time dependency.
In order for it to run, a JaxRS 2.0 implementation needs to be in the classpath.

The project is built with Maven and uses TestNG to run the unit tests.
In order to run the tests, RestEasy is added as test-time dependency.

Copyright and license
---------------------

Code and documentation copyright 2014-2015 Markos Fragkakis. Code released under the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).
