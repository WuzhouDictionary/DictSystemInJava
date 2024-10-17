package top.mryan2005.managesysteminjava.BasicClass;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringProcessed {
    public byte[] string;

    public StringProcessed(String radicalTraditional) {
        handleUncommonWord(radicalTraditional);
    }

    public String handleUncommonWord(String input) {
        try {
            if(input == null) {
                return "";
            }
            byte[] gbkBytes = Charset.forName("GBK").encode(input).array();
            String gbkString = new String(gbkBytes, "GBK");
            System.out.println("处理后的生僻词：" + gbkString);
            this.string = gbkBytes;
            return gbkString;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
