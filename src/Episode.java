public class Episode {
    public boolean isWatched;
    private String name;
    private String overview;
    private Date airTime;
    private Account account;

    public Episode(String name, String overview, Date airTime, boolean isWatched) {
        this.name = name;
        this.overview = overview;
        this.airTime = airTime;
        isWatched = false;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getAirTime() {
        return airTime;
    }

    public void setAirTime(Date airTime) {
        this.airTime = airTime;
    }


    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }
}
