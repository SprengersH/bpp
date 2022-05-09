/*
 * Copyright (c) 2022. Ted Sprengers
 */

package ted.algemeen;

public class StringTools
{

    static public String getParameter(String[] args, String key)
    {
        for(String s : args){
            int i = s.indexOf('=');
            if(i<1)
                return null;
            if(s.substring(0,i).trim().equalsIgnoreCase(key))
                return s.substring(i+1).trim();
        }

        return null;
    } // replace

}
