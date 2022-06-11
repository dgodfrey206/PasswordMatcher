Password Matcher
=========
![](https://github.com/dgodfrey206/PasswordMatcher/blob/main/output.jpg)

<h2>Usage:</h2>

    public static HashSet<String> passwords = new HashSet<>();

We just need to populate the `HashSet` by reading all the records from the .txt

    public static void readPasswords(String filename){
       try (BufferedReader br = new BufferedReader(new FileReader(filename)))
       {

           String sCurrentLine;
           while ((sCurrentLine = br.readLine()) != null)
           {
               LoginFrame.passwords.add(sCurrentLine);
           }
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }

Once It’s populated we can simply query the `HashSet` to find a specific “String”.

    String pwdText = passwordField.getText();

    // Check if entered password exists in Hashset
    if (LoginFrame.passwords.contains(pwdText)) {
       JOptionPane.showMessageDialog(this, "Password found !!");
    }
    else {
       JOptionPane.showMessageDialog(this, "Password not found !!");
    }
