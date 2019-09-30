# raphamendonca-fizzbuzz
FizzBuzz game api

This is a FizzBuzz game API

## Rules

- If the informed number is could be divide by 3 will be returned "Fizz";
- If the informed number is could be divide by 5 will be returned "Buzz";
- If the informed number is could be divide by 15 will be returned "FizzBuzz";
- If is not divide by 3, 5 or 15 the given umber will be returned;

## Usage

Use the follow URL to reach the API:
    https://raphamendonca-fizzbuzz.herokuapp.com/

here the Swagger of the API:
**https://raphamendonca-fizzbuzz.herokuapp.com/swagger-ui.html**

To obtain the FizzBuzz list of the range 1 to 100. 
    Use the GET operation on: **https://raphamendonca-fizzbuzz.herokuapp.com/fizz-buzz**

To check if a number is a fizz, buzz or fizBuzz, add the number what you want to check as a path parameters of the operation
    Use the GET operation on: **https://raphamendonca-fizzbuzz.herokuapp.com/fizz-buzz/3**

To check more than one number in the same request. Inform them all separated with comma.
    Use the GET operation on: **https://raphamendonca-fizzbuzz.herokuapp.com/fizz-buzz/3,7,25,19,45,32**

## Obs
Can be informed only integers numbers(positive or negative)

If is informed letters, decimals, or especial characters, will be returned HTTP status 400-Bad Request.

