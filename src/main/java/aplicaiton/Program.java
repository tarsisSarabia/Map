/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaiton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarsi
 */
public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> cand = new LinkedHashMap<>();
        System.out.println("Entrer a file full path: ");
        String path = sc.nextLine();
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name=fields[0];
                int count = Integer.parseInt(fields[1]);
                if (cand.containsKey(name)){
                    int votos = cand.get(name);
                    cand.put(name, votos+count);
                }else{
                    cand.put(name, count);
                }
                line=br.readLine();
            }
            for (String key : cand.keySet()) {
                System.out.println(key + ":" + cand.get(key));

            }

        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
