package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.EventDAO;
import TransactionRefundMS.pojos.Event;
import TransactionRefundMS.util.ConnectionUtil;

public class EventDAOPostgres implements EventDAO{
	
	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	@Override
	public int createEvent(Event event) {
		
		String sql = "insert into event (event_type_id, name, description, start_date, end_date, location,"
				+ " grading_format_id)" + "values(?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, event.getEventTypeId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setString(4, event.getStartDate());
			stmt.setString(5,event.getEndDate());
			stmt.setString(6, event.getLocation());
			stmt.setInt(7, event.getGradingFormatId());
			stmt.executeUpdate();

			log.info("Controller creating event");

		} catch (SQLException e) {
			e.printStackTrace();
			log.info("error  dao posgres event");
		}
		
		String sqli = "select * from event where name = '" + event.getName() + "';";
		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sqli);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int eventId = rs.getInt("event_id");

				event.setEventId(eventId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event.getEventId();

	}

	@Override
	public Event readEvent(int eventId) {
		String sql = "select * from event where event_id = " + eventId;

		Event event = new Event();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read event by id = " + eventId);

			while (rs.next()) {

				eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String hoursDedicatedEvent = rs.getString("total_hours_on_event");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setHoursDedicatedEvent(hoursDedicatedEvent);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setGradeId(gradeId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

	@Override
	public List<Event> readAllEvents() {
		List<Event> eventList = new ArrayList();

		String sql = "select * from event";

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read all event types");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String hoursDedicatedEvent = rs.getString("total_hours_on_event");
				String location = rs.getString("location");
	
				int gradingFormatId = rs.getInt("grading_format_id");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setHoursDedicatedEvent(hoursDedicatedEvent);
				event.setLocation(location);

				event.setGradingFormatId(gradingFormatId);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public int updateEvent(int eventId, Event event) {

		String sql = "update event"
				+ "set event_type_id = ?, name = ?, description = ?, start_date = ?, end_date = ?, total_hours_on_event = ?, location = ?,"
				+ "grading_format_id = ?, grade_id = ?" 
				+ "where event_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, event.getEventTypeId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setDate(4, Date.valueOf(event.getStartDate()));
			stmt.setDate(5, Date.valueOf(event.getEndDate()));
			stmt.setTime(6, Time.valueOf(event.getHoursDedicatedEvent()));
			stmt.setString(7, event.getLocation());
			stmt.setInt(8, event.getGradingFormatId());
			stmt.setInt(9, event.getGradeId());
			stmt.setInt(10, event.getEventId());

			rows = stmt.executeUpdate();

			log.info("Controller updating event by eventId = " + eventId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteEvent(int eventId) {
		
		String sql = "delete from event where event_id = ?";

		int rowsToDelete = 0;

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, eventId);

			rowsToDelete = stmt.executeUpdate();

			log.info("Controller deleting event by eventId = " + eventId);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;

	}

	@Override
	public List<Event> readEventById(int employee_id) {
		List<Event> eventList = new ArrayList();

		String sql = "select r.employee_id, e.event_id, e.event_type_id, e.\"name\", e.description, e.start_date, e.end_date, e.\"location\", e.grading_format_id, e.grade_id "
				+ "from reimbursement r "
				+ "join \"event\" e "
				+ "on r.event_id = e.event_id "
				+ "where employee_id = ?;";


		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,employee_id);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read all events by employee");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
	
				int gradingFormatId = rs.getInt("grading_format_id");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);

				event.setGradingFormatId(gradingFormatId);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}


}
