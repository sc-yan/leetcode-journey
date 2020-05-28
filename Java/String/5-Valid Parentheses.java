Easy Leetcode 14
1517474043
tags: 

方法1:
用stack

方法2:
去寻找最中间的那一对括号，然后替换成空string。然后再一遍一遍循环。牺牲了时间度


```
/*

*/

/*
方法1
Thoughts:
用stack来解决
### 
*/
class Solution{
    public boolean isValid(String s) {
	    Stack<Character> stack = new Stack<Character>();
	    for (char c : s.toCharArray()) {
		    if (c == '(')
			    stack.push(')');
		    else if (c == '{')
			    stack.push('}');
		    else if (c == '[')
			    stack.push(']');
		    else if (stack.isEmpty() || stack.pop() != c)
			    return false;
	    }
	return stack.isEmpty();
    }
}


/*
方法2

*/

class Solution {

    public boolean isValid(String s) {
	    while (s.indexOf("()") != -1 || s.indexOf("[]") != -1
            || s.indexOf("{}") != -1) {
            s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");
	    }
        
	    return s.length() == 0;
    }
}


```