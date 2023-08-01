package com.project.banking.admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff_info")
public class StaffInfo {
	@Id
	@Column(name = "satff_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffId;

	@Column(name = "staff_name")
	private String staffName;
	@Column(name = "staff_role")
	private String staff_role;

	protected StaffInfo() {
		super();
		
	}

	protected StaffInfo(String staffName, String staff_role) {
		super();
		this.staffName = staffName;
		this.staff_role = staff_role;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaff_role() {
		return staff_role;
	}

	public void setStaff_role(String staff_role) {
		this.staff_role = staff_role;
	}

}
