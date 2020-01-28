​package domain;

import java.sql.Date;

public class Movie implements java.io.Serializable {

    String movName;
    int movId;
    Date movDate;
    int movRate;
    int dirId;

    public Movie() {
        this("", -1, null, -1, -1);
    }

    public Movie(String movName, int movId, Date movDate, int movRate) {
        this.movName = movName;
        this.movId = movId;
        this.movDate = movDate;
        this.movRate = movRate;
    }

    public String getMovName() {
        return movName;
    }

    public void setMovName(String movName) {
        this.movName = movName;
    }

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public Date getMovDate() {
        return movDate;
    }

    public void setMovDate(Date movDate) {
        this.movDate = movDate;
    }

    public int getMovRate() {
        return movRate;
    }

    public void setMovRate(int movRate) {
        this.movRate = movRate;
    }

    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

}