import java.util.Scanner;

public class Main {

    private static Netflix netflix;


    public static void main(String[] args) {

        Episode episode1 = new Episode("Episode 1", "Episode 1 of friends", new Date(22, 6, 2000), true);
        Episode episode2 = new Episode("Episode 2", "Episode 2 of friends", new Date(23, 6, 2000), true);
        Episode episode3  = new Episode("Episode 3", "Episode 3 of friends", new Date(24, 6, 2000), true);
        Episode[] episodes = { episode1, episode2, episode3 };

        Series series1 = new Series("Friends", episodes);
        Series series2 = new Series("The punisher", episodes);

        Account acc1 = new Account("ofir123", "123456d",episodes , new Date(6, 6, 2021), new Date(6, 7, 2021));

        netflix = new Netflix(new Series[]{series1, series2});
        netflix.addAccount(acc1);


        showMainMenu();
        menu();


        System.out.println("done");
    }


    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Create a new account\n" + "2.Log in to an existing account");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            signUp();

        } else if (option == 2) {
            signIn();
        }
    }


        public static void menu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("1. Show series list");
        System.out.println("2. Show watched series list");
        System.out.println("3. Account details ");
        System.out.println("4. Choose a series ");
        System.out.println("5. Logout");
        System.out.println("================================");

            String isContinue = "y";
            while (isContinue.equals("y")) {
                int chose = scanner.nextInt();
                if (chose == 1) {
                    showSeries();
                } else if (chose == 2) {
                    watchedSeries();
                } else if (chose == 3) {
                    accountDetails();
                } else if (chose == 4) {

                } else if (chose == 5) {
                   backToMenu();
                   menu();
                }
            }
    }


    public static void signUp () {
        Scanner scanner = new Scanner(System.in);
        String username;
            boolean userNameExist;
            do {
                userNameExist = false;
                System.out.println("Please insert your username:");
                username = scanner.nextLine();
                for (Account account : netflix.getAccounts()) {
                    if (username.equals(account.getUser_name())) {
                        System.out.println("The username is already taken!");
                        userNameExist = true;
                    }
                    break;
                }
            } while (userNameExist);

            System.out.println("Please insert your password:");
            String password = scanner.nextLine();
            Account account = new Account(username, password, null, new Date(6, 6, 2021), new Date(6, 6, 2022));
            netflix.addAccount(account);
            System.out.println("accepted!");
        }


        public static void signIn () {
        Scanner scanner = new Scanner(System.in);
        boolean accountExist;
            do {
                accountExist = false;
                System.out.println(" Insert your user name \n and password: ");
                String userName = scanner.nextLine();
                String password1 = scanner.nextLine();
                for (Account account : netflix.getAccounts()) {
                    if (!userName.equals(account.getUser_name()) || !password1.equals(account.getPassword())) {
                        System.out.println(" Wrong! try again ");
                        break;
                    }
                    System.out.println(" Welcome " + userName);
                break;
                }
            } while (accountExist);
        }


    public static void showSeries() {
        for (Series series : netflix.getSeries() ) {
            System.out.println(series.getName());
        }
    }


    public static void watchedSeries () {
        Episode episode1 = new Episode("Episode 1", "Episode 1 of friends", new Date(22, 6, 2000), true);
        Episode episode2 = new Episode("Episode 2", "Episode 2 of friends", new Date(23, 6, 2000), true);
        Episode episode3 = new Episode("Episode 3", "Episode 3 of friends", new Date(24, 6, 2000), true);

        Episode[] episodes = {episode1,episode2,episode3};
        Account acc1 = new Account("ofir123", "123456d",episodes , new Date(6, 6, 2021), new Date(6, 7, 2021));

        for (int i=0; i<episodes.length; i++) {
            if (acc1.getEpisode() != null  ) {
                System.out.println(episodes[i].getOverview());
            }
        }
    }


    public static void accountDetails() {
        Episode episode1 = new Episode("Episode 1", "Episode 1 of friends", new Date(22, 6, 2000), true);
        Episode episode2 = new Episode("Episode 2", "Episode 2 of friends", new Date(23, 6, 2000), true);
        Episode episode3 = new Episode("Episode 3", "Episode 3 of friends", new Date(24, 6, 2000), true);

        Episode[] episodes = {episode1,episode2,episode3};
        Account acc1 = new Account("ofir123", "123456d",episodes , new Date(6, 6, 2021), new Date(6, 7, 2021));
        int number;
        System.out.println("The date of this account creation is: " + acc1.getCreation() + "\n" +
                "The date of this account will expire is: " + acc1.getExpire() + "\n" +
                "number of episodes this account has watched: " + acc1.getEpisode().length);
    }


    public static void backToMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For go back to the menu insert 'y' ");
        String toContinue = scanner.nextLine();
    }


}
