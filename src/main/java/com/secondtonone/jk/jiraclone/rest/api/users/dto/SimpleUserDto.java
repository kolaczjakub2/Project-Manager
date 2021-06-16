package com.secondtonone.jk.jiraclone.rest.api.users.dto;


import java.util.UUID;

public class SimpleUserDto {
    private UUID id;
    private String firstName;
    private String lastName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        private UUID id;
        private String firstName;
        private String lastName;

        public Builder withId(UUID userID) {
            this.id = userID;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }


        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SimpleUserDto build() {
            SimpleUserDto dto = new SimpleUserDto();
            dto.id = this.id;
            dto.firstName = this.firstName;
            dto.lastName = this.lastName;
            return dto;
        }
    }
}
