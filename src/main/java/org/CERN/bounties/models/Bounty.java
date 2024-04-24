package org.CERN.bounties.models;

import jakarta.persistence.Entity;

@Entity
public class Bounty extends AbstractEntity {

    private static String name;

    private static int bounty;

    private static String details;

    private static String location;

    public Bounty() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Bounty.name = name;
    }

    public static int getBounty() {
        return bounty;
    }

    public static void setBounty(int bounty) {
        Bounty.bounty = bounty;
    }

    public static String getDetails() {
        return details;
    }

    public static void setDetails(String details) {
        Bounty.details = details;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        Bounty.location = location;
    }
}
