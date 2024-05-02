import java.util.Scanner;

public class VigenereCipher {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encryptData(String plaintext, String key) {
        plaintext = plaintext.toLowerCase(); 
        key = key.toLowerCase();
        StringBuilder encryptString = new StringBuilder();

        int keyIndex = 0; // Track the current position in the key

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            if (ALPHABET.indexOf(plainChar) == -1) {
                // Ignore non-alphabetic characters
                encryptString.append(plainChar);
                continue;
            }

            char keyChar = key.charAt(keyIndex % key.length());
            int pos = ALPHABET.indexOf(plainChar);
            int poskey = ALPHABET.indexOf(keyChar);
            int encryptPos = (pos + poskey) % 26;
            char encryptChar = ALPHABET.charAt(encryptPos);

            encryptString.append(encryptChar);
            keyIndex++;
        }

        return encryptString.toString();
    }

    public static String decryptData(String ciphertext, String key) {
        ciphertext = ciphertext.toLowerCase();
        key = key.toLowerCase();
        StringBuilder decryptString = new StringBuilder();
    
        int keyIndex = 0; // Track the current position in the key
    
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            if (ALPHABET.indexOf(cipherChar) == -1) {
                // Ignore non-alphabetic characters
                decryptString.append(cipherChar);
                continue;
            }
    
            char keyChar = key.charAt(keyIndex % key.length());
            int pos = ALPHABET.indexOf(cipherChar);
            int poskey = ALPHABET.indexOf(keyChar);
            int decryptPos = (pos - poskey + 26) % 26; // Ensure positive result
            char decryptChar = ALPHABET.charAt(decryptPos);
    
            decryptString.append(decryptChar);
            keyIndex++;
        }
    
        return decryptString.toString();
    }
    
    public static void main(String[] args)   
    {     
        Scanner s = new Scanner(System.in);   
            
        System.out.println("Enter a string for encryption/decryption using Viginere Cipher: ");   
        String plaintext = s.nextLine().toLowerCase();   
          
        System.out.println("Enter the Key: ");   
        String key = s.nextLine().toLowerCase(); 
        System.out.println("Do you want to encrypt or decrypt? (Enter 'E' for encrypt or 'D' for decrypt): ");
        String choice = s.nextLine().toUpperCase();
 
        if (choice.equals("E")) {
            System.out.println("Encrypted Data: " + encryptData(plaintext, key));
        } else if (choice.equals("D")) {
            System.out.println("Decrypted Data: " + decryptData(plaintext, key));
        }  else {
            System.out.println("Invalid choice. Please enter 'E' for encrypt or 'D' for decrypt.");
        }
          
      
          
         
    }   
}