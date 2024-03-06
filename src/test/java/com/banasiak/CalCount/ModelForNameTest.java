package com.banasiak.CalCount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelForNameTest {



    @Test
    public void checkNameOdd(){
        //given
            String name = "test12343";
            int length = name.length();
            String substring2= "";
            String substring3= "";
            String substring4= "";
        //when
            int len = length /3;
            substring2 = name.substring(0 , len);
            substring3 = name.substring(len, len*2);
            substring4 = name.substring(len*2);
        //then
            Assertions.assertEquals(substring2, "tes");
            Assertions.assertEquals(substring3, "t12");
            Assertions.assertEquals(substring4, "343");
    }

    @Test
    public void checkNameOdd2(){
        //given
            String name = "MyName2";
            int length = name.length();
            String substring2= "";
            String substring3= "";
            String substring4= "";
        //when
            int len = length /3;
            substring2 = name.substring(0 , len);
            substring3 = name.substring(len, len*2);
            substring4 = name.substring(len*2);
        //then
            Assertions.assertEquals(substring2, "My");
            Assertions.assertEquals(substring3, "Na");
            Assertions.assertEquals(substring4, "me2");
    }


    @Test
    public void checkNameParity(){
        //given
            String name = "MyName";
            int length = name.length();
            String substring ="";
            String substring1= "";
        //when
            substring  = name.substring(0, length / 2);
            substring1 = name.substring((length / 2) );
        //then
            Assertions.assertEquals(substring, "MyN");
            Assertions.assertEquals(substring1, "ame");
    }



}
