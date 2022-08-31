package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {
    private static int nextId = 1;
    private final int id;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        if (this.name != null || this.employer != null || this.location != null || this.positionType != null || this.coreCompetency != null) {
            StringBuilder result = new StringBuilder();

            result.append("\n");
            result.append(String.format("ID: %d\n", id));
            result.append(String.format("Name: %s\n", toStringValue(name)));
            result.append(String.format("Employer: %s\n", toStringValue(employer)));
            result.append(String.format("Location: %s\n", toStringValue(location)));
            result.append(String.format("Position Type: %s\n", toStringValue(positionType)));
            result.append(String.format("Core Competency: %s\n", toStringValue(coreCompetency)));

            return result.toString();
        } else {
            return "OOPS! This job does not seem to exist.";
        }
    }

    private String toStringValue(Object value) {
        String text = "";

        if (value != null) {
            if (value instanceof String) {
                text = (String) value;
            } else if (value instanceof Employer) {
                text = ((Employer) value).getValue();
            } else if (value instanceof Location) {
                text = ((Location) value).getValue();
            } else if (value instanceof PositionType) {
                text = ((PositionType) value).getValue();
            } else if (value instanceof CoreCompetency) {
                text = ((CoreCompetency) value).getValue();
            }
        }

        if (text.length() > 0) {
            return text;
        }

        return "Data not available";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
