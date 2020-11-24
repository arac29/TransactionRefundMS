package TransactionRefundMS.pojos;

public class Event {
	
	private int eventId;
	private int eventTypeId; 
	private String name;
	private String description;
	private String startDate;
	private String endDate;
	private String hoursDedicatedEvent;
	private String location;
	private String cost; 
	private String gradingFormatEvent;
	private int gradingFormatId;
	private int gradeId;
	
	
	
	public Event(int eventId, int eventTypeId, String name, String description, String startDate, String endDate,
			String hoursDedicatedEvent, String location, String cost, String gradingFormatEvent, int gradingFormatId,
			int gradeId) {
		super();
		this.eventId = eventId;
		this.eventTypeId = eventTypeId;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hoursDedicatedEvent = hoursDedicatedEvent;
		this.location = location;
		this.cost = cost;
		this.gradingFormatEvent = gradingFormatEvent;
		this.gradingFormatId = gradingFormatId;
		this.gradeId = gradeId;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getHoursDedicatedEvent() {
		return hoursDedicatedEvent;
	}
	public void setHoursDedicatedEvent(String hoursDedicatedEvent) {
		this.hoursDedicatedEvent = hoursDedicatedEvent;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getGradingFormatEvent() {
		return gradingFormatEvent;
	}
	public void setGradingFormatEvent(String gradingFormatEvent) {
		this.gradingFormatEvent = gradingFormatEvent;
	}
	public int getGradingFormatId() {
		return gradingFormatId;
	}
	public void setGradingFormatId(int gradingFormatId) {
		this.gradingFormatId = gradingFormatId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventTypeId=" + eventTypeId + ", name=" + name + ", description="
				+ description + ", startDate=" + startDate + ", endDate=" + endDate + ", hoursDedicatedEvent="
				+ hoursDedicatedEvent + ", location=" + location + ", cost=" + cost + ", gradingFormatEvent="
				+ gradingFormatEvent + ", gradingFormatId=" + gradingFormatId + ", gradeId=" + gradeId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + eventId;
		result = prime * result + eventTypeId;
		result = prime * result + gradeId;
		result = prime * result + ((gradingFormatEvent == null) ? 0 : gradingFormatEvent.hashCode());
		result = prime * result + gradingFormatId;
		result = prime * result + ((hoursDedicatedEvent == null) ? 0 : hoursDedicatedEvent.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventTypeId != other.eventTypeId)
			return false;
		if (gradeId != other.gradeId)
			return false;
		if (gradingFormatEvent == null) {
			if (other.gradingFormatEvent != null)
				return false;
		} else if (!gradingFormatEvent.equals(other.gradingFormatEvent))
			return false;
		if (gradingFormatId != other.gradingFormatId)
			return false;
		if (hoursDedicatedEvent == null) {
			if (other.hoursDedicatedEvent != null)
				return false;
		} else if (!hoursDedicatedEvent.equals(other.hoursDedicatedEvent))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
	
	
	
}
