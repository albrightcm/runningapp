package ude.esom.runningapp;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PastRun extends RealmObject {
    @PrimaryKey private String id;
    @Required private Date datePerformed;
    private double distanceTraveled;
    private double averageSpeed;
    private double minSpeed;
    private double maxSpeed;
    private int seconds;
    private int caloriesBurned;

    public PastRun() { }
    public PastRun(double distanceTraveled, double averageSpeed, double minSpeed, double maxSpeed, int caloriesBurned, int seconds)
    {
        this.id = UUID.randomUUID().toString();
        this.datePerformed = new Date();
        this.distanceTraveled = distanceTraveled;
        this.averageSpeed = averageSpeed;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.caloriesBurned = caloriesBurned;
        this.seconds = seconds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatePerformed() {
        return datePerformed;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public int getSeconds() { return seconds; }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void setSeconds(int seconds) { this.seconds = seconds; }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }
}


