package com.capgemini.setcase.controller.dto;

public class DashboardDTO {

    private int watched;
    private int unwatched;

    public DashboardDTO(int watched, int unwatched) {
        this.watched = watched;
        this.unwatched = unwatched;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public int getUnwatched() {
        return unwatched;
    }

    public void setUnwatched(int unwatched) {
        this.unwatched = unwatched;
    }
}
