# Test excercise 3 (Test Case Design Exercise)
This is a mini project for the test course. The exercise is based off the description in this [resource](https://github.com/datsoftlyngby/soft2018spring-test-teaching-material/blob/master/exercises/Test%20Case%20Exercises.pdf)

## Description
This exercise is to practise using black box testing techniques. It is touching topics such as: Equivalence classes, Boundary value analysis, Decision table testing and state transition testing.

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

Note: I was wondering whether to remove Rule 2 and 4. Since they are not valid. For any reimburshment, the deductible needs to be meet. In rule 2 and 4, it is not. So those are invalid cases with no outcome, unless an outcome would be "No reinburshment"..
Therefor i have added "No reimbursment"

-----------------------------------------

- 2). Make a decision table for leap years.


Conditions:                | Rule 1 | Rule 2 | Rule 3 | Rule 4 | 
-------------------------- |:------:|:------:|:------:|:------:|
Year Divisible by 4        | T | T | T | T |         
Year Divisble by 100       | T | T | F | F |  
Year Divisble by 400       | T | F | T | F | 
**Actions/Outcomes:**      | **¤** | **¤** | **¤** | **¤** | 
Leap year                  | Y | - | Y | Y |

Note: I removed cases where year is not divisble by 4, because that is by default not a leap year. So not relevant in this case.

-----------

### State Transition

- 1). Make a state diagram hat depicts the state of MyArrayListWithBugs.java and show the events that cause a change from one state to another. (ie. transition.)

Action | State | Next state
---------------------:| ----------- | --------------
MyArrayListWithBugs() | S1 | S2
Add(Object o) | S2 | S2
Size() | S2 | S2
Succesfully get(int Index) | S2 | S2
OutOfBounds get(int index) | S2 | S3
Succesfully add(int index, object e) | S2 | S2
OutOfBounds add(int index, object e) | S2 | S3
Succesfully remove(int index) | S2 | S2
OutOfBounds remove(int index) | S2 | S3


S1 = Startstate, S2 = Working, idle, ready state. S3 = Error, exception chrashed state.

![Alt text](Statemachinediagram1.png?raw=true "State Transition Diagram")

----------------------

- 2). Derive test cases from the state diagram

It is assumed that for all tests below, it will Construct new MyArrayListWithBugs() for each test case first. Excuse the psudocode.

TC# | Testcase 
---:| ----------------------------------------------------
1 | Assert Size 0 -> Add(Object o) -> Assert size 1
2 | Add(object o1) -> Add(object o2) -> Add(object o3) -> Assert size 3 -> assert get(2)==o3
3 | Add(object o1) -> Add(object o2) -> Add(object o3) -> Assert size 3 -> remove(0) -> Assert size 2
4 | Add(object o1) -> Add(object o2) -> Add(object o3) -> Assert size 3 -> remove(1) -> Assert OutofBounds get(1)
5 | Add(object o1) -> Add(object o2) -> Add(object o3) -> Assert size 3 -> Assert OutOfBounds Add(0, o4)
6 | Add(object o1) -> Add(object o2) -> Add(object o3) -> Assert size 3 -> remove(3) -> add(525, o4) -> Assert get(525)==o4 -> assert Size 4

7 | Add(object o1) -> Add(object o2) -> Assert size 2 -> Assert OutOfBounds remove(3)
8 | Add(object o) -> Add(object o) -> Adding 12 objects -> Assert size 12

------------------------------------------

- 3). Implement automated unit tests runing the test cases above.

Code has been copied to IDE and JUnit 5 tests has been made. See [MyArrayListWithBugsTests](test/MyArrayListWithBugs.java)

------------------------------------------

- 4). Detect, locate and fix as many errors as possible in the class

