package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="jersey_number")
    private int jerseyNumber;

    @Column(name="nickname")
    private String nickname;

    @Column(name="twitter")
    private String twitter;

    @Column(name="instagram")
    private String instagram;

    public Player() {}

    public int getId() {
        return id;
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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getJerseyNumber() { return jerseyNumber; }

    public void setJerseyNumber(int jerseyNumber) { this.jerseyNumber = jerseyNumber; }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getTwitter() { return twitter; }

    public void setTwitter(String twitter) { this.twitter = twitter; }

    public String getInstagram() { return instagram; }

    public void setInstagram(String instagram) { this.instagram = instagram; }
}


