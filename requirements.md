# Requirements
 
#Functional Requirements
The idea of this challenge is to solve a common problem in the day-to-day of those who share lunches/snacks with the work team. Let's imagine that you and another colleague want to share a snack that you're ordering through iFood/Uber Eats using your smartphone. It is easy to figure out how much your colleague will have to pay you when there is no discount or delivery charge, but when these factors come into question, simply splitting the amount in half may not be the fairest.

To better illustrate this situation, let's assume that you ordered a hamburger for R$40.00 and a dessert for R$2.00, while your friend ordered only a sandwich for R$8.00. Therefore, you will initially pay a total of R$42.00 while your friend will pay R$8.00. However, also consider that the total order had an additional cost of R$8.00 for delivery and that there was a discount of R$20.00 on the total order. Therefore, it is fair that the delivery and discount are proportional to the value of the items that each one purchased. In this case, we have the following:
	
	• Burger = 40.00
	• Dessert = 2.00
	• Sandwich (friend) = 8.00
	• Total = 50.00
	• Delivery = 8.00
	• Discount = 20.00
	• Total payable = 38.00

So, out of the R$38.00, your friend will have to pay R$6.08, while you will pay R$31.92, which corresponds to the discount and delivery proportional to the items that were requested by each one.

With the aim of making this calculation easier, you should create a small application that will calculate the total that your friends will have to pay you when they share a lunch. In the end, you will have to simplify the payment by generating a Picpay link (or another wallet of your choice), to send the charge to your friends. *Note: There may be numerous ways to facilitate this charge, and Picpay mentioned here is just one of them, so leave your code adaptable to receive any other payment methods that may be later integrated into your application.

# Technical Requirements
1. Back-end must be done in Java, using frameworks of your choice

2. There must be unit tests

3. Consider that you can share the account with one or more friends

4. Consider that there may be discounts and additions in reais, and also in percentage (for example, the waiter's 10%, when lunch is at a physical restaurant)

5. Front-end will not be evaluated, since the focus of this challenge is the back-end, but it must contain the minimum necessary to input data and interact with the back-end

6. Back/front must be fully decoupled

7. Code must be available in a git repository (bitbucket, github and the like)

# What will be evaluated

1. Clean code

2. Code organization and use of Object Orientation

3. Maintainability

4. Tests
