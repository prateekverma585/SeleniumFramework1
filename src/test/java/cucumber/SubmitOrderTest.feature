Feature: Purchase the order from Ecommerce website
I want to use this template for my feature file

	   Background:
        Given I landed on Ecommerce page
	   
	    Scenario Outline: Positive test to submitting the order
        Given Logged in with <name> and <password>
        When I checked for the <productName> to cart
        And Checkout <productName> and submit the order
        Then "THANKYOU FOR THE ORDER." message is displayed on confiramtion page
        
        Examples:
        | 	                 name  				|			password 		|		productName    	|
        | 	veenarecordsinc@gmail.com  			|			HareRam@123		|		ZARA COAT 3		|
        |	prateekverma585@gmail.com           |			RadhaRani@123	|		ADIDAS ORIGINAL	|	
 