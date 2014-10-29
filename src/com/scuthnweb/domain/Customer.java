package com.scuthnweb.domain;

public class Customer extends BaseCustomer {
		
		private String email,grade,major,room;
		
		private int    sex,phone,qq;		               
		
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getMajor() {
			return major;
		}

		public void setMajor(String major) {
			this.major = major;
		}

		public String getRoom() {
			return room;
		}

		public void setRoom(String room) {
			this.room = room;
		}

		public int getSex() {
			return sex;
		}
		public void setSex(int sex) {
			this.sex = sex;
		}

		public int getPhone() {
			return phone;
		}
		public void setPhone(int phone) {
			this.phone = phone;
		}

		public int getQq() {
			return qq;
		}

		public void setQq(int qq) {
			this.qq = qq;
		}

		public void setAll( String customer_name, 
                            int customer_id,
                            int customer_sex, 
                            String customer_email, 
                            String customer_grade,
                            String customer_major, 
                            int customer_phone, 
                            int customer_qq,
                            String customer_room ){
			
			this.setName (customer_name);
			this.setId   (customer_id);
			this.setSex  (customer_sex); 
			this.setEmail(customer_email); 
			this.setGrade(customer_grade);
			this.setMajor(customer_major); 
			this.setPhone(customer_phone); 
			this.setQq   (customer_qq);
			this.setRoom (customer_room);
		}
		
		
		public Customer getAll(){
			return this;
		}
		
}
