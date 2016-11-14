package com.trydevs.cloudletbalancer.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kid on 14/11/16.
 */

public class SystemInfo implements Parcelable {

    private String batteryPercentage;
    private String signalStrength;
    private String latency;
    private String averageCpuUsage;
    private String averageCpuFrequency;
    private String memoryUsage;
    private String mobileId;
    private String energy;
    private String bandWidth;
    private String connectionState;

    public String getAverageCpuFrequency() {
        return averageCpuFrequency;
    }

    public String getAverageCpuUsage() {
        return averageCpuUsage;
    }

    public String getBandWidth() {
        return bandWidth;
    }

    public String getBatteryPercentage() {
        return batteryPercentage;
    }

    public String getConnectionState() {
        return connectionState;
    }

    public String getEnergy() {
        return energy;
    }

    public String getLatency() {
        return latency;
    }

    public String getMemoryUsage() {
        return memoryUsage;
    }

    public String getMobileId() {
        return mobileId;
    }

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setAverageCpuFrequency(String averageCpuFrequency) {
        this.averageCpuFrequency = averageCpuFrequency;
    }

    public void setAverageCpuUsage(String averageCpuUsage) {
        this.averageCpuUsage = averageCpuUsage;
    }

    public void setBandWidth(String bandWidth) {
        this.bandWidth = bandWidth;
    }

    public void setBatteryPercentage(String batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void setConnectionState(String connectionState) {
        this.connectionState = connectionState;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    public void setMemoryUsage(String memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.batteryPercentage);
        dest.writeString(this.signalStrength);
        dest.writeString(this.latency);
        dest.writeString(this.averageCpuUsage);
        dest.writeString(this.averageCpuFrequency);
        dest.writeString(this.memoryUsage);
        dest.writeString(this.mobileId);
        dest.writeString(this.energy);
        dest.writeString(this.bandWidth);
        dest.writeString(this.connectionState);
    }

    public SystemInfo() {
    }

    protected SystemInfo(Parcel in) {
        this.batteryPercentage = in.readString();
        this.signalStrength = in.readString();
        this.latency = in.readString();
        this.averageCpuUsage = in.readString();
        this.averageCpuFrequency = in.readString();
        this.memoryUsage = in.readString();
        this.mobileId = in.readString();
        this.energy = in.readString();
        this.bandWidth = in.readString();
        this.connectionState = in.readString();
    }

    public static final Creator<SystemInfo> CREATOR = new Creator<SystemInfo>() {
        @Override
        public SystemInfo createFromParcel(Parcel source) {
            return new SystemInfo(source);
        }

        @Override
        public SystemInfo[] newArray(int size) {
            return new SystemInfo[size];
        }
    };
}
