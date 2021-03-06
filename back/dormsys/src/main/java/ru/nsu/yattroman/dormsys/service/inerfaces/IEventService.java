package ru.nsu.yattroman.dormsys.service.inerfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.nsu.yattroman.dormsys.DTO.metainfo.ClubEventsAvg;
import ru.nsu.yattroman.dormsys.DTO.metainfo.EventBoardElement;
import ru.nsu.yattroman.dormsys.entity.Event;
import ru.nsu.yattroman.dormsys.entity.clubs.Club;

import java.util.List;

public interface IEventService {
    Event addEventByClub(Event event, Long clubId);
    Event showEventDetails(Long eventId);
    Page<Event> showEventsPageFiltered(Specification<Event> specification, Pageable pageable);
    void enrollUserToEvent(Long eventId, Long userId);
    void unenrollUserFromEvent(Long eventId, Long userId);
    List<Event> getEventsByUser(Long userId);
    List<Event> getEventsByClub(Long clubId);
    List<Event> getUpcomingEventsByClub(Long clubId);
    List<EventBoardElement> getTopPopularEventsWithParticipantsRange(int n, long participantsMin, long participantsMax);
    List<EventBoardElement> getClosestEvents();
}
