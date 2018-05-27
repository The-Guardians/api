package com.paigunna.api.dto;

/**
 * @author armme : 15/03/2018
 */
public class TransacDto {

    private Long id;
    private String timeStart;
    private String timeFinish;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
