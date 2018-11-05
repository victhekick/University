package de.htw.ai.kbe.runmerunner;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        

        
        
        new Cli(args).parse();
        
        
    }
}
