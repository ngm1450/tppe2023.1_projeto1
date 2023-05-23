package org.unb.tppe.model.util;

import java.util.Random;

public class Util {

    public static String getDummyString() {
        Random random = new Random();
        String CHARACTERS = "ABCDEFGHIJKLM NOPQRSTUVWXYZabcdefghi jklmnopqrs tuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < random.nextInt(); i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
