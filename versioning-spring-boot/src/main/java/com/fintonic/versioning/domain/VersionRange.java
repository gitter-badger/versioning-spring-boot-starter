package com.fintonic.versioning.domain;


import org.springframework.util.StringUtils;

/**
 * Indicates the version range.
 *
 * Created by Rafa on 24/01/17.
 */
public class VersionRange {


    private Version from;
    private Version to;

    public VersionRange(String from, String to) {
        if (StringUtils.isEmpty(from)) {
            throw new IllegalArgumentException("Define from in @VersionedResource");
        }
        this.from = new Version(from);
        this.to = new Version(to);
        if (this.from.compareTo(this.to) != -1 && this.from.compareTo(this.to) != 0) {
            throw new IllegalArgumentException("From is minor than to, bad definition");
        }
    }


    public Version getTo() {
        return to;
    }

    public void setTo(Version to) {
        this.to = to;
    }


    public boolean includes(String other) {
        Version otherVersion = new Version(other);

        if (from.compareTo(otherVersion) <= 0 && to.compareTo(otherVersion) >= 0) {
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        return "range[" + from + "-" + to + "]";
    }

}
