# Manual for Salary Comparator

## Introduction
This is an app you can use to calculate how much money you need to make in a new city in order to afford a **similar** standard of living in your current city

## Instruction
1. Step 1: Input a *Valid* salary number as "Base Salary". A valid number should be a positive integer.

2. Step 2: Choose a city from the list of "Current City". This could be the current city you are living in now, or any city you are interested.

3. Step 3: Choose a city from the list of "New City". 

The result will be showed automaticly as "Target Salary".

## Supplement
### salary calculation
The target salary in new city is calculated as follows:
1. multiplying the Base Salary by the New City’s cost of living index
2. dividing the resulting number by the Current City’s cost of living index 
3. [rounding](https://www.factmonster.com/math/numbers/rounding-numbers-rules-examples-fractions-sums) the result of the division to the nearest whole dollar.

### candidate cities
Here are the cities you can choose in the app

City   |   Cost of Living Index
------ | --------------------
Atlanta, GA | 160
Austin, TX  | 152
Boston, MA  | 197
Honolulu, HI | 201
Las Vegas, NV | 153
Mountain View, CA | 244
New York City, NY | 232
San Francisco, CA | 241
Seattle, WA | 198
Springfield, MO | 114
Tampa, FL | 139
Washington D.C. | 217



