Work on new practicums before the next lab
 
Live coding today!
 
-------------------------------------------------------------------------------------------------------------------------------
 
class Money{
 
//instance variables  
private int dollars;  
private int cents;
 
//-- alternate constructors  
public Money(int dollars, int cents) throws InvalidCurrencyException, InvalidCentValueException {
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: dollars >= 0, 0 <0 cents <= 99  
//  
//Stores provided dollar and cent amount.  
//If dollars or cents < 0, throws InvalidCurrencyException  
//If Cents > 99, throws InvalidCentValueException.  
//---------------------------------------------------------------------------------------------------------------------
 
if ( dollars < 0 || cents < 0)  
throw new InvalidCurrencyException();
 
if(cents > 99)  
throw new InvalidCentValueException();
 
this.dollars = dollars;  
this.cens = cents;  
}
 
public Money(int cents) throws InvalidCurrencyException {  
//---------------------------------------------------------------------------------------------------------------------  
// precond: dollars >= 0, 0 <0 cents <= 99  
//  
// Stores cent amount as dollars and cents  
// If cents < 0, throws InvalidCurrencyException  
//---------------------------------------------------------------------------------------------------------------------
 
if (cents < 0)  
throw new InvalidCurrencyException();
 
this.dollars = cents / 100;  
this.cents = cents % 100;  
}
 
// copy constructor  
public Money(Money other) {
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: none  
//  
// Stores value of the provided Money object  
//---------------------------------------------------------------------------------------------------------------------
 
public int getDollars()
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: none  
//  
// Returns value of instance variable dollars.  
//---------------------------------------------------------------------------------------------------------------------
 
{ return dollars; }
   

public int getCents()
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: none  
//  
// Returns value of instance variable cents.  
//---------------------------------------------------------------------------------------------------------------------
 
{ return cents; }
 
public int totalCents()
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: none  
//  
// Returns value of instance variable cents.  
//---------------------------------------------------------------------------------------------------------------------
 
{ return (dollars * 100) + cents; }
   

public String toString()
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: none  
//  
// Returns value of instance variable cents.  
//---------------------------------------------------------------------------------------------------------------------
 
{ return "$" + dollars + "." + cents; }
   

//arithmetic operators  
public Money add(Money other) {  
//---------------------------------------------------------------------------------------------------------------------  
// precond: none  
//  
// Returns value of instance variable cents.  
//---------------------------------------------------------------------------------------------------------------------
 
/*  
int total_cents = getAllCents() + other. getAllCents();  
int total_dollars = total_cents / 100;  
int total_cents = total_cents % 100;
 
return new Money(total_dollars, total_cents);  
*/
 
return new Money(getAllCents() + other.getAllCents());  
}
 
public Money deduct(Money other) throws InsufficientFundsException{
 
//---------------------------------------------------------------------------------------------------------------------  
// precond: value of this object must be >= to value of provided money object in param Other  
//  
// Returns new money object containing the sum of the 2 values  
//---------------------------------------------------------------------------------------------------------------------
 
/*  
int remaining_cents = getAllCents() - other.getAllCents();
 
if(remaining_cents < 0 )  
throw newInvalidTransactionException();
 
return new Money(remaining_cents);  
}  
*/
 
try {  
return new Money(getAllCEnts() - other.getAllCents());  
}  
catch(InvalidCurrencyException e) {  
return new DeductionException();  
}  
}
          
public class InvalidCurrencyException extends RuntimeException {}