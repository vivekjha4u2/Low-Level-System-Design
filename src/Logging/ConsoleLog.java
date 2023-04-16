package Logging;

public class ConsoleLog implements Logger{
    @Override
    public void consoleLog(String data) {
        System.out.println(data);
    }


}
