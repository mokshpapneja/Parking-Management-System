package com.entity;

public class SlotDtls {
		private int Id;
		private String Location;
		private String Time;
		private String price;
		private String status;

		public SlotDtls() {
			super();
			
		}

		public SlotDtls(int Id,String Location, String Time, String price, String status) {
			super();
			this.Id=Id;
			this.Location = Location;
			this.Time = Time;
			this.price = price;
			this.status = status;
		}

		public int getId() {
			return Id;
		}

		public void setId(int Id) {
			this.Id = Id;
		}

		public String getLocation() {
			return Location;
		}

		public void setLocation(String Location) {
			this.Location = Location;
		}

		public String getTime() {
			return Time;
		}

		public void setTime(String Time) {
			this.Time = Time;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}


		@Override
		public String toString() {
			return "SlotDtls [Id=" + Id + ", Location=" + Location + ", Time=" + Time + ", price=" + price
					+ ", status=" + status + "]";
		}

}
