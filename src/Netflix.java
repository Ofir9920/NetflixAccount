public class Netflix {
    private Series[] series;
    private Account[] accounts;
    private int lastIndex;



    public Netflix(Series[] series) {
        this.accounts = new Account[20];
        this.series = series;
        this.lastIndex = 0;
    }

    public void addAccount(Account account) {
        this.accounts[lastIndex] = account;
        lastIndex++;
    }

    public Series[] getSeries() {
        return series;
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
