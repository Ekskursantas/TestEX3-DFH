# Test excercise 3 (Test Case Design Exercise)
This is a mini project for the test course. The exercise is based off the description in this [resource](https://github.com/datsoftlyngby/soft2018spring-test-teaching-material/blob/master/exercises/Test%20Case%20Exercises.pdf)

## Description



The result is this repository that include blabla bla and below documentation.


### Equivalence classes

- 1). Make equivalences classes for the input variable for this method: 
```java
public boolean isEven(int n)
```

Equivalence classes | Test Case
------------------ | ------------------------
n modolus 2 != 0 (n % 2 != 0)  | Odd (False): 53
n modolus 2 == 0 (n % 2 == 0) | Even (True): 56

------------------------

- 2). Make equivalances classes for an input variable that represents a mortgage applicant's salary. The valid range is $1000 pr. month to $75,000 pr. month.


Equivalence classes | Test Case
------------------- | ----------------
amount < 1000 | Invalid : 500
1000 <= ammount <= 75000 | Valid: 25000
75000 < ammount | Invalid: 10000000

-------------

- 3). Make equivalences classes for the input variables for this method:

```java
public static int getNumDaysinMonth(int month, int year)
```

Note: Technically, you can calculate all future number of days in a month, and all previus ones aswell. But i am not sure if this specific method can. Assuming it can making the integer year pretty irelevant to include, therefor i will assume it can not calculate earlier than 0

Equivalance classes       | Test Case
------------------------- | -------------------
0 < month < 13   | Valid: 2
0 > month or month > 13     | Invalid: -3  or 16
0 <= year | Valid : 4018
0 > year | Invalid: -232

-----------------------

### Boundary Analysis
Do boundary value analysis for input value exercise.

- 1).

I find this one very hard to find generalized boundaries. In my optic, there is infinite boundaries.

Odd | Even | Odd | Even | Odd | Even | etc.
---:| --- | --- | --- | --- | --- | ----
1 | 2 - 2 | 3 - 3 | 4 - 4 | 5 - 5 | 6 - 6 | ...

It is boundaryless :-D

- 2).

Invalid | Valid | Invalid
-----------:|:--------:|:--------
-∞ to 999 | 1000 to 75000 | 75001 to ∞

- 3).

Month

Invalid | Valid  | Invalid
-------:|:------:|:------------
-∞ to 0 | 1 to 12 | 13 to ∞


Year

Invalid | Valid
-------:|:-------
-∞ to 0 | 1 to ∞

----------

### Decision tables

- 1). Make a decision table for example business case. [resource](https://github.com/datsoftlyngby/soft2018spring-test-teaching-material/blob/master/exercises/Test%20Case%20Exercises.pdf)

Conditions:                | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
-------------------------- |:------:|:------:|:------:|:------:|
Doctors Office          | T | T | F | F
Dedutible meet          | T | F | T | F
**Actions/Outcomes:**       | **¤** | **¤** | **¤** | **¤**
50% reimbursed          | Y | - | - | -
80% reimbursed          | - | - | Y | -
0% reimbursed           | - | Y | - | Y

I was wondering whether to remove Rule 2 and 4. Since they are not valid. For any reimburshment, the deductible needs to be meet. In rule 2 and 4, it is not. So those are invalid cases with no outcome, unless an outcome would be "No reinburshment"..
Therefor i have added "No reimbursment"

- 2). Make a decision table for leap years.


Conditions:                | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
-------------------------- |:------:|:------:|:------:|:------:|
Doctors Office          | T | T | F | F
Dedutible meet          | T | F | T | F
**Actions/Outcomes:**       | **¤** | **¤** | **¤** | **¤**
50% reimbursed          | Y | - | - | -
80% reimbursed          | - | - | Y | -
0% reimbursed           | - | Y | - | Y


-----------

### State Transition

- 1). Make a state diagram hat depicts the state of MyArrayListWithBugs.java and show the events that cause a change from one state to another. (ie. transition.)

- 2). Derive test cases from the state diagram

- 3). Implement automated unit tests uning the test cases above.

- 4). Detect, locate and fix as many errors as possible in the class
>- a. 
>- b. 
>- c.
>- d. 

- 5). Consider whether a state table is more useful design technique. Comment on that.

- 6). Make a conclusion where you specify the level of test coverage and argue for your chosen level:
