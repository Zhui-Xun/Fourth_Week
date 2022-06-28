package a_2_Subfun;

import java.awt.print.PrinterIOException;

public class SelfDefine_Exception {

    // >> TODO 可以将checked exception包装成unchecked exception或者checked exception。反之也可以
    public void callThrowRTException() {
        // >> TODO 可以在这里catch异常，然后封装成自己的异常，并增加相应的异常描述
        System.out.println(" <SelfDefine_Exception.callThrowRTException> 开始...");
        try {
            Object n = null;
            n.toString();
        } catch (Exception ex) {
            System.out.println("程序抛出异常，错误信息如下：");
            throw new MyRuntimeException("执行callThrowRTException出错", ex);
        }
        System.out.println(" <SelfDefine_Exception.callThrowRTException> 结束!!!");
    }

    public void callThrowException() throws MyException {
        // >> TODO 可以在这里catch异常，然后封装成自己的异常，并增加相应的异常描述
        System.out.println(" <SelfDefine_Exception.callThrowException> 开始...");
        try {
            Class.forName("com.neverland.Rabbit");
        } catch (ClassNotFoundException ex) {
            //throw new MyException("", ex);
            System.out.println("程序正常结束，错误信息如下：");
            ex.printStackTrace();
        }
        System.out.println(" <SelfDefine_Exception.callThrowException> 结束!!!");
    }

}