After running the Unittests. Some passed, and some failed.
[![https://gyazo.com/610bdb6d5fff0e85aff52030edcd7660](https://i.gyazo.com/610bdb6d5fff0e85aff52030edcd7660.png)](https://gyazo.com/610bdb6d5fff0e85aff52030edcd7660)

On the outlook of it, i was expecting that it would throw exception when you delete an index and then proceed to get that object of that index that was just deleted. Also expected that you cannot overwrite. Got an IndexOutOfBoundsException by using 525 as index.

To take Blackbox testing techniques into consideration. Maybe some boundary value analysis might be helpfull. A test case from this would be:

IndexOutOfBounds | Valid  | IndexOutofBounds
-------:|:------:|:------------
-∞ to -1 | 0 to maxint | maxint+1 to ∞

I added the following test cases on the boundaries between IndexOutOfBounds and Valid, on both sides.

TC# | Boundary Testcase
---:| --------------------------------------------
1 | Assert OutOfBounds Add(-1, o)
2 | Add(0, o) -> Assert size 1
3 | Add(maxint, o) -> Assert size 1
4 | Assert OutOfBounds Add(maxint+1, o)

Now, when running these tests, some surprising results appear.
[![https://gyazo.com/7af7a8311faa343b732986326f298261](https://i.gyazo.com/7af7a8311faa343b732986326f298261.png)](https://gyazo.com/7af7a8311faa343b732986326f298261)

Very simple tests, where adding a object at index 0 and then asserting size is 1 fails. Something wrong goes on there. 
And also does throw out of bounds exception for max int. Indexing might work a little different than what previusly thought.

Looking into the code. These are the things i notice first, which i find very strange or perculiar.

    - size() actully returns not length of list, but the variable nextFree.
    - get(int index), doesn't like 0 as a index, which is should be able to handle. (This might be a bug that is ideal to be caught with Boundary Value analysis test case)
    - The list is getting initialized with a size of 5, and will only get double as long. So it is impossible to add at index that hasn't been set yet.
    
Therefore, i changed size to
```java
public int size()
{
   return list.length;
}
```

and removed the "=" sign in line 34 of object get. To actully allow for 0 in the get method, so it wont throw outofbounds.

------------------- 
After having done these changes. All ```size()```method calls, will now have 5, because it is counting the empty places as being a size, therefor reverting cause i'm unsure of what the wished functionality is.

Considering what has been discovered. It is now very clear why some of the test cases fails.

    - TC4: Fails because it is actully pushing every previus values down, so the previus object at index 2 will now populate index 1. Therefor it will not throw exception because it is completely valid to get object at index 1. (Might be inteded, don't know.)
    - TC5: Fails because it is assumed that you cannot overwrite, but what the method actully does, is to insert and shift all objects instead. Therefor it should not throw, it is valid action. (Might be inteded, don't know.)
    - TC6: Fails because, index cannot be higher than nextavailable. You cannot put an object into unresonable high index. (Might be inteded, don't know.)
    - BoundaryTest1: Fails, because nextFree does not get added up, this might very well be a bug.
    - BoundaryTest2: Fails, because of the same reson TC6 does.
    
Additionally i played a little bit around with debugging the code after this to see how it actully works under the hood, if there were something that were out of order.
[![https://gyazo.com/672e3ea9dcedec2cbbd782d2bb11aab8](https://i.gyazo.com/672e3ea9dcedec2cbbd782d2bb11aab8.png)](https://gyazo.com/672e3ea9dcedec2cbbd782d2bb11aab8)    

I found that, when adding object to the list with the index option, it is confirmed that it does not add up nextFree, so an addition to the method like below, will fix it:
```java
nextFree++;
```
Before the shift for loop, but if after. the foor loop needs to have removed the -1 on nextfree.

Reviewing and studying the code. There was also something else which was a problem with the get method. As the code was, you were able to get the nextFree index. Which should not be available. Only those who have been aded. Therefor a change to the get will also include <= nextFree. Like this:
```java
    public Object get(int index)
    {
        if(index < 0 || nextFree <= index)   //////////////////////////////////////////// This line
            throw new IndexOutOfBoundsException("Error (get): Invalid index" +
                    index);

        return list[index];
    }
```

Furthermore, in the remove method. It doesn't actully remove the last object in the list. So you'll end up with duplicated values at array[last] and array[last+1]. Until the next add overwrites it ofcause.

--------------------------------------------------

- 5). Consider whether a state table is more useful design technique. Comment on that.

A state table can be a usefull design technique, if the states are of importance. But i also think it was usefull for specifying the transitions. Which can represent the core functionality or inteded behavior of the code. In that regards i find state table very usefull.
But to say, it is more usefull. I would say it depends on compared to what, in what situation. I would say it all depends on what is being tested. I find using boundary testing very usefull when you know a defined finite set of input values you know how the system should behave when given. 
I find equivelance classes very handy when you have infinite semi defined sets of input values, just like the odd/even case. I find decision tables handy in cases where complications and many conditions determine the outcome. 
I think state transitions is handy in matter wheres states and transitions matter in statefull solutions, like a pin code lock where you can only try 3 times before it eats the card, or will allow acces if correct code.

----------------------------------------

- 6). Make a conclusion where you specify the level of test coverage and argue for your chosen level:

This depends on a few things. In this example, the amount of possible states is very huge. So measuring test coverage by that would be foolish in my opinion. In this case with the ArrayList class, i believe it is more effective to test transitions, ie. the adding, removing and getting of objects and such.
It would have been a little different if the states were more important.
Like with the pin code lock case. Then it would have been important to test against states, since it is important to know that when you have tried 2 times, you still have 1 try left.


I will specifify the level of test coverage as Percentage of transitions exercised.

---------------------------------------------

### Note for teacher
I think regarding testing actual code. I think it is hard to actully test code, since we have no "Product owner" to ask, if the code is functioning as inteded or if it is a bug/defect. A bug or defect is only a bug or defect if behavior doesn't corelate with wishes. If no wishes or requirements are set. We have to make them up as we go ourselves. I would love to have had a more fixed requirements or set things to hammer down requirements, to know if a behavior is bug or not. I'm not to comfy with guesing :D

Testing is harder than i thought. 
