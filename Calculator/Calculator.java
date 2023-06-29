package ramana.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Calculator {

    private int firstNumber = 0;
    private int result = 0;
    private int secondNumber = 0;
    private String error;

    public String add() {
        if (firstNumber == 0 || secondNumber == 0) {
            error = "Zeroes Not Accepted";
            return null;
        }
        result = firstNumber + secondNumber;
        return "success";
    }

    public String multiply() {
        if (firstNumber == 0 || secondNumber == 0) {
            error = "Zeroes Not Accepted";
            return null;
        }
        result = firstNumber * secondNumber;
        return "success";
    }

    public String clear() {
        firstNumber=0;
        secondNumber=0;
        return null;
    }


    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
