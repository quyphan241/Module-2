public class Calculator {
    private static float firstOperand;
    private static float secondOperand;
    private static String Operator;

    public static float calculate(float firstOperand,float secondOperand, String operator) {
        float result;
        switch (operator){
            case "+":
                result=firstOperand+secondOperand;
                break;
            case "-":
                result=firstOperand-secondOperand;
                break;
            case "*":
                result=firstOperand*secondOperand;
                break;
            case "/":
                if (secondOperand!=0)
                    result=firstOperand/secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
                break;
            default:
                throw new IllegalStateException("Unexpected operator: " + Operator);
        }
        return result;
    }
}
