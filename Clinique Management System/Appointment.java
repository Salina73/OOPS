package clinique.bridgelab;

import java.util.Date;

public class Appointment
{ 
	Integer did;
	Date date;
	
	public Appointment(int did,Date date)
	{ 
		this.did=did;
		this.date=date;
	}
	
	public int getDid() 
	{
		return did;
	}
	public void setDid(int did) 
	{
		this.did = did;
	}

	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}

	public String toString() 
	{
		return "Appointment of did=" + did + ", date=" + date+"\n";
	}

	public int hashCode()
	{
    	return this.did.hashCode()+this.date.hashCode();
	}
	
	public boolean equals(Object object)
	{
    	if (object == null) 
			return false;
    	if (object == this) 
			return true;
    	if (!(object instanceof Appointment))
			return false;
    	
    	Appointment da = (Appointment) object;

		if((this.did==da.did) && (this.date.equals(da.date)))
			return true;
		else
			return false;
	}
}
