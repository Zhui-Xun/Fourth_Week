package a_2_Subfun;

public class Caller_2 {

    SelfDefine_Exception caller3 = new SelfDefine_Exception();

    public void caller3_RTException() {
        System.out.println(" <Caller2.caller3_RTException> 开始...");
        caller3.callThrowRTException();
        System.out.println(" <Caller2.caller3_RTException> 结束!!!");
    }

    public void caller3_Exception() throws MyException {
        System.out.println(" <Caller2.caller3_Exception> 开始...");
        caller3.callThrowException();
        System.out.println(" <Caller2.caller3_Exception> 结束!!!");
    }

}


