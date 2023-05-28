/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaapps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Augusto Kussema
 * @github https://www.github.com/devkussema
 * @email dev.kussema@gmail.com
 * @country Angola
 */
public class ListaApps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("reg query HKLM\\Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall /s");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("DisplayName")) {
                    String[] parts = line.split("    ");
                    if (parts.length > 2) {
                        String displayName = parts[parts.length - 1].trim();
                        System.out.println(displayName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
