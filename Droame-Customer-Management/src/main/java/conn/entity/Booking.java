package conn.entity;

public class Booking {
	private int booking_id;
	private String drone_shot_id;
	private String location_id;
	private String created_time;
	
	public Booking() {
		super();
		
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getDrone_shot_id() {
		return drone_shot_id;
	}

	public void setDrone_shot_id(String drone_shot_id) {
		this.drone_shot_id = drone_shot_id;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public Booking(int booking_id, String drone_shot_id, String location_id, String created_time) {
		super();
		this.booking_id = booking_id;
		this.drone_shot_id = drone_shot_id;
		this.location_id = location_id;
		this.created_time = created_time;
	}
	

}
