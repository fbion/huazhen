/**
 * Created by 磊 on 2015/12/4.
 */
public class Test {

    @org.junit.Test
    public void turnSQLVariable(){
        String variable = "inUserNo";
        String result="";
        for (int i = 0; i < variable.length(); i++) {
            char c = variable.charAt(i);
            if (Character.isUpperCase(c)){
                result = result + "_" + Character.toLowerCase(c);
            }
            else{
                result +=c;
            }
        }
        System.out.print(result);
    }
}
