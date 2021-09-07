Models an expression tree.

The operands will be integers and the operators will be restricted to +, -, \*, and /. Individual tokens, that is, the operands and operators, will be delimited by only one space. So for example:

34 2 - 5 *

would mean (34-2)\*5.

METHODS
* ```public int eval()``` - this method, when invoked on an expression tree object, will return the integer result of evaluating the expression tree. 
* ```public String postfix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding postfix expression.
* ```public String prefix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding prefix expression.
* ```public String infix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding correct infix expression.
* ```public ExpressionTree(String expression)``` - this is the constructor of the expression tree.  It takes in a String that stores a postfix expression (as indicated above) and builds the expression tree from that postfix expression.
