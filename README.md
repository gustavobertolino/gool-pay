# gool-pay
**Payment processing system specific for web store clients.**
**For training purpose only**

The payment flow works as following:

    User chooses restaurant and order item - then proceeds to checkout
    Specific payment methods are listed to the user, depending on the restaurant configuration and risk analysis
    User chooses payment method and submits the order

Task Instructions

Implement a micro service to list available payment methods to the end user and process the payment request (steps #2 and #3).
Tasks

    Given a restaurant id, return the payment methods (card brands) available for it, and return to the end user (list payments). Payments can be online (credit cards), or offline (cash, POS machines).
    Process a payment (mock external calls)

Consider the following:

    The service should be able to answer tens of thousands of requests per minute
    The configuration information does not change often
    The payment configuration depends on the restaurant and the end user
    Available payment methods can be offline (cash, check, POS machine) or online (credit card or digital wallet)
    If the user requesting for the payment methods is a fraudster, the service should return only offline payment options
    Your data model should be flexible enough to permit cost ($) optimizations (should be easy to update)
    Gateways often have outages, but processing payments should continue working in these situations



