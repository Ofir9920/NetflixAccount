import java.util.Scanner;

public class Account {
    private String user_name;
    private String password;
    private Episode[] episode;
    private Date creation;
    private Date expire;

    public Account(String user_name, String password, Episode[] episode, Date creation, Date expire) {
        this.user_name = user_name;
        this.password = password;
        this.episode = episode;
        this.creation = creation;
        this.expire = expire;


        Scanner scanner = new Scanner(System.in);
        this.password = password;
        while(!isStrongPassword(this.password)) {
            System.out.println("Enter Strong Password at least one letter and one digit");
            //scanner.nextLine();
            this.password = scanner.nextLine();
        }
    }

    public boolean isStrongPassword(String password) {
        if(password.length() < 6)
            return false;
        char[] pass  = password.toCharArray();
        int dig_count = 0 , char_count = 0;
       for(int i = 0; i < password.length(); i++) {
            if (Character.isDigit(pass[i]))
                dig_count++;
            if (Character.isAlphabetic(pass[i]))
                char_count++;
       }
        return (dig_count > 0 && char_count > 0);
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Episode[] getEpisode() {
        return episode;
    }

    public void setEpisode(Episode[] episode) {
        this.episode = episode;
    }
}
