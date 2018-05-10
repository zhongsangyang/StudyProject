package ioStudy;

public class TestCodeString {
    static  {
        System.out.println("1");

    }
    {
        System.out.println("2");

    }
    {
        System.err.println("3");

    }

    public static void main(String[] args) {
        new TestCodeString();
    }

}
