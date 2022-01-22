package singleInheritance;

public class Donor extends Person {
	private String bloodBankName;
	private String donorType;
	private String donationDate;

	public String getBloodBankName() {
		return bloodBankName;
	}

	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}

	public String getDonorType() {
		return donorType;
	}

	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	public void displayDonationDetails() {
		System.out.println("Donation Details : " + System.lineSeparator() + super.toString() + System.lineSeparator()
				+ "Blood Bank Name : " + bloodBankName + System.lineSeparator() + "Donor Type : " + donorType
				+ System.lineSeparator() + "Donation Date : " + donationDate);
	}
}
