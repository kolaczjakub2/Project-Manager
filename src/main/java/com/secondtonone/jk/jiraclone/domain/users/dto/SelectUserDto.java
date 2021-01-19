package com.secondtonone.jk.jiraclone.domain.users.dto;

import java.util.UUID;

public class SelectUserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;

    public static SelectUserDto.Builder builder() {
        return new Builder();
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private String username;

        public Builder withId(UUID id) {
            this.id = id;
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

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public SelectUserDto build() {
            SelectUserDto dto = new SelectUserDto();
            dto.id = this.id;
            dto.firstName = this.firstName;
            dto.lastName = this.lastName;
            dto.username = this.username;
            return dto;
        }
    }
}
