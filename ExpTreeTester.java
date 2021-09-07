public class ExpTreeTester{
    
    public static void main(String[] args){
        
        String postfixExpression = "34 2 - 5 *";
        ExpressionTree eTree = new ExpressionTree(postfixExpression);
        
        System.out.println("EXPRESSION TREE FROM POSTFIX [" + postfixExpression + "]");
        System.out.println(eTree);
        
        System.out.println("EVAL: " + eTree.eval());
        System.out.println("POSTFIX: " + eTree.postfix());
        System.out.println("PREFIX: " + eTree.prefix());
        System.out.println("INFIX: " + eTree.infix());
        
    }
    
}