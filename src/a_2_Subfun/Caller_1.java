package a_2_Subfun;

public class Caller_1 {
    Caller_2 caller2 = new Caller_2();

    public void caller2_RTException() {
        System.out.println(" <Caller1.caller2_RTException> 开始...");
        caller2.caller3_RTException();
        System.out.println(" <Caller1.caller2_RTException> 结束!!!");
    }

    public void caller2_Exception() throws MyException {
        System.out.println(" <Caller1.caller2_Exception> 开始...");
        caller2.caller3_Exception();
        System.out.println(" <Caller1.caller2_Exception> 结束!!!");
    }

}


