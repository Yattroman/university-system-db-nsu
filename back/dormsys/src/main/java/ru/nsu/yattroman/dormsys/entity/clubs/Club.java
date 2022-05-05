package ru.nsu.yattroman.dormsys.entity.clubs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.yattroman.dormsys.entity.Event;
import ru.nsu.yattroman.dormsys.entity.User;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String uniqueName;

    // TODO: add tags
    // TODO: add photo
    // TODO: add meetings time

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private ClubManager clubManager;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;

    @ManyToMany
    @JoinTable(name = "club_participants",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> participants;

}
