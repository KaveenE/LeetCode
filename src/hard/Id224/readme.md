## Basic Calculator I ##
`
int result = 0;
int number = 0;
int sign = 1;
`
As you scan the string, maintain the 3 variables above + if character is

1.	Number: Convert to number
2.	Operator: Perform operation → reset `number=0` → Negate sign if operator is –
    1.	We negate sign since operation is performed via `result += sign * number`
3.	Bracket:
    1.	Opener: This is a start of new expression so save (push) your `result/sign` in a stack and reset `result/sign` for this expression
    2.	Closer: With the end of expression, perform operation → reset `number=0` 
        → Pop the cached `result/sign` from stack and update the `result`

After scanning, perform 1 last operation if last `number != 0`