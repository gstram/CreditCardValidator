// Giuseppe Stramandinoli
// HW1
// Due September 30
import java.util.Scanner;


public class CreditCardNumberCheck 
{
	
	public static void main(String[] args) 
	{
		// Initialize scanner
		Scanner userInput = new Scanner(System.in);
		
		// Initialize variables needed
		String creditCardNumber;
		int cardNumberCheckTotal1 = 0, cardNumberCheckTotal2, cardNumberCheckTotal;
		int notIncluded1, notIncluded2, notIncluded3, notIncluded4;
		
		// Get user credit card number
		System.out.println("Please enter your 8 digit credit card number: ");
		creditCardNumber = userInput.next();
		
		// Make sure credit card number is 8 digits
		while (creditCardNumber.length() != 8)
		{
			// Display error
			System.out.println("Credit Card Number is invalid.");
			System.out.println();
			
			// Get user credit card number
			System.out.println("Please enter your 8 digit credit card number: ");
			creditCardNumber = userInput.next();
		}
	
		// Starting from the rightmost digit, form the sum of every other digit
		cardNumberCheckTotal1 = (creditCardNumber.charAt(7) - '0') + (creditCardNumber.charAt(5) - '0') + 
		(creditCardNumber.charAt(3) - '0') + (creditCardNumber.charAt(1) - '0');
		
		// Double all digits that were not included
		notIncluded1 = (creditCardNumber.charAt(0) -'0') * 2;
		notIncluded2 = (creditCardNumber.charAt(2) -'0') * 2;
		notIncluded3 = (creditCardNumber.charAt(4) -'0') * 2;
		notIncluded4 = (creditCardNumber.charAt(6) -'0') * 2;
		
		// Determine if number is a two digit or one digit number and add to total #2
		if(notIncluded1 > 9)
		{
			cardNumberCheckTotal2 = (notIncluded1 % 10) + ((notIncluded1 / 10) % 10);
		}
		else 
		{
			cardNumberCheckTotal2 = notIncluded1;
		}
		
		// Determine if number is a two digit or one digit number and add to total #2
		if(notIncluded2 > 9)
		{
			cardNumberCheckTotal2 = cardNumberCheckTotal2 + (notIncluded2 % 10) + ((notIncluded2 / 10) % 10);
		}
		else 
		{
			cardNumberCheckTotal2 = cardNumberCheckTotal2 + notIncluded2;
		}
		
		// Determine if number is a two digit or one digit number and add to total #2
		if(notIncluded3 > 9)
		{
			cardNumberCheckTotal2 = cardNumberCheckTotal2 + (notIncluded3 % 10) + ((notIncluded3 / 10) % 10);
		}
		else 
		{
			cardNumberCheckTotal2 = cardNumberCheckTotal2 + notIncluded3;
		}
		
		// Determine if number is a two digit or one digit number and add to total #2
		if(notIncluded4 > 9)
		{
			cardNumberCheckTotal2 = cardNumberCheckTotal2 + (notIncluded4 % 10) + ((notIncluded4 / 10) % 10);
		}
		else 
		{
			cardNumberCheckTotal2 = cardNumberCheckTotal2 + notIncluded4;
		}
		
		// Add the totals and determine if credit card number passes security check
		cardNumberCheckTotal = cardNumberCheckTotal1 + cardNumberCheckTotal2;
		
		// Tell user if credit card number is valid. If not, tell the user what the check 
		// digit must be to make the number valid
		if(cardNumberCheckTotal % 10 == 0)
		{
			System.out.println("The number is valid.");
		}
		else 
		{
			System.out.println("The number is not valid.");
			System.out.println("For the credit card number to be valid, the check digit must be ");
			
			if((creditCardNumber.charAt(7) -'0') < 5)
			{
				System.out.println(Math.abs((cardNumberCheckTotal % 10) - 10) + (creditCardNumber.charAt(7) -'0'));
			}
			else
				System.out.println(Math.abs((creditCardNumber.charAt(7) -'0') - (cardNumberCheckTotal % 10)));
			
		}
	}
 
}
