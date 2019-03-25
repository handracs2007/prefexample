package com.handra.learn.preferences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

public class Main {

    public static void main ( String[] args ) {
        try ( BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) ) ) {
            System.out.println ( "Hi, welcome to Java Preferences API Sample" );

            Preferences systemPrefs = Preferences.systemRoot ( ).node ( "com/handra/learn/prefexample" );

            System.out.println ( "\nPrevious system config value for \"test\": " + systemPrefs.get ( "test" , "" ) );
            System.out.print ( "Enter new value for \"test\": " );

            String newValue = reader.readLine ( );
            systemPrefs.put ( "test" , newValue );
            System.out.println ( "New value saved" );

            Preferences userPrefs = Preferences.userRoot ( ).node ( "com/handra/learn/prefexample/handra" );

            System.out.println ( "\nPrevious user config value for \"test\": " + userPrefs.get ( "test" , "" ) );
            System.out.print ( "Enter new value for \"test\": " );

            newValue = reader.readLine ( );
            userPrefs.put ( "test" , newValue );
            System.out.print ( "New value saved" );
        }
        catch ( IOException ex ) {
            ex.printStackTrace ( );
        }
    }
}
