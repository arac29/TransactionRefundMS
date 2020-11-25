package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.Event;

public interface EventDAO {
	public void createEvent(Event event);
	
	public Event readEvent(int eventId);
	
	public List<Event> readAllEvents();

	public int deleteEvent(int eventId);

	public int updateEvent(int eventId, Event event);
}