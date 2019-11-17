CurrencyExchange is a commandline application developed to get exchange amount from one cureency to another as per the exchange curreny locale .

It is developed using spring-shell.

Testcases are included to test the functionality and different user input formats.


Instructions to run:

To run the CurrencyExchange application,

1) mvn clean package.
2) mvn spring-boot:run
   or
   java -jar target\CurrencyExchangeApplication-1.0.jar
3) exchange <main currency/money currency> <amount>
   
   shell:>exchange EUR/DKK 10
          74,7
   shell:>exchange EUR/DKK 10000
          74.700
          
          
To run the test cases, "mvn test".

