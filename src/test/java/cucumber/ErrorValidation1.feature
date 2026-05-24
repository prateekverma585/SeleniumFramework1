Feature: Error Validation
I want to use this template for my feature file
	   
	   	@Regression
	    Scenario Outline: Negative test to submitting the order
        Given I landed on Ecommerce page
        When  Logged in with <name> and <password>
        Then "Incorrect email or password." message is displayed
        
        Examples:
        | 	                 name  				|			password 		|		productName    	|
        | 	veenarecordsinc@gmail.com  			|			HareRam@1-23		|		ZARA COAT 3		|
        |	prateekverma585@gmail.com           |			RadhaRani123	|		ADIDAS ORIGINAL	|	
 