```
int number=0, polarity=0;
char operatorOfNumber='+';
```
**Idea**:
1. Scan string
	1. If *operand*, update `number`
	2. If *operator*,
		1. If `+` or `-`, push `number` multiplied by `polarity` into stack
		2. If `*` or `/`, pop stack, perform operation with `number`, push that into stack
		3. Update `number` to 0 since its used up in stack or for operation. Update `operatorOfNumber`
2. Iterate stack and return sum

**Rationale**:<br/>
Will let us obtain a stack such as below to allow us you to convert do *step 2*

What if got **brackets**?<br/>
- Apply algo recursively to the substring within bracket.
- For optimization, pass in the index of substring you want to iterate from AND NOT substring itself
- Recursive function should return the index at which substring ended, ie `)` and the result for that recursive function
