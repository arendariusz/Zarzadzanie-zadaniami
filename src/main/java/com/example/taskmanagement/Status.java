package com.example.taskmanagement;

public enum Status {
    REALIZED("Zrealizowano"), NOT_REALIZED("Do realizacji");

    private String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
