package org.example.systemController;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class BrowserController {



    private void readDB(String path) throws Exception {

        List<UserData> userData = new ArrayList<UserData>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:\\" + path + "\\Default\\Login Data";

        Connection connection = DriverManager.getConnection(url);


        ResultSet result = connection.createStatement().executeQuery("select signon_realm,username_value,password_value from logins");

        while (result.next()) {
            UserData user = new UserData();

            user.url = result.getString(1);
            user.username = result.getString(2);

            user.password = "0";

            userData.add(user);
        }

        userData.forEach(data -> {
            System.out.println("Url: " + data.url);
            System.out.println("Username: " + data.username);
            System.out.println("Password: " + data.password);
        });
    }

    private static String decodePassword(byte[] passwordValue, byte[] key) throws Exception {
        byte[] iv = new byte[12];
        System.arraycopy(passwordValue, 3, iv, 0, 12);

        byte[] encrypted = Arrays.copyOfRange(passwordValue, 15, passwordValue.length);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
        byte[] result = cipher.doFinal(encrypted);

        return new String(result, StandardCharsets.UTF_8);
    }


}

class UserData
{
    String url;
    String username;
    String password;

}
