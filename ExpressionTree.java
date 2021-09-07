import java.util.LinkedList;
public class ExpressionTree implements ExpressionTreeInterface{
    
    private ExpressionNode root;
    
    public ExpressionTree(String expression){
        
        LinkedList<ExpressionNode> stack = new LinkedList<>();
        String[] tokens = expression.split(" ");
        
        for(String token : tokens){
                          
            if(Character.isDigit(token.charAt(0))){
                    
               stack.push(new ExpressionNode(token));
                    
            }
                
            else{
                    
                ExpressionNode op = new ExpressionNode(token);
                    
                if(stack.size() != 0){
                    op.right = stack.pop();
                }
                else{
                    throw new RuntimeException("ILLEGAL POSTFIX EXPRESSION: Popped Empty Stack -- Too few operands");
                }
                    
                if(stack.size() != 0){
                    op.left = stack.pop();
                }
                else{
                    throw new RuntimeException("ILLEGAL POSTFIX EXPRESSION: Popped Empty Stack -- Too few operands");
                }
       
                stack.push(op);
                    
            }
                
        }
        
        if(stack.size() == 1){
            
            root = stack.pop();
            
        }
        
        else if(stack.size() == 0){
            
            throw new RuntimeException("ILLEGAL POSTFIX EXPRESSION: Popped Empty Stack -- Too few operands");
            
        }
        
        else if(stack.size() > 1){
            
            throw new RuntimeException("ILLEGAL POSTFIX EXPRESSION: Non-empty stack -- Too many operators");
            
        }
        
    }
    
    private static class ExpressionNode{
        
        public char operator;
        public int operand;
        public ExpressionNode left;
        public ExpressionNode right;
        
        public ExpressionNode(String data){
            
            try{
                
                operand = Integer.parseInt(data);
                
            }
            catch(Exception e){
                
                operator = data.charAt(0);
                
            }
            
        }
        
        public String toString(){
            
            if(this.left == null && this.right == null){
                
                return "" + operand;
                
            }
            
            return "" + operator;
            
        }
        
    }
    
    public int eval(){
        
        return eval(root);
        
    }
    
    private int eval(ExpressionNode n){
        
        if(n.left == null && n.right == null){
            
            return n.operand;
            
        }
        
        int leftVal = eval(n.left);
        int rightVal = eval(n.right);
        
        return calculate(n.operator, leftVal, rightVal);
        
    }
    
    private int calculate(char op, int lVal, int rVal){
        
        switch(op){
                
            case '+':
                return lVal + rVal;
                
            case '-':
                return lVal - rVal;
                
            case '*':
                return lVal * rVal;
                
            case '/':
                return lVal / rVal;
                
            default:
                return Integer.MIN_VALUE;
                
        }
        
    }
    
    public String postfix(){
        
        StringBuilder postfixSb = new StringBuilder();
        postfix(root, postfixSb);
        return postfixSb.toString().trim();
        
    }
    
    private void postfix(ExpressionNode n, StringBuilder sb){
        
        if(n == null){
            
            return;
            
        }
        
        if(n.left != null){
            
            postfix(n.left, sb);
            
        }
        
        if(n.right != null){
            
            postfix(n.right, sb);
            
        }
        
        sb.append(n);
        sb.append(" ");
        
    }
    
    public String infix(){
        
        StringBuilder infixSb = new StringBuilder();
        infix(root, infixSb);
        return infixSb.toString().trim();
        
    }
    
    private void infix(ExpressionNode n, StringBuilder sb){
    
        if(n == null){
            
            return;
            
        }
        
        if(n.left != null){
            
            if(n.left.left != null && n.left.right != null){
                sb.append("( ");
            }
            
            infix(n.left, sb);
            
            if(n.left.left != null && n.left.right != null){
                sb.append(") ");
            }
            
        }
        
        sb.append(n);
        sb.append(" ");
        
        if(n.right != null){
            
            if(n.right.left != null && n.right.right != null){
                sb.append("( ");
            }
           
            infix(n.right, sb);
          
            if(n.right.left != null && n.right.right != null){
                sb.append(") ");
            }
            
        }
         
    }
    
    public String prefix(){
        
        StringBuilder prefixSb = new StringBuilder();
        prefix(root, prefixSb);
        return prefixSb.toString().trim();
        
    }
    
    private void prefix(ExpressionNode n, StringBuilder sb){
        
        sb.append(n);
        sb.append(" ");
        
        if(n.left != null){
            
            prefix(n.left, sb);
            
        }
        
        if(n.right != null){
            
            prefix(n.right, sb);
                
        }
        
    }
    
    public String toString(){
        
        StringBuilder out = new StringBuilder();
        toString(root, out, 0);
        return out.toString();
        
    }
    
    private void toString(ExpressionNode n, StringBuilder s, int depth){
        
        if(n == null){
            
            return;
            
        }
        
        toString(n.right, s, depth + 1);
        
        for(int i = 0; i < depth; i++){
            
            s.append("   ");
            
        }
        
        s.append(n);
        s.append("\n");
        
        toString(n.left, s, depth + 1);
        
    }
    
}